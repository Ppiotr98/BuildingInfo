package pl.put.poznan.transformer.app;

/**
 * <p>Pomieszczenie class.</p>
 *
 * @author daniktl
 * @version $Id: $Id
 */
public class Pomieszczenie extends Lokalizacja {
    private float area;
    private float cube;
    private float heating;
    private float light;

    /**
     * <p>Constructor for Pomieszczenie.</p>
     *
     * @param id a {@link java.lang.String} object.
     * @param area a float.
     * @param cube a float.
     * @param heating a float.
     * @param light a int.
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
     * @param id a {@link java.lang.String} object.
     * @param name a {@link java.lang.String} object.
     * @param area a float.
     * @param cube a float.
     * @param heating a float.
     * @param light a int.
     */
    public Pomieszczenie(String id, String name, float area, float cube, float heating, int light) {
        super(id, name);
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
    }

    /**
     * <p>getFullArea.</p>
     *
     * @return a float.
     */
    public float getFullArea() {
        return area;
    }

    /**
     * <p>getFullCube.</p>
     *
     * @return a float.
     */
    public float getFullCube() {
        return cube;
    }

    /**
     * <p>getFullHeating.</p>
     *
     * @return a float.
     */
    public float getFullHeating() {
        return heating;
    }

    /**
     * <p>getFullLight.</p>
     *
     * @return a float.
     */
    public float getFullLight() {
        return light;
    }
}
