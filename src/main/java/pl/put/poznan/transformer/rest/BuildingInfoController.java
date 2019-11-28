package pl.put.poznan.transformer.rest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.app.Budynek;
import pl.put.poznan.transformer.app.Pomieszczenie;
import pl.put.poznan.transformer.app.Poziom;
import pl.put.poznan.transformer.logic.BuildingInfo;


@RestController
public class BuildingInfoController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoController.class);

    @RequestMapping(value = "/{action}", method = RequestMethod.POST, produces = "application/json")
    public String post(@PathVariable("action") String action,
                      @RequestParam(name="pom", required = false) String pom,
                      @RequestParam(name="poz", required = false) String poz,
                      @RequestParam(name="bud", required = false) boolean bud,
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
        logger.debug(jo.toString());
        Budynek budynek = new Budynek("1");
        JSONArray poziomy = jo.getJSONArray("poziomy");
        for (int i=0; i<poziomy.length(); i++){
            JSONObject poz_tmp_jo = poziomy.getJSONObject(i);
            String  id_poz = poz_tmp_jo.getString("id");
            String name_poz = poz_tmp_jo.getString("name");
            Poziom poz_tmp = new Poziom(id_poz, name_poz);
            JSONArray pomieszczenia = poz_tmp_jo.getJSONArray("pomieszczenia");
            for (int j=0; j<pomieszczenia.length(); j++){
                JSONObject pom_tmp_jo = pomieszczenia.getJSONObject(j);
                String id_pom = pom_tmp_jo.getString("id");
                String name_pom = pom_tmp_jo.getString("name");
                float area = pom_tmp_jo.getFloat("area");
                float cube = pom_tmp_jo.getFloat("cube");
                float heating = pom_tmp_jo.getFloat("heating");
                int light = pom_tmp_jo.getInt("light");
                Pomieszczenie pom_tmp = new Pomieszczenie(id_pom, name_pom, area, cube, heating, light);
                poz_tmp.addPomieszczenia(pom_tmp);
            }
            budynek.addPoziom(poz_tmp);
        }
        return budynek.zwrocWynik(action, pom, poz, bud).toString();
    }



}


