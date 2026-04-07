import java.util.Random;

public class LeggTilRunnable implements Runnable {
    Monitor m;
    public LeggTilRunnable(Monitor m) {
        this.m = m;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            m.leggTil(new Random().nextInt(1000));
        }
    }
}
