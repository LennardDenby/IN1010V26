public class Program implements Runnable {
    int start;
    int slutt;

    public Program(int start, int slutt) {
        this.start = start;
        this.slutt = slutt;
    }
    public void run() {
        for (int i = start; i < slutt; i ++) {
            if (erPrimtall(i)) {
                //System.out.println("Primtall: " + i);
            }
        }
    }
    private boolean erPrimtall(int tall) {
        if (tall < 2) return false;
        for (int i = 2; i <= Math.sqrt(tall); i++) {
            if (tall % i == 0) return false;
        }
        return true;
    }
}
