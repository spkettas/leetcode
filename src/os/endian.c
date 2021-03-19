/**
 * Copyright (c) 1998-2020 TENCENT Inc. All rights reserved.
 *
 * @file endian.c
 * @author kanesun (kanesun@tencent.com)
 * @date 2021-01-17
 *
 * @brief 判断大小端
 */
#include <stdio.h>

int checkCPU() {
    union w {
        int a;
        char b; // 高位放低位值
    } c;

    c.a = 1;
    return (c.b == 1);  // 小端
}

int main(int argc, char **argv)
{
    int flag = checkCPU();
    printf("os: %d\n", flag);
    return 0;
}


