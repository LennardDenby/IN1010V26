public class Hovedprogram {
    public static void main(String[] args) {
        int antTraader = 10;

        Monitor m = new Monitor();
        //Thread[] ts = new Thread[antTraader + antLeggTilTraader];

        for (int i = 0; i < antTraader; i++) {
            Thread t1 = new Thread(new FjernRunnable(m));
            t1.start();
        }
        Thread t2 = new Thread(new LeggTilRunnable(m));
        t2.start();

        // for (Thread t : ts) {
        //     try {
        //         t.join();
        //     } catch (InterruptedException e) {}
        // }
    }
}
