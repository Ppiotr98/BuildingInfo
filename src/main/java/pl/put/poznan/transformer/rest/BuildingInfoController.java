package pl.put.poznan.transformer.rest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.app.Budynek;
import pl.put.poznan.transformer.app.Pomieszczenie;
import pl.put.poznan.transformer.app.Poziom;


/**
 * <p>BuildingInfoController class.</p>
 *
 * @author daniktl
 * @version $Id: $Id
 */
@RestController
public class BuildingInfoController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoController.class);

    /**
     * <p>post.</p>
     *
     * @param action a {@link java.lang.String} object.
     * @param pom a {@link java.lang.String} object.
     * @param poz a {@link java.lang.String} object.
     * @param payload a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    @RequestMapping(value = "/{action}", method = RequestMethod.POST, produces = "application/json")
    public String post(@PathVariable("action") String action,
                      @RequestParam(name="pom", required = false) String pom,
                      @RequestParam(name="poz", required = false) String poz,
                      @RequestBody(required = false) String payload) {

        // log the parameters
        logger.debug(action);
        if (payload.equals("")) {
            JSONObject jo = new JSONObject();
            jo.put("result", false);
            jo.put("message", "Empty request body");
            return jo.toString();
        }
        JSONObject jo = new JSONObject(payload);
        // show input body in logs (debug only)
        logger.debug(jo.toString());
        // create new budynek. because we have only one budynek, we don't need to give them id
        Budynek budynek = new Budynek();
        // get levels array from json
        JSONArray poziomy = jo.getJSONArray("poziomy");
        // for each level in the building
        for (int i=0; i<poziomy.length(); i++){
            // get level info and create level
            JSONObject poz_tmp_jo = poziomy.getJSONObject(i);
            String  id_poz = poz_tmp_jo.getString("id");
            String name_poz = poz_tmp_jo.getString("name");
            Poziom poz_tmp = new Poziom(id_poz, name_poz);
            JSONArray pomieszczenia = poz_tmp_jo.getJSONArray("pomieszczenia");
            // for each room on the level
            for (int j=0; j<pomieszczenia.length(); j++){
                // get info about room and create object
                JSONObject pom_tmp_jo = pomieszczenia.getJSONObject(j);
                String id_pom = pom_tmp_jo.getString("id");
                String name_pom = pom_tmp_jo.getString("name");
                float area = pom_tmp_jo.getFloat("area");
                float cube = pom_tmp_jo.getFloat("cube");
                float heating = pom_tmp_jo.getFloat("heating");
                int light = pom_tmp_jo.getInt("light");
                Pomieszczenie pom_tmp = new Pomieszczenie(id_pom, name_pom, area, cube, heating, light);
                // add object into level's set
                poz_tmp.addPomieszczenie(pom_tmp);
            }
            // add level into building's set
            budynek.addPoziom(poz_tmp);
        }
        // return result according to the request
        return budynek.zwrocWynik(action, pom, poz).toString();
    }



}


