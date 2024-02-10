# Api facturation

Ce programme caclule la facture pour 2 types de clients :

A) Les clients Pro, qui ont les propriétés suivantes :
- Reference Client (EKW + 8 caractères numériques)
- N° SIRET
- Raison Sociale
- CA

B) Les particuliers, qui ont les propriétés suivantes :
- Reference Client (EKW + 8 caractères numériques)
- Civilité
- Nom
- Prénom

Un client peut consommer deux types d'énergies :
- Electricité
- Gaz

Chaque énergie est facturée au kWh.
- Pour les particuliers, le prix du kWh est de 0,121 € pour l'électricité et 0,115€ pour le gaz
- Pour les pro, ayant un CA supérieur à 1 000 000 €, le prix du kWh est de 0,114 € pour l'électricité et 0,111€ pour le gaz
- Pour les pro, ayant un CA inférieur à 1 000 000 €, le prix du kWh est de 0,118 € pour l'électricité et 0,113€ pour le gaz

# TODO
- Créer un advice et ses tests
- Rajouter des logs
- Créer une factory pour les calculators
- Génération du Swagger

# Lancement du programme

JDK : Java 17
se placer à la racine du projet puis : ./mvnw spring-boot:run

Sur Postman :
POST http://localhost:8080/api-facturation/facturations

Body (Json):
```json
  {
  "client": {
      "reference": "EKW12345678",
      "type": "PRO",
      "sales": "0.0"
  },
  "consumptions": [
    {
        "energyType": "GAZ",
        "amount": "1000.0"
    },
    {
        "energyType": "GAZ",
        "amount": "1000.0"
    }
  ]
}
```

Ci-dessous la commande curl pour tester l'app en cmd (Windows)

```bash
curl -L "http://localhost:8080/api-facturation/facturations" -H "Content-Type: application/json" -d "{\"client\": {\"reference\": \"EKW12345678\",\"type\": \"PRO\",\"sales\": \"0.0\"},\"consumptions\": [{\"energyType\": \"GAZ\",\"amount\": \"1000.0\"},{\"energyType\": \"GAZ\",\"amount\": \"1000.0\"}]}"

```
