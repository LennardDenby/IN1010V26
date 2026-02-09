public class Bil extends Kjoretoy{
    int seter;

    public Bil(String i, String m, String mo, int a, int s) {
        super(i, m, mo, a);
        seter = s;
    }
    public int hentSeter() {
        return seter;
    }
}
