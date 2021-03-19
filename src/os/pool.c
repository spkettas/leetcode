/**
 * 线程池
 *
 */
class pool {
public:
    // 初始化一批线程
    pool(int n) {
        for (auto i : n) {
            thread th(&pool::run, this);
            threads.push_back(move(th));
        }
    }

    void addTask(T& t) {
        lock_gurard l(mtx);
        q.add(t);

        // notify
        cv.notify_one();
    }

    void run() {
        while (!quit) {
            cv.wait();

            t = q.pop();
            t.handle();
        }
    }

private:
    mutex mtx;
    condition_variable cv;
    vector<thread> threads;
    list<T> q;
};