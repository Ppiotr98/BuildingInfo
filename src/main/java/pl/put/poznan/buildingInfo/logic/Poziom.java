package pl.put.poznan.buildingInfo.logic;

import org.json.JSONObject;

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
     * <p>Metoda która dodaje {@link Pomieszczenie} do listy <code>pomieszczenia</code></p>
     *
     * @param pomieszczenie objekt typu {@link Pomieszczenie}.
     */
    public void addPomieszczenie(Pomieszczenie pomieszczenie){
        this.pomieszczenia.add(pomieszczenie);
    }

    /**
     * <p>Getter dla atrybutu <code>pomieszczenia</code>.</p>
     *
     * @return lista {@link java.util.Set} <code>pomiesczenia</code>.
     */
    public Set<Pomieszczenie> getPomieszczenia() {
        return pomieszczenia;
    }

    /**
     * Metoda która zwraca powierzchnie dla tego poziomu
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
     * Metoda która zwraca kubaturę dla tego poziomu
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
     * Metoda która zwraca poziom zyżycia energii dla tego poziomu
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
     * Metoda która zwraca łączną moc oświetlenia dla tego poziomu
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
     * @return objekt typu {@link Pomieszczenie} jeśli pomieszczenia o danym identyfikatorze istnieje na liście pomieszczeń dla tego poziomu - otherwise null.
     */
    public Pomieszczenie findPomieszczenie(String pom) {
        for (Pomieszczenie tmp : this.pomieszczenia) {
            if (tmp.getId().equals(pom)) return tmp;
        }
        return null;
    }

    /**
     * Metoda, sprawdzająca wszystkie pomieszczenia na tym poziomie i dodająca do listy te które przekraczają ustalony poziom
     * @param threshold poziom zużycia energii
     * @param result objekt typu {@link JSONObject} który zawiera dane z poprzednich poziomów
     * @return parametr wejściowy uzupełniony o pomieszczenia przekraczające poziom zużycia energii cieplnej z tego poziomu
     */
    public JSONObject getOverflowed(float threshold, JSONObject result){
        for (Pomieszczenie pom: this.pomieszczenia){
            if(pom.overflowHeating(threshold)){
                result.put(pom.getId(), pom.getFullHeating());
            }
        }
        return result;
    }
}
