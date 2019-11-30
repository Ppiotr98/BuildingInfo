package pl.put.poznan.transformer.app;
import org.json.JSONObject;

public abstract class Lokalizacja {
    private String id;
    private String name;

    public Lokalizacja(String id) {
        this.id = id;
    }

    public Lokalizacja(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public float getFullArea(){
        return 0;
    }
}
