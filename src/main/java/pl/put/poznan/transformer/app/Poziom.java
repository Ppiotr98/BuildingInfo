package pl.put.poznan.transformer.app;

import java.util.HashSet;
import java.util.Set;

public class Poziom extends Lokalizacja {
    private Set<Pomieszczenie> pomieszczenia = new HashSet<>();

    public Poziom(int id) {
        super(id);
    }

    public Poziom(int id, String name) {
        super(id, name);
    }

    public void setPomieszczenia(Set<Pomieszczenie> pomieszczenia) {
        this.pomieszczenia = pomieszczenia;
        /* TODO */
    }

    public Set<Pomieszczenie> getPomieszczenia() {
        return pomieszczenia;
    }
}
