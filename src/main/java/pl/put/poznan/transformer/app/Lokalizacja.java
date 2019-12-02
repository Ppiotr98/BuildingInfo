package pl.put.poznan.transformer.app;
import org.json.JSONObject;

/**
 * <p>Abstract Lokalizacja class.</p>
 *
 * @author daniktl
 * @version $Id: $Id
 */
public abstract class Lokalizacja {
    private String id;
    private String name;

    /**
     * <p>Constructor for Lokalizacja.</p>
     *
     * @param id a {@link java.lang.String} object.
     */
    public Lokalizacja(String id) {
        this.id = id;
    }

    /**
     * <p>Constructor for Lokalizacja.</p>
     *
     * @param id a {@link java.lang.String} object.
     * @param name a {@link java.lang.String} object.
     */
    public Lokalizacja(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * <p>Getter for the field <code>id</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getId() {
        return id;
    }

    /**
     * <p>Getter for the field <code>name</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getName() {
        return name;
    }


    /**
     * <p>getFullArea.</p>
     *
     * @return a float.
     */
    public abstract float getFullArea();

    /**
     * <p>getFullHeating.</p>
     *
     * @return a float.
     */
    public abstract float getFullHeating();

    /**
     * <p>getFullLight.</p>
     *
     * @return a float.
     */
    public abstract float getFullLight();

    /**
     * <p>getFullCube.</p>
     *
     * @return a float.
     */
    public abstract float getFullCube();

}
