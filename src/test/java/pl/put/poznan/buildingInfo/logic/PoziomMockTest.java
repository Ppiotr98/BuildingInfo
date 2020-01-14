package pl.put.poznan.buildingInfo.logic;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.*;
import org.mockito.*;

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
}
