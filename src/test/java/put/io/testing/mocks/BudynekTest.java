package put.io.testing.mocks;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.*;
import org.mockito.*;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

public class BudynekTest {

    @Test
    public void getFullAreaTest() {
        Poziom poz1 = mock(Poziom.class);
        when(poz1.getFullArea()).thenReturn((float) 1);

        Poziom poz2 = mock(Poziom.class);
        when(poz2.getFullArea()).thenReturn((float) 4);

        Budynek bud = new Budynek("bud1")
        bud.addPoziom(poz1);
        bud.addPoziom(poz2);

        float wyn = bud.getFullArea();

        assertEquals(5,wyn,0.1);
    }

    @Test
    public void getFullCubeTest() {
        Poziom poz1 = mock(Poziom.class);
        when(poz1.getFullCube()).thenReturn((float) 1);

        Poziom poz2 = mock(Poziom.class);
        when(poz2.getFullCube()).thenReturn((float) 4);

        Budynek bud = new Budynek("bud1")
        bud.addPoziom(poz1);
        bud.addPoziom(poz2);

        float wyn = bud.getFullCube();

        assertEquals(5,wyn,0.1);
    }

    @Test
    public void getFullHeatingTest() {
        Poziom poz1 = mock(Poziom.class);
        when(poz1.getFullHeating()).thenReturn((float) 1);

        Poziom poz2 = mock(Poziom.class);
        when(poz2.getFullHeating()).thenReturn((float) 4);

        Budynek bud = new Budynek("bud1")
        bud.addPoziom(poz1);
        bud.addPoziom(poz2);

        float wyn = bud.getFullHeating();

        assertEquals(5,wyn,0.1);
    }

    @Test
    public void getFullLightTest() {
        Poziom poz1 = mock(Poziom.class);
        when(poz1.getFullLight()).thenReturn((float) 1);

        Poziom poz2 = mock(Poziom.class);
        when(poz2.getFullLight()).thenReturn((float) 4);

        Budynek bud = new Budynek("bud1")
        bud.addPoziom(poz1);
        bud.addPoziom(poz2);

        float wyn = bud.getFullLight();

        assertEquals(5,wyn,0.1);
    }
}
