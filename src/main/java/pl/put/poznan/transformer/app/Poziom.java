package pl.put.poznan.transformer.app;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Poziom extends Lokalizacja {
    private Set<Pomieszczenie> pomieszczenia = new HashSet<>();

    public Poziom(String id) {
        super(id);
    }

    public Poziom(String id, String name) {
        super(id, name);
    }
    // because we add rooms in addPomieszczenia() method we don't really need this function. To remove?     @daniktl
    public void setPomieszczenia(Set<Pomieszczenie> pomieszczenia) {
        this.pomieszczenia = pomieszczenia;
        /* TODO */
    }

    public void addPomieszczenia(Pomieszczenie pomieszczenie){
        this.pomieszczenia.add(pomieszczenie);
    }

    public Set<Pomieszczenie> getPomieszczenia() {
        return pomieszczenia;
    }

    public float getFullArea(){
        float res = 0;
        for (Iterator<Pomieszczenie> it = this.pomieszczenia.iterator(); it.hasNext(); ){
            Pomieszczenie pom_tmp = it.next();
            res += pom_tmp.getArea();
        }
        return res;
    }
}
