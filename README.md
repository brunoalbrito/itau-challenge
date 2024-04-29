## Automovel API - Itau Tech Challenge

### How to run

```bash
docker compose up -d
./gradlew bootRun
```

### Post - Criacao
```bash
curl --location 'http://localhost:8080/cadastroAutomoveis' \
--header 'Content-Type: application/json' \
--data '{
    "marca": "Fiat",
    "modelo": "Palio",
    "valor": 25000
}'
```

### Get - Listagem
```bash
curl --location 'http://localhost:8080/automoveis'
```

### Requirements 

* Java 21
* Docker
