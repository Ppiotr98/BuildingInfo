package put.io.testing.mocks;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.*;
import org.mockito.*;
import pl.put.poznan.buildingInfo.logic.Pomieszczenie;
import pl.put.poznan.buildingInfo.logic.Poziom;

public class PoziomMockTest {

    @Test
    public void getFullAreaTest() {
        Pomieszczenie pom1 = mock(Pomieszczenie.class);
        when(pom1.getFullArea()).thenReturn((float) 1);

        Pomieszczenie pom2 = mock(Pomieszczenie.class);
        when(pom2.getFullArea()).thenReturn((float) 4);

        Poziom poz = new Poziom("poz1");
        poz.addPomieszczenie(pom1);
        poz.addPomieszczenie(pom2);

        float wyn = poz.getFullArea();

        assertEquals(5,wyn,0.1);
    }

    @Test
    public void getFullCubeTest() {
        Pomieszczenie pom1 = mock(Pomieszczenie.class);
        when(pom1.getFullCube()).thenReturn((float) 1);

        Pomieszczenie pom2 = mock(Pomieszczenie.class);
        when(pom2.getFullCube()).thenReturn((float) 4);

        Poziom poz = new Poziom("poz1");
        poz.addPomieszczenie(pom1);
        poz.addPomieszczenie(pom2);

        float wyn = poz.getFullCube();

        assertEquals(5,wyn,0.1);
    }

    @Test
    public void getFullHeatingTest() {
        Pomieszczenie pom1 = mock(Pomieszczenie.class);
        when(pom1.getFullHeating()).thenReturn((float) 1);

        Pomieszczenie pom2 = mock(Pomieszczenie.class);
        when(pom2.getFullHeating()).thenReturn((float) 4);

        Poziom poz = new Poziom("poz1");
        poz.addPomieszczenie(pom1);
        poz.addPomieszczenie(pom2);

        float wyn = poz.getFullHeating();

        assertEquals(5,wyn,0.1);
    }

    @Test
    public void getFullLightTest() {
        Pomieszczenie pom1 = mock(Pomieszczenie.class);
        when(pom1.getFullLight()).thenReturn((float) 1);

        Pomieszczenie pom2 = mock(Pomieszczenie.class);
        when(pom2.getFullLight()).thenReturn((float) 4);

        Poziom poz = new Poziom("poz1");
        poz.addPomieszczenie(pom1);
        poz.addPomieszczenie(pom2);

        float wyn = poz.getFullLight();

        assertEquals(5,wyn,0.1);
    }
}
