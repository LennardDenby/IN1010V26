import java.util.Iterator;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

abstract class Fly {
    private String id;
    private int motorAntall;
    private int mtow;
    int trekkraft;
    Fly neste;

    public Fly(String id, int motorAntall, int mtow, int trekkraft) {
        this.id = id;
        this.motorAntall = motorAntall;
        this.mtow = mtow;
        this.trekkraft = trekkraft;
    }
    public String hentId() {
        return this.id;
    }
    public int hentMotorAntall() {
        return this.motorAntall;
    }
    public int hentMTOW() {
        return this.mtow;
    }

    // hjelpe metode for hent maks vekt rekursivt
    int hentMaksVektRec() {
        if (this.neste == null) {
            return this.hentMTOW();
        }
        int nesteVekt = neste.hentMaksVektRec();
        if (nesteVekt > this.hentMTOW()) {
            return nesteVekt;
        } else {
            return this.hentMTOW();
        }
    }
}

interface Motordrevet {
    public int trekkraft();
}

class Seilfly extends Fly {
    public Seilfly(String id, int motorAntall, int mtow, int trekkraft) {
        super(id, motorAntall, mtow, trekkraft);
    }
}

abstract class Motorfly extends Fly implements Motordrevet {
    public Motorfly(String id, int motorAntall, int mtow, int trekkraft) {
        super(id, motorAntall, mtow, trekkraft);
    }

    @Override
    public int trekkraft() {
        return this.trekkraft;
    }
}

class Lastefly extends Motorfly {
    int maksVekt;

    public Lastefly(String id, int motorAntall, int mtow, int maksVekt, int trekkraft) {
        super(id, motorAntall, mtow, trekkraft);
        this.maksVekt = maksVekt;
    }
}

class Passasjerfly extends Motorfly {
    int maksPassasjerer;
    public Passasjerfly(String id, int motorAntall, int mtow, int maksPassasjerer, int trekkraft) {
        super(id, motorAntall, mtow, trekkraft);
        this.maksPassasjerer = maksPassasjerer;
    }
}

class Flyformasjon implements Iterable<Fly> {
    Fly forste;

    void leggTil(Fly f) {
        f.neste = forste;
        forste = f;
    }

    boolean erMed(String id) {
        Fly peker = forste;

        while (peker != null) {
            if (peker.hentId().equals(id)) {
                return true;
            }
            peker = peker.neste;
        }
        return false;
    }

    Fly taUt(String id) {
        Fly peker = forste;
        Fly forrige = null;

        if (forste == null) return null;

        if (forste.hentId().equals(id)) {
            forste = peker.neste;
            return peker;
        }

        while (peker != null) {
            if (peker.hentId().equals(id)) {
                forrige.neste = peker.neste;
                return peker;
            }
            forrige = peker;
            peker = peker.neste;
        }

        return null;
    }

    @Override
    public Iterator<Fly> iterator() {
        return new FlyIterator();
    }

    class FlyIterator implements Iterator<Fly> {
        Fly peker = forste;

        public boolean hasNext() {
            return peker != null;
        }
        public Fly next() {
            Fly temp = peker;
            peker = peker.neste;
            return temp;
        }
    }

    Passasjerfly[] hentPassasjerFly() {
        int antallPassasjerFly = 0;

        for (Fly f : this) {
            if (f instanceof Passasjerfly) {
                antallPassasjerFly++;
            }
        }
        Passasjerfly[] flyArr = new Passasjerfly[antallPassasjerFly];

        int indeks = 0;
        for (Fly f : this) {
            if (f instanceof Passasjerfly) {
                flyArr[indeks] = (Passasjerfly) f;
                indeks++;
            }
        }
        return flyArr;
    }

    int totalVekt() {
        int total = 0;

        for (Fly f : this) {
            total += f.hentMTOW();
        }

        return total;
    }

    int maksVekt() {
        return forste.hentMaksVektRec();
    }
}

class Flygeleder implements Runnable {
    Rullebane r;
    Flygeleder(Rullebane r) {
        this.r = r;
    }
    @Override
    public void run() {
        while(true) {
            r.sjekkAvganger();
            Thread.sleep(60000);
        }
    }
}

class Pilot implements Runnable {
    @Override
    public void run() {
        
    }
}

class Rullebane { 
    int antFly;
    Lock lås = new ReentrantLock();
    Condition avventStartTillatelse = lås.newCondition();

    void sjekkAvganger() {
        lås.lock();
        try {
            if (antFly == 0) return;
            avventStartTillatelse.signal();
        } finally {
            lås.unlock();
        }
    }

    void hentStartTillatelse(Fly f) {
        lås.lock();
        try {
            antFly++;
            avventStartTillatelse.await();
            antFly--;
            System.err.println(f.hentId() + " har lettet!");
        } catch(InterruptedException e) {
            System.err.println(e);
        }finally {
            lås.unlock();
        }
    }
}