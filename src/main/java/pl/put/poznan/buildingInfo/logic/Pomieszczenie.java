package pl.put.poznan.buildingInfo.logic;

import java.util.SplittableRandom;

/**
 * <p>Klasa Pomieszczenie.</p>
 *
 * @author daniktl, vieja, ppiotr98
 * @version $Id: $Id
 */
public class Pomieszczenie extends Lokalizacja {
    private float area;
    private float cube;
    private float heating;
    private float light;

    /**
     * <p>Konstruktor dla klasy Pomieszczenie.</p>
     *
     * @param id identyfikator typu {@link java.lang.String}.
     * @param area powierzchnia pomieszczenia typu {@link Float}.
     * @param cube kubatura pomieszczenia typu {@link Float}.
     * @param heating poziom zużycia energii pomieszczenia typu {@link Float}.
     * @param light moc oświetlenia pomieszczenia typu {@link Float}.
     */
    public Pomieszczenie(String id, float area, float cube, float heating, int light) {
        super(id);
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
    }

    /**
     * <p>Constructor for Pomieszczenie.</p>
     *
     * @param id identyfikator typu {@link java.lang.String}.
     * @param name nazwa typu {@link java.lang.String}.
     * @param area powierzchnia pomieszczenia typu {@link Float}.
     * @param cube kubatura pomieszczenia typu {@link Float}.
     * @param heating poziom zużycia energii pomieszczenia typu {@link Float}.
     * @param light moc oświetlenia pomieszczenia typu {@link Float}.
     */
    public Pomieszczenie(String id, String name, float area, float cube, float heating, int light) {
        super(id, name);
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
    }

    /**
     * Metoda, która zwraca powierzchnię dla tego pomieszczenia
     * @return float powierzchnia
     */
    public float getFullArea() {
        return area;
    }

    /**
     * Metoda, która zwraca kubaturę dla tego pomieszczenia
     * @return float kubatura
     */
    public float getFullCube() {
        return cube;
    }

    /**
     * Metoda, która zwraca poziom zyżycia energii dla tego pomieszczenia
     * @return float zużycie energii
     */
    public float getFullHeating() {
        return heating;
    }

    /**
     * Metoda, która zwraca łączną moc oświetlenia dla tego pomieszczenia
     * @return float
     */
    public float getFullLight() {
        return light;
    }


    /**
     * Metoda zwracająca listę pomiesczeń przekraczających poziom zużycia energii cieplnej / m3
     * @param threshold poziom zużycia energii
     * @return objekt typu {@link org.json.JSONObject} który zawiera pary id_pomieszczenia: zużycie energii cieplnej
     */
    public boolean overflowHeating(float threshold){
        return this.heating/this.cube > threshold;
    }

    /**
     * Metoda zwracająca listę pomiesczeń nieprzekraczających podanego progu mocy oświetlenia / m2
     * @param threshold poziom zużycia energii
     * @return objekt typu {@link org.json.JSONObject} który zawiera pary id_pomieszczenia: moc oświetlenia
     */
    public boolean overflowLight(float threshold){
        return this.light/this.area < threshold;
    }
}
