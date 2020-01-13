package pl.put.poznan.buildingInfo.logic;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PoziomTest {

    private Poziom[] poziomy = new Poziom[4];

    @BeforeEach
    void initPoziom() {
        int pom_id = 1;
        for (int poz_i = 0; poz_i < 4; poz_i++) {
            poziomy[poz_i] = new Poziom("poz"+Integer.toString(poz_i));
            for (int pom_i = 0; pom_i < 5; pom_i++) {
                Pomieszczenie pom_tmp = new Pomieszczenie("pom"+Integer.toString(pom_id), "pom"+Integer.toString(pom_id), 20+poz_i*5, 60+poz_i*5, 20+poz_i*2, 32+poz_i*2);
                poziomy[poz_i].addPomieszczenie(pom_tmp);
                pom_id++;
            }
        }
    }

    @Test
    void getFullArea() {
        assert(poziomy[0].getFullArea() == 100);
        assert(poziomy[1].getFullArea() == 125);
        assert(poziomy[2].getFullArea() == 150);
        assert(poziomy[3].getFullArea() == 175);
    }

    @Test
    void getFullCube() {
        assert(poziomy[0].getFullCube() == 300);
        assert(poziomy[1].getFullCube() == 325);
        assert(poziomy[2].getFullCube() == 350);
        assert(poziomy[3].getFullCube() == 375);
    }

    @Test
    void getFullHeating() {
        assert(poziomy[0].getFullHeating() == 100);
        assert(poziomy[1].getFullHeating() == 110);
        assert(poziomy[2].getFullHeating() == 120);
        assert(poziomy[3].getFullHeating() == 130);
    }

    @Test
    void getFullLight() {
        assert(poziomy[0].getFullLight() == 160);
        assert(poziomy[1].getFullLight() == 170);
        assert(poziomy[2].getFullLight() == 180);
        assert(poziomy[3].getFullLight() == 190);
    }

    @Test
    void getOverflowed() {
        JSONObject tmp = new JSONObject();
        assert(poziomy[0].getOverflowed(.34f, new JSONObject()).toString().equals("{}"));
        assert(poziomy[1].getOverflowed(.34f, new JSONObject()).toString().equals("{}"));
        assert(poziomy[2].getOverflowed(.34f, new JSONObject()).toString().equals("{\"pom11\":24,\"pom12\":24,\"pom15\":24,\"pom13\":24,\"pom14\":24}"));
        assert(poziomy[3].getOverflowed(.34f, new JSONObject()).toString().equals("{\"pom20\":26,\"pom19\":26,\"pom17\":26,\"pom18\":26,\"pom16\":26}"));
    }
}