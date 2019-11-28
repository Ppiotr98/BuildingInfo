package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.BuildingInfo;

import java.util.Arrays;


@RestController
@RequestMapping("/{action}")
public class BuildingInfoController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoController.class);

    // nie potrzebujemy metody get ponieważ musimy wysłać coś. UNUSED
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable String action,
                              @RequestParam(value="transforms", defaultValue="upper,escape") String[] transforms) {

        // log the parameters
        logger.debug(action);
        logger.debug(Arrays.toString(transforms));

        // do the transformation, you should run your logic here, below just a silly example
        BuildingInfo transformer = new BuildingInfo(transforms);
        return transformer.transform(action);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(@PathVariable String action,
                      @RequestBody String[] r_body) {

        // log the parameters
        logger.debug(action);
        logger.debug(Arrays.toString(r_body));

        // do the transformation, you should run your logic here, below just a silly example
        BuildingInfo transformer = new BuildingInfo(r_body);
        return transformer.transform(action);
    }



}


