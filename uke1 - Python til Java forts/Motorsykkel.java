public class Motorsykkel {
    private int killometerStand;
    private String reggNmr;
    private int prodNmr;
    private static int teller = 0;

    public Motorsykkel(String reggNmr) {
        this.reggNmr = reggNmr;
        this.killometerStand = 0;
        this.prodNmr = teller++;
    }
    public int hentKillometerStand() {
        return this.killometerStand;
    }
    public int hentProdNmr() {
        return this.prodNmr;
    }
    public void kjoer(int km) {
        this.killometerStand += km;
    }
}
