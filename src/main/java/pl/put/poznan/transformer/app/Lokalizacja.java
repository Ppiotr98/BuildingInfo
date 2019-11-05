package pl.put.poznan.transformer.app;

public abstract class Lokalizacja {
    private int id;
    private String name;

    public Lokalizacja(int id) {
        this.id = id;
    }

    public Lokalizacja(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
