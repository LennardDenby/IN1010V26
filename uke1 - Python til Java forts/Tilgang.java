public class Tilgang {
    private String navn;

    public Tilgang(String n) {
        this.navn = n;
    }

    public void endreNavn(String n) {
        this.navn = n;
    }
    private void leggTilNoe(String n) {
        this.navn += "!";
    }
}
