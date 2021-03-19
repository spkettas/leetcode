/**
 * Test
 */
#include <stdio.h>
#include <queue>
#include <set>

using namespace std;

// bin 回环性
int bin_test() {
    int a = 5 - 0xffff;     // 0xffff0006
    uint16_t b = (uint16_t)a;
    printf("val: %u\n", b); // 6
}

/**
 * 数组指针
 * 指针数组
 */
int parray_test(int argc, char **argv) {
    int a[5] = {1, 2, 3, 4, 5};

    // 数组指针，存放的是val
    int (*p)[5] = &a;

    for (int i=0; i<5; i++) {
        // 指向的是数组，步长是5，不是1
        //printf("%d\n", *(p + i));
        printf("%d\n", *(*p + i));
    }

    printf("-----------------\n");

    // 指针数组，存放的是ptr
    int *q[5];
    for (int i=0; i<5; i++) {
        q[i] = &a[i];
    }

    for (int i=0; i<5; i++) {
        printf("%d\n", *q[i]);
    }

    return 0;
}

int heap_test() {
    // 降序排序，最大堆
    multiset<int, greater<int>> set1;
    set1.insert(5);
    set1.insert(7);
    set1.insert(8);
    set1.insert(9);

    printf("top: %d\n", *set1.begin()); // 9

    // 9 8 7 5
    for (auto const &e : set1) {
        printf("%d ", e);
    }
    printf("\n");

    // 小根堆
    priority_queue<int, vector<int>, greater<int>> q;
    q.push(5);
    q.push(7);
    q.push(8);
    q.push(9);

    // 9 8 7 5
    printf("top: %d\n", q.top()); // 5

    return 0;
}

int main(int argc, char **argv) {
    // int -> ptr
    int vl = 1024;
    int *v = (int*) vl;
    printf("ptr: 0x%x\n", v); // 1024

    bin_test();
    //parray_test();
    //heap_test();

    return 0;
}
