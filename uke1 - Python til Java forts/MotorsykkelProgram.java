public class MotorsykkelProgram {
    public static void main(String[] args) {
        Motorsykkel m1 = new Motorsykkel("AB1234");
        Motorsykkel m2 = new Motorsykkel("asdasds");

        System.out.println(m1.hentProdNmr());
        System.out.println(m2.hentProdNmr());
    }
}
