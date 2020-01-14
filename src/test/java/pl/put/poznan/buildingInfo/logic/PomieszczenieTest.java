package pl.put.poznan.buildingInfo.logic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


class PomieszczenieTest {

    private Pomieszczenie pom1, pom2, pom3, pom4;

    @BeforeEach
    void init(){
        this.pom1 = new Pomieszczenie("pom1", "pom1", 40, 110, 29.5f, 32);
        this.pom2 = new Pomieszczenie("pom2", "pom2", 34, 125, 27.4f, 41);
        this.pom3 = new Pomieszczenie("pom3", "pom3", 42, 118, 23.7f, 45);
        this.pom4 = new Pomieszczenie("pom4", "pom4", 30, 95, 26.9f, 20);
    }

    @org.junit.jupiter.api.Test
    void getFullArea() {
        assert(this.pom1.getFullArea() == 40);
        assert(this.pom2.getFullArea() == 34);
        assert(this.pom3.getFullArea() == 42);
        assert(this.pom4.getFullArea() == 30);

    }

    @org.junit.jupiter.api.Test
    void getFullCube() {
        assert(this.pom1.getFullCube() == 110);
        assert(this.pom2.getFullCube() == 125);
        assert(this.pom3.getFullCube() == 118);
        assert(this.pom4.getFullCube() == 95);
    }

    @org.junit.jupiter.api.Test
    void getFullHeating() {
        assert(this.pom1.getFullHeating() == 29.5f);
        assert(this.pom2.getFullHeating() == 27.4f);
        assert(this.pom3.getFullHeating() == 23.7f);
        assert(this.pom4.getFullHeating() == 26.9f);
    }

    @org.junit.jupiter.api.Test
    void getFullLight() {
        assert(this.pom1.getFullLight() == 32);
        assert(this.pom2.getFullLight() == 41);
        assert(this.pom3.getFullLight() == 45);
        assert(this.pom4.getFullLight() == 20);
    }

    @org.junit.jupiter.api.Test
    void overflowHeating() {
        float threshold = .25f;
        assert(this.pom1.overflowHeating(threshold));
        assert(!this.pom2.overflowHeating(threshold));
        assert(!this.pom3.overflowHeating(threshold));
        assert(this.pom4.overflowHeating(threshold));
    }
}