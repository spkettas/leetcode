-- student
drop table if exists student;
CREATE TABLE student
(
    sid VARCHAR(32),
    sname VARCHAR(32), 
    sage INT, 
    ssex VARCHAR(8)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists course;
CREATE TABLE course
(
    cid VARCHAR(32), 
    cname VARCHAR(32), 
    tid VARCHAR(32)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists sc;
CREATE TABLE sc
( 
    sid VARCHAR(32), 
    cid VARCHAR(32), 
    score INT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists teacher;
CREATE TABLE teacher
( 
    tid VARCHAR(32), 
    tname VARCHAR(16) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 老师下的学生(sql传递，非select字段但是可引用)
select s.sname from student s, teacher t, course cu, sc sc 
where s.sid = sc.sid 
and sc.cid = cu.cid
and cu.tid = t.tid
and t.tname = '叶平';

-- join
select s.sname from student s
inner join sc sc on s.sid = sc.sid
inner join course cu on sc.cid = cu.cid
inner join teacher t on cu.tid = t.tid
where t.tname = '叶平';

-- 课程1比课程2成绩高的学生编号
select a.sid from (select sid, score from sc where cid='1') a,
(select sid, score from sc where cid='2') b
where a.score > b.score and a.sid = b.sid;

-- 查询平均成绩大于 60 分的同学的学号和平均成绩(having)
select sid, avg(score) from sc group by sid having avg(score)>60;

-- 查询所有同学的学号、姓名、选课数、总成绩
select s.sid,s.sname,count(sc.cid),sum(sc.score) from student s 
inner join sc sc on s.sid = sc.sid group by s.sid;

-- 查询没有学全所有课的同学的学号、姓名(having count()<)
select s.sid, s.sname from student s, sc sc 
where s.sid = sc.sid group by s.sid, s.sname 
having count(sc.cid) < (select count(cid) from sc);


-- 查询至少有一门课与学号为 “1” 的同学所学相同的同学的学号和姓名(<>)
select distinct(s.sid), s.sname from student s, sc sc 
where s.sid = sc.sid and s.sid<>'1'
and cid in (select cid from sc where sid='1');

-- 删除学习 “叶平” 老师课的 SC 表记录(条件传导)
delete from sc where cid in (
	select distinct(cid) from  (
		select sc.cid from teacher t, course cu, sc sc  
		where t.tid=cu.tid and cu.cid=sc.cid and t.tname='叶平'
		)
);


-- 把 “SC” 表中 “叶平” 老师教的课的成绩都更改为此课程的平均成绩(可直接用后面查询的结果sc.cid)
update sc set score=(select avg(sc1.score) from sc1 where sc1.cid=sc.cid) 
where sc.cid in (
	select sc.cid from teacher t, course cu, sc sc 
	where t.tid = cu.tid and cu.cid = sc.cid and t.tname='叶平'
)

-- 查询和 “2” 号的同学学习的课程完全相同的其他同学学号和姓名
select s.sid, s.sname from student s where s.sid in (
	select sid from sc where cid in (select cid from sc where sid='2')
	group by sid having count(*) = (select count(*) from sc where sid='2')
);

-- 向 SC 表中插入一些记录，这些记录要求符合以下条件：1、没有上过编号 “2” 课程的同学学号；2、插入 “2” 号课程的平均成绩

-- 按平均成绩从高到低显示所有学生的 “语文”、”数学”、”英语” 三门的课程成绩，按如下形式显示：学生ID，语文，数学，英语，有效课程数，有效平均分

-- 查询各科成绩最高和最低的分：以如下形式显示：课程ID，最高分，最低分
select cid as 课程id, max(score) as 最高分, min(score) 最低分 from sc group by cid;
-- 查询姓 “李” 的老师的个数
select count(tid) from teacher where tname like '叶%';


-------------------------------------------------------------------------------------
truncate student;
truncate teacher;
truncate course;
truncate sc;

insert into student 
select '1', '刘一', 18, '男'
union all select '2', '钱二', 19, '女'
union all select '3', '张三', 17, '男'
union all select '4', '李四', 18, '女'
union all select '5', '王五', 17, '男'
union all select '6', '赵六', 19, '女';

insert into teacher
select 1, '叶平'
union all select 2, '贺高'
union all select 3, '杨艳'
union all select 4, '周磊';

insert into course
select '1', '语文', '1'
union all select '2', '数学', '2'
union all select '3', '英语', '3'
union all select '4', '物理', '4';

insert into sc 
select '1', '1', 56 
union all select '1', '2', 78
union all select '1', '3', 67
union all select '1', '4', 58
union all select '2', '1', 79
union all select '2', '2', 81
union all select '2', '3', 92
union all select '2', '4', 68
union all select '3', '1', 91
union all select '3', '2', 47
union all select '3', '3', 88
union all select '3', '4', 56
union all select '4', '2', 88
union all select '4', '3', 90
union all select '4', '4', 93
union all select '5', '1', 46
union all select '5', '3', 78
union all select '5', '4', 53
union all select '6', '1', 35
union all select '6', '2', 68
union all select '6', '4', 71;


