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

    public void addPomieszczenie(Pomieszczenie pomieszczenie){
        this.pomieszczenia.add(pomieszczenie);
    }

    public Set<Pomieszczenie> getPomieszczenia() {
        return pomieszczenia;
    }

    public float getFullArea(){
        float res = 0;
        for (Pomieszczenie pom_tmp : this.pomieszczenia) {
            res += pom_tmp.getFullArea();
        }
        return res;
    }

    public float getFullCube(){
        float res = 0;
        for (Pomieszczenie pom_tmp : this.pomieszczenia) {
            res += pom_tmp.getFullCube();
        }
        return res;
    }

    public float getFullHeating(){
        float res = 0;
        for (Pomieszczenie pom_tmp : this.pomieszczenia) {
            res += pom_tmp.getFullHeating();
        }
        return res;
    }

    public float getFullLight(){
        float res = 0;
        for (Pomieszczenie pom_tmp : this.pomieszczenia) {
            res += pom_tmp.getFullLight();
        }
        return res;
    }

    // zwraca pomieszczenie, jeżeli posiada je na liście
    public Pomieszczenie findPomieszczenie(String pom) {
        for (Pomieszczenie tmp : this.pomieszczenia) {
            if (tmp.getId().equals(pom)) return tmp;
        }
        return null;
    }
}
