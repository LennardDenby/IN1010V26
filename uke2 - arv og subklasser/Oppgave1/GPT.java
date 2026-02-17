import java.util.ArrayList;

public class GPT extends Robot {
    ArrayList<String> delteEgenskaper = new ArrayList<>();

    public GPT(String navn, ArrayList<String> egenskaper) {
        super(navn);
        delteEgenskaper = egenskaper;
    }
    public void leggTilEgenskap(String egenskap) {
        delteEgenskaper.add(egenskap);
    }
    public void fjernEgenskap(String egenskap) {
        delteEgenskaper.remove(egenskap);
    }
}