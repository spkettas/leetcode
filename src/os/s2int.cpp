/**
 * 字符串工具库
 *
 * 1. atoi  判断溢出条件
 *    超过最大值取最大，比最小值小取最小
 *    遇到异常时，取正常部分
 * 2. itoa  转换后倒置
 */

#include <stdio.h>
#include <string>
#include <stdint.h>
#include <string.h>

using namespace std;

#define INT_MAX 0x7FFFFFFF
#define INT_MIN 0x8000000

int _atoi(const char *str, bool nag) {
    int64_t num = 0;
    int flag = nag ? -1 : 1;
    char *p = (char*) str;

    while (*p != '\0') {
        if (*p >= '0' && *p <= '9') {
            num = num * 10 + flag * (*p - '0'); // &&& flag

            // 是否溢出
            if (!nag && num > INT_MAX) {
                num = INT_MAX;
                break;
            } else if (nag && num < (signed int)INT_MIN) {  // &&& signed int
                num = INT_MIN;
                break;
            }

            p++;
        } else {
            break;  // 有异常字符时，取正常部分
        }
    }

    return num;
}

int atoi(const char *str) {
    while (*str != '\0' && *str == ' ') str++;

    int64_t num = 0;
    if (str != nullptr && *str != '\0') {
        bool flag = false;

        if (*str == '+') {
            flag = false;
            str++;
        } else if (*str == '-') {
            flag = true;
            str++;
        }

        if (*str != '\0') {
            num = _atoi(str, flag);
        }
    }

    return (int) num;
}


char *itoa(int val) {
    char *buf = new char[50];
    memset((void*)buf, 0, 50);

    if (val == 0) {
        buf[0] = '0';
        return buf;
    }

    int i = 0;
    bool flag = false;

    if (val < 0) {
        flag = true;
        buf[i++] = '-';
        val = -val;     // 转正
    }

    do {
        buf[i++] = val % 10 + '0';
        val = val / 10;
    } while (val > 0);

    // 转正
    int left = 0, right = i - 1;
    while (left < right) {
        std::swap(buf[left], buf[right]);
        left++;
        right--;
    }

    return buf;
}

int main(int argc, char **argv) {
    int a = ::atoi("12345");
    printf("a=%d\n", a);

    char *b = ::itoa(12345);
    printf("b=%s\n", b);
    return 0;
}