package pl.put.poznan.transformer.app;

public class Pomieszczenie extends Lokalizacja {
    private float area;
    private float cube;
    private float heating;
    private int light;

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

    public float getArea() {
        return area;
    }

    public float getCube() {
        return cube;
    }

    public float getHeating() {
        return heating;
    }

    public int getLight() {
        return light;
    }
}
