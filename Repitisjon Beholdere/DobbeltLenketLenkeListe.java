import java.util.Iterator;

import javax.management.RuntimeErrorException;

public class DobbeltLenketLenkeListe<T> implements Iterable<T> {
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

    public void settInnForst(T elem) {
        Node nyNode = new Node(elem);

        if (antall == 0) {
            forste = siste = nyNode;
            antall++;
            return;
        }

        nyNode.neste = forste;
        forste.forrige = nyNode;
        forste = nyNode;
        antall++;
    }

    public void settInnSist(T elem) {
        Node nyNode = new Node(elem);

        if (antall == 0) {
            forste = siste = nyNode;
            antall++;
            return;
        }

        nyNode.forrige = siste;
        siste.neste = nyNode;
        siste = nyNode;
        antall++;
    }
    
    public void fjernForste() {
        if (antall == 0) {
            throw new RuntimeException("Kan ikke fjerne fra en tom liste");
        }
        if (antall == 1) {
            forste = siste = null;
            antall--;
            return;
        }

        forste = forste.neste;
        forste.forrige = null;
        antall--;
    }
    public void fjernSiste() {
        if (antall == 0) {
            throw new RuntimeException("Kan ikke fjerne fra en tom liste");
        }
        if (antall == 1) {
            forste = siste = null;
            antall--;
            return;
        }

        siste = siste.forrige;
        siste.neste = null;
        antall--;
    }

    public T hentForste() {
        if (antall == 0) return null;
        return forste.data;
    }
    public T hentSiste() {
        if (antall == 0) return null;
        return siste.data;
    }

    public T hent(int indeks) {
        if (indeks >= antall) return null;
        if (indeks < antall) return null;

        Node peker = forste;

        for (int i = 0; i < indeks; i++) {
            peker = peker.neste;
        }
        
        // return peker.data;
        
        // med iterator
        int teller = 0;
        for (T elem : this) {
            if (indeks == teller) {
                return elem;
            }
            teller++;
        }

        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListeIterator();
    }

    public class ListeIterator implements Iterator<T> {
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

    @Override
    public String toString() {
        String str = "";
        for (T elem : this) {
            str += elem + ", ";
        }
        return str;
    }
}
