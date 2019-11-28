package pl.put.poznan.transformer.app;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Budynek extends Lokalizacja {
    private Set<Poziom> poziomy = new HashSet<>();

    public Budynek() {
        super("1");
    }

    public Budynek(String id, String name) {
        super(id, name);
    }

    // because we add levels in addPoziom() method we don't really need this function. To remove?     @daniktl
    public void setPoziomy(Set<Poziom> poziomy) {
        this.poziomy = poziomy;
        /* TODO */
    }

    public void addPoziom(Poziom poziom) {
        this.poziomy.add(poziom);
    }

    public float getFullArea(){
        float res = 0;
        // calculate full building area
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
