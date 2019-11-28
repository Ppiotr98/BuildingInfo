package pl.put.poznan.transformer.app;

import java.util.HashSet;
import java.util.Set;


public class Budynek extends Lokalizacja {
    private Set<Poziom> poziomy = new HashSet<>();

    public Budynek(int id) {
        super(id);
    }

    public Budynek(int id, String name) {
        super(id, name);
    }

    public void setPoziomy(Set<Poziom> poziomy) {
        this.poziomy = poziomy;
        /* TODO */
    }

    public Set<Poziom> getPoziomy() {
        return poziomy;
    }
}
