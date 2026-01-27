public class Klasse {
    String navn;

    public Klasse(String n) { //konstruktør
        this.navn = n;
    }
    public void skrivNavn() {
        System.out.println(this.navn);
    }
    public String hentNavn() {
        return this.navn;
    }
    public void endreNavn(String n) {
        this.navn = n;
    }
}   