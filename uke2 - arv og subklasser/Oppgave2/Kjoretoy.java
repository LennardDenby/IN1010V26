public class Kjoretoy {
    String id;
    String merke;
    String modell;
    int aar;

    public Kjoretoy(String i, String m, String mo, int a) {
        id = i;
        merke = m;
        modell = mo;
        aar = a;
    }
    public String hentMerke() {
        return merke;
    }
}
