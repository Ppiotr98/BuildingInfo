package pl.put.poznan.buildingInfo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * <p>Klasa BuildingInfoApplication</p>
 *
 * @author daniktl, vieja, ppiotr98
 * @version $Id: $Id
 */
@SpringBootApplication(scanBasePackages = {"pl.put.poznan.buildingInfo.rest"})
public class BuildingInfoApplication {

    /**
     * <p>Głowna metoda która uruchamia aplikację SpringBoot</p>
     *
     * @param args lista argumentów typu {@link java.lang.String}.
     */
    public static void main(String[] args) {
        SpringApplication.run(BuildingInfoApplication.class, args);
    }
}
