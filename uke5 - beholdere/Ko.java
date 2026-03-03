public class Ko {
    Node forste;
    Node siste;

    private class Node {
        int data;
        Node neste;

        public Node(int d) {
            data = d;
        }
    }

    public int fjernForst() {
        if (forste == null) {
            throw new RuntimeException("listen er tom");
        }
        int temp = forste.data;
        forste = forste.neste;

        if (forste == null) {
            siste = null;
        }
        return temp;
    }
    public void leggTilSist(int data) {
        if (forste == null) {
            forste = siste = new Node(data);
            return;
        }
        siste.neste = new Node(data);
        siste = siste.neste;
    }
}