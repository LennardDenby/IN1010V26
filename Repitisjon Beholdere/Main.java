import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        DobbeltLenketLenkeListe<Integer> ll = new DobbeltLenketLenkeListe<>();
        ll.settInnForst(1);
        ll.settInnForst(2);
        ll.settInnForst(3);
        ll.settInnForst(4);
        ll.settInnForst(11);
        ll.settInnForst(12);

        System.out.println(ll);

    }
}
