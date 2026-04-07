public class FjernRunnable implements Runnable {
    Monitor m;
    public FjernRunnable(Monitor m) {
        this.m = m;
    }
    @Override
    public void run() {
        while (!m.al.isEmpty()) {
            Integer i = m.fjern();
            System.out.println("Fjernet: " + i);
        }
    }
}
