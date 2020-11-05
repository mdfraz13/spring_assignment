## Mobile Handset Search Assignment

### Objective
To create Java application to search Handsets.

### How to run
* mvn spring-boot:run

#### Request 
* curl --location --request GET 'http://localhost:8080/mobile/search?priceEur=200&announceDate=1999'

#### Response Body

##### Success Body 

{
    "totalHandsetsFound": 2,
    "data": [
        {
            "id": 28354,
            "brand": "Ericsson",
            "phone": "Ericsson A1018s",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/er1018sb.gif",
            "release": {
                "announceDate": "1999",
                "priceEur": "200"
            },
            "sim": "Mini-SIM",
            "resolution": "3 x 12 chars",
            "hardware": {
                "audioJack": "No",
                "gps": "No",
                "battery": "Removable NiMH 800 mAh battery"
            }
        },
        {
            "id": 26894,
            "brand": "Ericsson",
            "phone": "Ericsson I 888",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/eri888b.gif",
            "release": {
                "announceDate": "1999",
                "priceEur": "200"
            },
            "sim": "Mini-SIM",
            "resolution": "3 x 12 chars",
            "hardware": {
                "audioJack": "No",
                "gps": "No",
                "battery": "Removable NiMH 800 mAh battery"
            }
        }
    ]
}

##### Error Body 

{
    "totalHandsetsFound": 0,
    "error": {
        "code": "NO_DATA",
        "desc": "No records with the searched params"
    }
} 