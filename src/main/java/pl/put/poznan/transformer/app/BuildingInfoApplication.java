package pl.put.poznan.transformer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * <p>BuildingInfoApplication class.</p>
 *
 * @author daniktl
 * @version $Id: $Id
 */
@SpringBootApplication(scanBasePackages = {"pl.put.poznan.transformer.rest"})
public class BuildingInfoApplication {

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        SpringApplication.run(BuildingInfoApplication.class, args);
    }
}
