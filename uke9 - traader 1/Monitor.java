import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor {
    Lock l = new ReentrantLock();
    Condition c = l.newCondition();
    ArrayList<Integer> al = new ArrayList<>();

    public void leggTil(Integer i) {
        l.lock();
        try {
            al.add(i);
            c.signal();
        } finally {
            l.unlock();
        }
    }
    
    public Integer fjern() {
        l.lock();
        try {
            while (al.isEmpty()) {
                try {
                    System.out.println("Ingen tall å fjerne, sover...");
                    c.await();
                } catch (InterruptedException e) {}
            }
            return al.removeLast();
        } finally {
            l.unlock();
        }
        
    }
}
