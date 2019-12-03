package pl.put.poznan.buildingInfo.logic;

import org.json.JSONObject;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Klasa budynek
 *
 * @author daniktl, vieja, ppiotr98
 * @version $Id: $Id
 */
public class Budynek extends Lokalizacja {
    /**
     * Lista poziomów w {@link Budynek}
     */
    private Set<Poziom> poziomy = new HashSet<>();

    /**
     * Tworzy budynek ze stałym identyfikatorem 1
     */
    public Budynek() {
        super("1");
    }

    /**
     * Konstruktor {@link Budynek}
     *
     * @deprecated konstruktor wykorzystywany wcześniej do tworzenia objektów klasy Budynek
     * @param id identyfikator budynku typu {@link java.lang.String}.
     * @param name nazwa budynku typu {@link java.lang.String}.
     */
    public Budynek(String id, String name) {
        super(id, name);
    }


    /**
     * Metoda która umożliwia dodawanie poziomów na listę poziomów budynku
     * @param poziom objekt typu {@link Poziom}, który chcemy dodać na listę poziomów dla tego budynku
     */
    public void addPoziom(Poziom poziom) {
        this.poziomy.add(poziom);
    }

    /**
     * Metoda która zwraca powierzchnie całęgo budynku
     * @return float powierzchnia
     */
    public float getFullArea(){
        float res = 0;
        // calculate full building area
        for (Iterator<Poziom> it = this.poziomy.iterator(); it.hasNext(); ){
            Poziom poz_tmp = it.next();
            res += poz_tmp.getFullArea();
        }
        return res;
    }

    /**
     * Metoda która zwraca kubaturę całęgo budynku
     * @return float kubatura
     */
    public float getFullCube(){
        float res = 0;
        // calculate full building cube
        for (Iterator<Poziom> it = this.poziomy.iterator(); it.hasNext(); ){
            Poziom poz_tmp = it.next();
            res += poz_tmp.getFullCube();
        }
        return res;
    }

    /**
     * Metoda która zwraca poziom zyżycia energii dla całęgo budynku
     *
     * @return float zużycie energii
     */
    public float getFullHeating(){
        float res = 0;
        // calculate full building heating
        for (Iterator<Poziom> it = this.poziomy.iterator(); it.hasNext(); ){
            Poziom poz_tmp = it.next();
            res += poz_tmp.getFullHeating();
        }
        return res;
    }

    /**
     * Metoda która zwraca łączną moc oświetlenia dla całęgo budynku
     *
     * @return float
     */
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

    /**
     * Główna metoda, wywoływana w {@link pl.put.poznan.buildingInfo.rest.BuildingInfoController}.
     *
     * @param action jakie dane użytkownik chce dostać. Dostępnę są następne akcje:
     *               1) area - zwróć powierzchnie dla całego budynku/poziomu/pomieszczenia
     *               2) cube - zwróć kubaturę dla całego budynku/poziomu/pomieszczenia
     *               3) heating - zwróć poziom zyżycia energii dla całęgo budynku/poziomu/pomieszczenia
     *               4) light - zwróć łączną moc oświetlenia dla całęgo budynku/poziomu/pomieszczenia
     * @param pom id pomiesczenia typu {@link java.lang.String} dla którego chcemy otrzymać informację (jeśli null - nie interesuje)
     * @param poz id pomiesczenia typu {@link java.lang.String} dla którego poziomu chcemy otrzymać informację (jeśli null - nie interesuje)
     * @return wynik w postaci objektu klasy {@link org.json.JSONObject}, który potem zwracamy użytkownikowi:
     *          1) result - czy udało się obliczyć to co chciał użytkownik
     *          2) message - wynik bądż wiadomość błędu
     */
    public JSONObject zwrocWynik(String action, String pom, String poz, String threshold_value) {
        switch (action) {
            case "area" :
                return actionArea(pom, poz);
            case "cube" :
                return actionCube(pom, poz);
            case "heating" :
                return actionHeating(pom, poz);
            case "light" :
                return actionLight(pom, poz);
            case "threshold":
                return actionThreshold(threshold_value);
            default:
                return new JSONObject() {{
                    put("result", "failure");
                    put("message", "Wrong action requested");
                }};
        }
    }

    /**
     * Metoda, zwracająca odpowiednią powierzchnię dla budynku, poziomu bądż pomieszczenia
     *
     * @param pom id pomiesczenia typu {@link java.lang.String} dla którego chcemy otrzymać informację (jeśli null - nie interesuje)
     * @param poz id pomiesczenia typu {@link java.lang.String} dla którego poziomu chcemy otrzymać informację (jeśli null - nie interesuje)
     * @return wynik w postaci objektu klasy {@link org.json.JSONObject}, który potem zwracamy użytkownikowi:
     *          1) result - czy udało się obliczyć to co chciał użytkownik
     *          2) message - wynik bądż wiadomość błędu
     */
    public JSONObject actionArea(String pom, String poz) {
        JSONObject jo = new JSONObject();
        if (poz == null) { // dla całego budynku
            jo.put("result", "success");
            float res = this.getFullArea();
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

    /**
     * Metoda która zwraca poziom na którym istnieje pomieszczenie o dannym identyfikatorze.
     * Jeżeli pomieszczenie z tym identyfikatorem nie istnieje - zwraca null
     * @param pom id pomiesczenia typu {@link java.lang.String}.
     * @return objekt klasy {@link Poziom}.
     */
    public Poziom findPoziom(String pom) {
        for (Poziom tmp : this.poziomy) {
            if (tmp.getId().equals(pom)) return tmp;
        }
        return null;
    }

    /**
     * Metoda zwracająca kubaturę dla całego budynku/poziomu/pomieszczenia
     * @param pom id pomiesczenia typu {@link java.lang.String}.
     * @param poz id poziomu typu {@link java.lang.String}.
     * @return wynik w postaci objektu klasy {@link org.json.JSONObject} który potem zwracamy użytkownikowi:
     *      1) result - czy udało się obliczyć to co chciał użytkownik
     *      2) message - wynik bądż wiadomość błędu
     */
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

    /**
     * Metoda zwracająca poziom zużycia energii ogrzewania
     * @param pom id pomiesczenia typu {@link java.lang.String}.
     * @param poz id poziomu typu {@link java.lang.String}.
     * @return wynik w postaci objektu klasy {@link org.json.JSONObject} który potem zwracamy użytkownikowi:
     *      1) result - czy udało się obliczyć to co chciał użytkownik
     *      2) message - wynik bądż wiadomość błędu
     */
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

    /**
     * Metoda zwracająca moć oświetlenia
     * @param pom id pomiesczenia typu {@link java.lang.String}.
     * @param poz id poziomu typu {@link java.lang.String}.
     * @return wynik w postaci objektu klasy {@link org.json.JSONObject} który potem zwracamy użytkownikowi:
     *          1) result - czy udało się obliczyć to co chciał użytkownik
     *          2) message - wynik bądż wiadomość błędu
     */
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

    public JSONObject actionThreshold(String threshold) {
        JSONObject result = new JSONObject();
        float threshold_f;
        try {
            threshold_f = Float.parseFloat(threshold);
        }catch (NumberFormatException nfe){
            result.put("result", "failure");
            result.put("message", "Invalid threshold format");
            return result;
        }
        result.put("result", "success");
        JSONObject jo_pom_threshold = new JSONObject();
        for (Poziom poziom: this.poziomy) {
            jo_pom_threshold = poziom.getOverflowed(threshold_f, jo_pom_threshold);
        }
        result.put("Pomieszczenia", jo_pom_threshold);
        return result;
    }
}
