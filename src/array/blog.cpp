/**
 * 寻找发帖王 from <编程之美>
 *
 * 1.寻找发帖>1/2的人。数字定理，++ -- 最多的人终将剩下
 * 2.寻找发贴>1/4的三人
 */

#include <stdio.h>

/**
 * @brief 寻找发帖为1/2的id
 *         每次删除1个帖子，1/2的帖子终将剩下
 */
int findBlog(int id[], int len) {
    int nTimes = 0; // 出现次数
    int candidate = -1;

    for (int i=0; i<len; i++) {
        if (nTimes == 0) {  // init
            candidate = id[i];
            nTimes = 1;
        } else {    // update
            if (candidate == id[i]) {
                nTimes++;
            } else {
                nTimes--;
            }
        }
    }

    return candidate;
}

/**
 * @brief 寻找出现帖子1/4的3个帖子，与上述类似
 *
 */
int* findBlog1(int id[], int len) {
    int id1Times = 0, id2Times = 0, id3Times = 0;
    int can1 = -1, can2 = -1, can3 = -1;

    for (int i=0; i<len; i++) {
        if (id1Times == 0) {
            can1 = id[i];
            id1Times++;
        }
        else if (id2Times == 0) {
            can2 = id[i];
            id2Times++;
        }
        else if (id3Times == 0) {
            can3 = id[i];
            id3Times++;
        } else {
            if (id[i] == can1) {
                id1Times++;     // &&&
            }
            else if (id[i] == can2) {
                id2Times++;
            }
            else if (id[i] == can3) {
                id3Times++;
            } else {
                id1Times--;
                id2Times--;
                id3Times--;
            }
        }
    }

    // copy
    int *candi = new int[3];
    candi[0] = can1;
    candi[1] = can2;
    candi[2] = can3;
    return candi;
}


int main(int argc, char **argv) {
    int id[] = {3, 8, 8, 8, 6, 8, 10, 8};
    int candi = findBlog(id, 8);
    printf("1/2 candi=%d\n", candi);

    int id1[] = {3, 8, 3, 8, 6, 8, 9, 18, 3, 8, 9, 9, 15, 14, 3, 9};
    int *candis = findBlog1(id1, 16);
    for (int i=0; i<3; i++) {
        printf("1/4 candi=%d\n", candis[i]);
    }

    return 0;
}