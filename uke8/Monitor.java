import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor {
    int tall;
    Lock l = new ReentrantLock();

    public void ok() {
        l.lock();
        tall++;
        l.unlock();
    }
}
