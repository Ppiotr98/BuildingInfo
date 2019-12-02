package pl.put.poznan.transformer.app;

public class Pomieszczenie extends Lokalizacja {
    private float area;
    private float cube;
    private float heating;
    private float light;

    public Pomieszczenie(String id, float area, float cube, float heating, int light) {
        super(id);
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
    }

    public Pomieszczenie(String id, String name, float area, float cube, float heating, int light) {
        super(id, name);
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
    }

    public float getFullArea() {
        return area;
    }

    public float getFullCube() {
        return cube;
    }

    public float getFullHeating() {
        return heating;
    }

    public float getFullLight() {
        return light;
    }
}
