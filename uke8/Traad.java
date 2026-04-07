public class Traad {
    public static void main(String[] args) {
        int antTraader = 10;
        Thread[] tl = new Thread[antTraader];
        int mult = 10000000;

        for (int i = 0; i < antTraader; i++) {
            Thread t = new Thread(new Program(i * mult, (i + 1) * mult));
            tl[i] = t;
            t.start();
        }
        
        for (Thread t : tl) {
            try {
                t.join();
            } catch (Exception e) {}
        }
    }
}

// Start 10 tråder. Hver tråd skal sjekke om alle tall
// fra variabel start til og med variabel slutt, er et primtall.