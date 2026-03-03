public class Main {
    public static void main(String[] args) {
        Ko ko = new Ko();

        for (int i = 0; i < 3; i++) {
            ko.leggTilSist(i);
        }

        for (int i = 0; i < 4; i++) {
            System.out.println(ko.fjernForst());
        }
    }
}
