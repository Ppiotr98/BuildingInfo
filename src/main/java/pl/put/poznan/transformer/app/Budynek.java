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

    // skoro i tak zwrocWynik wywołujemy na budynku w kontrolerze, to równie dobrze ta metoda moze być tutaj
    // wtedy możemy wywołać odpowiednie metody na poziomach w secie
    public JSONObject zwrocWynik(String action, String pom, String poz, boolean bud) {
        Set<String> allowed_actions = new HashSet<>(Arrays.asList("area", "cube"));
        JSONObject jo = new JSONObject();
        if (allowed_actions.contains(action)) {
            if (action.equals("area")) {
                if (bud) { // dla całego budynku
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
            }

            // TODO: other methods

        } else jo.put("result", "failure");

        return jo;
    }

    // zwraca pomieszczenie, jeżeli posiada je na liście
    public Poziom findPoziom(String pom) {
        for (Poziom tmp : this.poziomy) {
            if (tmp.getId().equals(pom)) return tmp;
        }
        return null;
    }
}
