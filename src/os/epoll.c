/**
 * epoll
 *
 * LT   默认，触发多次
 * ET   触发一次，效率高
 */


epoll_create();
epoll_ctl();

int cnt = epoll_wait(fd, evts, NUMBER, -1);
for (int i=0; i<cnt; i++) {
    if (event[i].data.fd == fd) {
        accept();
    } else if (evts[i].events & EPOLLIN) {
        handleRead();
    } else if (evts[i].events & EPOLLOUT) {
        handleWrite();
    }
}
