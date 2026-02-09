public class Motorsykkel extends Kjoretoy {
    String motortype;

    public Motorsykkel(String i, String m, String mo, int a, String mot) {
        super(i, mo, mot, a);
        motortype = mot;
    }
    public String hentMotortype() {
        return motortype;
    }
}
