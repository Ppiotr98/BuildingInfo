package pl.put.poznan.buildingInfo.logic;

/**
 * <p>Klasa abstrakcyjna Lokalizacja.</p>
 *
 * @author daniktl, vieja, ppiotr98
 * @version $Id: $Id
 */
public abstract class Lokalizacja {
    /**
     * Identyfikator Lokalizacji typu {@link String}
     */
    private String id;
    /**
     * Nazwa Lokalizacji typu {@link String}
     */
    private String name;

    /**
     * <p>Konstruktor dla Lokalizacja z jednym parametrem - identyfikator.</p>
     * @param id identyfikator typu {@link java.lang.String}.
     */
    public Lokalizacja(String id) {
        this.id = id;
    }

    /**
     * <p>Konstruktor dla Lokalizacja z dwoma parametrami - identyfikator i nazwa budynku</p>
     *
     * @param id identyfikator typu  {@link java.lang.String}.
     * @param name nazwa typu  {@link java.lang.String}.
     */
    public Lokalizacja(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * <p>Getter dla atrybutu <code>id</code>.</p>
     *
     * @return identyfikator typu {@link java.lang.String}.
     */
    public String getId() {
        return id;
    }

    /**
     * <p>Getter dla atrybutu <code>name</code>.</p>
     *
     * @return nazwa typu {@link java.lang.String}.
     */
    public String getName() {
        return name;
    }

    /**
     * Metoda która zwraca powierzchnie
     * @return float powierzchnia
     */
    public abstract float getFullArea();

    /**
     * Metoda która zwraca poziom zyżycia energii
     * @return float zużycie energii
     */
    public abstract float getFullHeating();

    /**
     * Metoda która zwraca łączną moc oświetlenia
     * @return float
     */
    public abstract float getFullLight();

    /**
     * Metoda która zwraca kubaturę
     * @return float kubatura
     */
    public abstract float getFullCube();

}
