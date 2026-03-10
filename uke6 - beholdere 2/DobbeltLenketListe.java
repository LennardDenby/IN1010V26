import java.util.Iterator;

public class DobbeltLenketListe<T> implements Liste<T> {
    private int antall;
    private Node forste;
    private Node siste;
    
    private class Node {
        Node neste;
        Node forrige;
        T data;
        public Node(T data) {
            this.data = data;
        }
    }
    public int antall() {
        return antall;
    }
    public void settInnFørst(T elem) {
        Node nyNode = new Node(elem);
        if (forste == null) {
            forste = siste = nyNode;
            antall++;
            return;
        }
        forste.forrige = nyNode;
        nyNode.neste = forste;
        forste = nyNode;
        antall++;
    }
    public void settInnSist(T elem) {
        Node nyNode = new Node(elem);
        if (forste == null) {
            forste = siste = nyNode;
            antall++;
            return;
        }
        siste.neste = nyNode;
        nyNode.forrige = siste;
        siste = nyNode;
        antall++;
    }
    public void fjernFørste() {
        if (forste == null) return;
        if (forste == siste) {
            forste = siste = null;
            antall--;
            return;
        }
        forste = forste.neste;
        forste.forrige = null;
        antall--;

    }
    public void fjernSiste() {
        if (siste == null) return;
        if (forste == siste) {
            forste = siste = null;
            antall--;
            return;
        };

        siste = siste.forrige;
        siste.neste = null;
        antall--;
    }
    public T hentFørste() {
        return forste.data; //sjekke om første / siste er null?
    }
    public T hentSiste() {
        return siste.data;
    }
    public T hent(int indeks) {
        if (forste == null) return null;
        if (indeks >= antall) return null;

        Node peker = forste; 
        
        for (int i = 0; i < indeks; i++) {
            peker = peker.neste;
        }
        return peker.data;
    }
    @Override
    public Iterator<T> iterator() {
        return new ListeIterator();
    }
    private class ListeIterator implements Iterator<T> {
        Node it = forste;

        @Override
        public boolean hasNext() {
            return it != null;
        }
        @Override
        public T next() {
            T elem = it.data;
            it = it.neste;
            return elem;
        }
    }
}
