"""
python 版计算器，支持字符串表达式

1. 思路: 每次遇到下一个符号时，处理上一个操作数
符号分：数字 and 符号
用栈存放操作数 +10, -10, *10
() 用递归求解

date: 2020/2/11
author: kanesun
"""


def helper(s: list) -> int:
    stack = []  # 栈存放操作数
    sign = '+'  # last sign
    num = 0  # last num

    while len(s):
        c = s.pop(0)  # 遍历

        # 处理数字
        if c.isdigit():
            #num = num * 10 + (c - '0')
            num = num * 10 + int(c)
            pass

        if c == '(':
            num = helper(s)     # 递归求括号内值

        # 处理符号
        if (not c.isdigit() and c != ' ') or len(s) == 0:
            if sign == '+':
                stack.append(num)
            elif sign == '-':
                stack.append(-num)
            elif sign == '*':
                stack[-1] = stack[-1] * num
            elif sign == '/':
                stack[-1] = int(stack[-1]) / float(num)
            pass

            sign = c    # &&&
            num = 0

        if c == ')': break
    return sum(stack)  # &&& sum(list)


def calc(exp: str) -> int:
    return helper(list(exp))


if __name__ == '__main__':
    val = calc('1*4+(5*6-20)/2')
    print("val=", val)
    pass
