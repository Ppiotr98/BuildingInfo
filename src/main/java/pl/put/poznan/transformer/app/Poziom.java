package pl.put.poznan.transformer.app;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * <p>Poziom class.</p>
 *
 * @author daniktl
 * @version $Id: $Id
 */
public class Poziom extends Lokalizacja {
    private Set<Pomieszczenie> pomieszczenia = new HashSet<>();

    /**
     * <p>Constructor for Poziom.</p>
     *
     * @param id a {@link java.lang.String} object.
     */
    public Poziom(String id) {
        super(id);
    }

    /**
     * <p>Constructor for Poziom.</p>
     *
     * @param id a {@link java.lang.String} object.
     * @param name a {@link java.lang.String} object.
     */
    public Poziom(String id, String name) {
        super(id, name);
    }

    /**
     * <p>addPomieszczenie.</p>
     *
     * @param pomieszczenie a {@link pl.put.poznan.transformer.app.Pomieszczenie} object.
     */
    public void addPomieszczenie(Pomieszczenie pomieszczenie){
        this.pomieszczenia.add(pomieszczenie);
    }

    /**
     * <p>Getter for the field <code>pomieszczenia</code>.</p>
     *
     * @return a {@link java.util.Set} object.
     */
    public Set<Pomieszczenie> getPomieszczenia() {
        return pomieszczenia;
    }

    /**
     * <p>getFullArea.</p>
     *
     * @return a float.
     */
    public float getFullArea(){
        float res = 0;
        for (Pomieszczenie pom_tmp : this.pomieszczenia) {
            res += pom_tmp.getFullArea();
        }
        return res;
    }

    /**
     * <p>getFullCube.</p>
     *
     * @return a float.
     */
    public float getFullCube(){
        float res = 0;
        for (Pomieszczenie pom_tmp : this.pomieszczenia) {
            res += pom_tmp.getFullCube();
        }
        return res;
    }

    /**
     * <p>getFullHeating.</p>
     *
     * @return a float.
     */
    public float getFullHeating(){
        float res = 0;
        for (Pomieszczenie pom_tmp : this.pomieszczenia) {
            res += pom_tmp.getFullHeating();
        }
        return res;
    }

    /**
     * <p>getFullLight.</p>
     *
     * @return a float.
     */
    public float getFullLight(){
        float res = 0;
        for (Pomieszczenie pom_tmp : this.pomieszczenia) {
            res += pom_tmp.getFullLight();
        }
        return res;
    }

    // zwraca pomieszczenie, jeżeli posiada je na liście
    /**
     * <p>findPomieszczenie.</p>
     *
     * @param pom a {@link java.lang.String} object.
     * @return a {@link pl.put.poznan.transformer.app.Pomieszczenie} object.
     */
    public Pomieszczenie findPomieszczenie(String pom) {
        for (Pomieszczenie tmp : this.pomieszczenia) {
            if (tmp.getId().equals(pom)) return tmp;
        }
        return null;
    }
}
