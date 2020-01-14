Struktura danych

    • Lokacja to budynek, poziom, lub pomieszczenie
    • Budynek może składać się z poziomów a te z pomieszczeń
    • Każda lokalizacja jest charakteryzowana przez:
        o id – unikalny identyfikator
        o name – opcjonalna nazwa lokalizacji
    • Pomieszczenie dodatkowo jest charakteryzowane przez:
        o area = powierzchnia w m^2
        o cube = kubatura pomieszczenia w m^3
        o heating = poziom zużycia energii ogrzewania (float)
        o light – łączna moc oświetlenia

To run app:

    * Run BuildingInfoApplication class
    * Open PostMan
    * Send POST request on the url: 127.0.0.1:8080/full_area?bud=true with body[type=raw->json] ,where:
        - 127.0.0.1:8080 - static url of application
        - full_area - name of action performed
        - [bud|pom|poz] - type of location checked (budynek - bool, pom - id of pomieszczenie from json (string), poz, id of poziom from json (string))
        - data are located in data.json file (copy and paste in PostMan)
    * Return json object values:
        - result (success, or not)
        - message|another requested value

![Build status](https://travis-ci.org/Ppiotr98/BuildingInfo.svg?branch=master)
