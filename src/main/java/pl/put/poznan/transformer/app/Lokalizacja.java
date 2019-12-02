package pl.put.poznan.transformer.app;

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

    public float getFullHeating(){
        return 0;
    }

    public float getFullLight(){
        return 0;
    }

    public float getFullCube(){
        return 0;
    }

}
