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
    };

    public JSONObject zwrocWynik(String action, String pom, String poz, boolean bud) {
        String[] allowed_actions = {"area", ""};
        JSONObject jo = new JSONObject();
        jo.put("result", "success");
        if (action.equals("full_area")){
            float res = getFullArea();
            jo.put("Full area", res);
        }
        // TODO: other methods
        return jo;
    }
}
