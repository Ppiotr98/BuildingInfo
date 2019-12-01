package pl.put.poznan.transformer.app;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Budynek extends Lokalizacja {
    private Set<Poziom> poziomy = new HashSet<>();

    public Budynek() {
        super("1");
    }

    public Budynek(String id, String name) {
        super(id, name);
    }

    public void addPoziom(Poziom poziom) {
        this.poziomy.add(poziom);
    }

    public float getFullArea(){
        float res = 0;
        // calculate full building area
        for (Iterator<Poziom> it = this.poziomy.iterator(); it.hasNext(); ){
            Poziom poz_tmp = it.next();
            res += poz_tmp.getFullArea();
        }
        return res;
    }

    public float getFullCube(){
        float res = 0;
        // calculate full building cube
        for (Iterator<Poziom> it = this.poziomy.iterator(); it.hasNext(); ){
            Poziom poz_tmp = it.next();
            res += poz_tmp.getFullCube();
        }
        return res;
    }

    public float getFullHeating(){
        float res = 0;
        // calculate full building heating
        for (Iterator<Poziom> it = this.poziomy.iterator(); it.hasNext(); ){
            Poziom poz_tmp = it.next();
            res += poz_tmp.getFullHeating();
        }
        return res;
    }

    public float getFullLight(){
        float res = 0;
        // calculate full building light
        for (Iterator<Poziom> it = this.poziomy.iterator(); it.hasNext(); ){
            Poziom poz_tmp = it.next();
            res += poz_tmp.getFullLight();
        }
        return res;
    }

    // skoro i tak zwrocWynik wywołujemy na budynku w kontrolerze, to równie dobrze ta metoda moze być tutaj
    // wtedy możemy wywołać odpowiednie metody na poziomach w secie
    public JSONObject zwrocWynik(String action, String pom, String poz) {
        switch (action) {
            case "area" :
                return actionArea(pom, poz);
            case "cube" :
                return actionCube(pom, poz);
            case "heating" :
                return actionHeating(pom, poz);
            case "light" :
                return actionLight(pom, poz);

            default:
                return new JSONObject() {{
                    put("result", "failure");
                }};
        }
    }

    public JSONObject actionArea(String pom, String poz) {
        JSONObject jo = new JSONObject();
        if (poz == null) { // dla całego budynku
            jo.put("result", "success");
            float res = getFullArea();
            jo.put("Full area of building", res);
        } else { // dla konkretnego poziomu
            Poziom poziom = findPoziom(poz);
            if (poziom!=null) { // poziom o takim id istnieje
                if (pom == null) { // nie podano pomieszczenia - chemy powierzchnie całego poziomu
                    jo.put("result", "success");
                    float res = poziom.getFullArea();
                    jo.put("Full area of " + poziom.getName(), res);
                } else { // chcemy powierzchnie konkretnego pomieszczenia
                    Pomieszczenie pomieszczenie = poziom.findPomieszczenie(pom);
                    if (pomieszczenie!=null) { //jezeli takie pomeiszczenie istnieje na tym poziomie
                        jo.put("result", "success");
                        float res = pomieszczenie.getFullArea();
                        jo.put("Full area of " + pomieszczenie.getName() + " at " + poziom.getName(), res);
                    } else jo.put("result", "failure");
                }
            } else jo.put("result", "failure");
        }
        return jo;
    }

    // zwraca pomieszczenie, jeżeli posiada je na liście
    public Poziom findPoziom(String pom) {
        for (Poziom tmp : this.poziomy) {
            if (tmp.getId().equals(pom)) return tmp;
        }
        return null;
    }

    public JSONObject actionCube(String pom, String poz) {
        JSONObject jo = new JSONObject();
        if (poz == null) { // dla całego budynku
            jo.put("result", "success");
            float res = getFullCube();
            jo.put("Full cube of building", res);
        } else { // dla konkretnego poziomu
            Poziom poziom = findPoziom(poz);
            if (poziom!=null) { // poziom o takim id istnieje
                if (pom == null) { // nie podano pomieszczenia - chemy kubature całego poziomu
                    jo.put("result", "success");
                    float res = poziom.getFullCube();
                    jo.put("Full cube of " + poziom.getName(), res);
                } else { // chcemy kubature konkretnego pomieszczenia
                    Pomieszczenie pomieszczenie = poziom.findPomieszczenie(pom);
                    if (pomieszczenie!=null) { //jezeli takie pomeiszczenie istnieje na tym poziomie
                        jo.put("result", "success");
                        float res = pomieszczenie.getFullCube();
                        jo.put("Full cube of " + pomieszczenie.getName() + " at " + poziom.getName(), res);
                    } else jo.put("result", "failure");
                }
            } else jo.put("result", "failure");
        }
        return jo;
    }

    public JSONObject actionHeating(String pom, String poz) {
        JSONObject jo = new JSONObject();
        if (poz == null) { // dla całego budynku
            jo.put("result", "success");
            float res = getFullHeating();
            jo.put("Full heating of building", res);
        } else { // dla konkretnego poziomu
            Poziom poziom = findPoziom(poz);
            if (poziom!=null) { // poziom o takim id istnieje
                if (pom == null) { // nie podano pomieszczenia - chemy ogrzewanie całego poziomu
                    jo.put("result", "success");
                    float res = poziom.getFullHeating();
                    jo.put("Full heating of " + poziom.getName(), res);
                } else { // chcemy ogrzewanie konkretnego pomieszczenia
                    Pomieszczenie pomieszczenie = poziom.findPomieszczenie(pom);
                    if (pomieszczenie!=null) { //jezeli takie pomeiszczenie istnieje na tym poziomie
                        jo.put("result", "success");
                        float res = pomieszczenie.getFullHeating();
                        jo.put("Full heating of " + pomieszczenie.getName() + " at " + poziom.getName(), res);
                    } else jo.put("result", "failure");
                }
            } else jo.put("result", "failure");
        }
        return jo;
    }

    public JSONObject actionLight(String pom, String poz) {
        JSONObject jo = new JSONObject();
        if (poz == null) { // dla całego budynku
            jo.put("result", "success");
            float res = getFullLight();
            jo.put("Full light of building", res);
        } else { // dla konkretnego poziomu
            Poziom poziom = findPoziom(poz);
            if (poziom!=null) { // poziom o takim id istnieje
                if (pom == null) { // nie podano pomieszczenia - chemy oswietlenie całego poziomu
                    jo.put("result", "success");
                    float res = poziom.getFullLight();
                    jo.put("Full light of " + poziom.getName(), res);
                } else { // chcemy oswietlenie konkretnego pomieszczenia
                    Pomieszczenie pomieszczenie = poziom.findPomieszczenie(pom);
                    if (pomieszczenie!=null) { //jezeli takie pomeiszczenie istnieje na tym poziomie
                        jo.put("result", "success");
                        float res = pomieszczenie.getFullLight();
                        jo.put("Full light of " + pomieszczenie.getName() + " at " + poziom.getName(), res);
                    } else jo.put("result", "failure");
                }
            } else jo.put("result", "failure");
        }
        return jo;
    }
}
