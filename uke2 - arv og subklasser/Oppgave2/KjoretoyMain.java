import java.util.HashMap;

public class KjoretoyMain {
    public static void main(String[] args) {
        HashMap<String, Kjoretoy> kjoretoy = new HashMap<>();

        Bil bil1 = new Bil("a", "b", "c", 10, 10);
        Bil bil2 = new Bil("d", "e", "f", 10, 10);

        Motorsykkel mot1 = new Motorsykkel("a", "b", "c", 0, "d");
        Motorsykkel mot2 = new Motorsykkel("e", "f", "g", 0, "h");

        kjoretoy.put("bil1", bil1);
        kjoretoy.put("bil2", bil2);
        kjoretoy.put("mot1", mot1);
        kjoretoy.put("mot", mot2);

        for (Kjoretoy k : kjoretoy.values()) {
            if (k instanceof Bil) {
                Bil bil = (Bil)k;
                System.out.println("Bilen har ant seter: " + bil.hentSeter());
            }
            else if (k instanceof Motorsykkel) {
                Motorsykkel motorsykkel = (Motorsykkel) k;
                System.out.println("Motorsykkelen har motor: "+motorsykkel.hentMotortype());
            }
        }




    }
}
