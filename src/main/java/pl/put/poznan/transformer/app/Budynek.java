package pl.put.poznan.transformer.app;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Budynek extends Lokalizacja {
    private Set<Poziom> poziomy = new HashSet<>();

    public Budynek(String id) {
        super(id);
    }

    public Budynek(String id, String name) {
        super(id, name);
    }

    public void setPoziomy(Set<Poziom> poziomy) {
        this.poziomy = poziomy;
        /* TODO */
    }

    public void addPoziom(Poziom poziom) {
        this.poziomy.add(poziom);
    }

    public float getFullArea(){
        float res = 0;
        for (Iterator<Poziom> it = this.poziomy.iterator(); it.hasNext(); ){
            Poziom poz_tmp = it.next();
            res += poz_tmp.getFullArea();
        }
        return res;
    }

    public Set<Poziom> getPoziomy() {
        return poziomy;
    }
}
