package pl.put.poznan.buildingInfo.logic;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Klasa Poziom.</p>
 *
 * @author daniktl, vieja, ppiotr98
 * @version $Id: $Id
 */
public class Poziom extends Lokalizacja {
    /**
     * Lista objektów typu {@link Pomieszczenie} - pomieszczenia na tym poziomie
     */
    private Set<Pomieszczenie> pomieszczenia = new HashSet<>();

    /**
     * <p>Konstruktor klasy Poziom bez nazwy</p>
     *
     * @param id identyfikator typu {@link java.lang.String}.
     */
    public Poziom(String id) {
        super(id);
    }

    /**
     * <p>Konstruktor klasy Poziom z nazwą</p>
     *
     * @param id identyfikator typu {@link java.lang.String}.
     * @param name nazwa typu {@link java.lang.String}.
     */
    public Poziom(String id, String name) {
        super(id, name);
    }

    /**
     * <p>Metoda, która dodaje {@link Pomieszczenie} do listy <code>pomieszczenia</code></p>
     *
     * @param pomieszczenie obiekt typu {@link Pomieszczenie}.
     */
    public void addPomieszczenie(Pomieszczenie pomieszczenie){
        this.pomieszczenia.add(pomieszczenie);
    }

    /**
     * Metoda, która zwraca powierzchnię dla tego poziomu
     * @return float powierzchnia
     */
    public float getFullArea(){
        float res = 0;
        for (Pomieszczenie pom_tmp : this.pomieszczenia) {
            res += pom_tmp.getFullArea();
        }
        return res;
    }

    /**
     * Metoda, która zwraca kubaturę dla tego poziomu
     * @return float kubatura
     */
    public float getFullCube(){
        float res = 0;
        for (Pomieszczenie pom_tmp : this.pomieszczenia) {
            res += pom_tmp.getFullCube();
        }
        return res;
    }

    /**
     * Metoda, która zwraca poziom zyżycia energii dla tego poziomu
     * @return float zużycie energii
     */
    public float getFullHeating(){
        float res = 0;
        for (Pomieszczenie pom_tmp : this.pomieszczenia) {
            res += pom_tmp.getFullHeating();
        }
        return res;
    }

    /**
     * Metoda, która zwraca łączną moc oświetlenia dla tego poziomu
     * @return float
     */
    public float getFullLight(){
        float res = 0;
        for (Pomieszczenie pom_tmp : this.pomieszczenia) {
            res += pom_tmp.getFullLight();
        }
        return res;
    }

    /**
     * <p>Metoda zwracająca Pomieszczenie.</p>
     * Znajdż pomieszczenie o danym identyfikatorze jeśli istnieje
     *
     * @param pom identyfikator pomieszczenia typu {@link java.lang.String}.
     * @return obiekt typu {@link Pomieszczenie} jeśli pomieszczenia o danym identyfikatorze istnieje na liście pomieszczeń dla tego poziomu - w innym przypadku null.
     */
    public Pomieszczenie findPomieszczenie(String pom) {
        for (Pomieszczenie tmp : this.pomieszczenia) {
            if (tmp.getId().equals(pom)) return tmp;
        }
        return null;
    }
}
