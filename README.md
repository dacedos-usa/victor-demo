# VICTOR DEMO

## CONTENT

- MQ Queue
- MongoDB + UI
- Postgres + UI
- Spring boot services

## DIAGRAM
> https://sequencediagram.org/

```
title VICTOR DEMO

participant user
participant producer
participant mq
participant subscriber
participant mongo

user->producer: QR Scan
producer-->mq: message to topic vlezana
mq-->subscriber: message to topic vlezana
subscriber->mongo: store
```


## DOCKER

### RUN

```
docker compose up
```

### STOP

When you are in the docker compose tab
```ctrl + c```

or when you are in a different tab
```docker compose down```

To stop a specific container ``` docker stop ${containerId}```

### LIST RUNNING CONTAINERS

```docker ps```

```shell
dacedos@MacBook-Pro subscriber-service % docker ps
CONTAINER ID   IMAGE                      COMMAND                  CREATED          STATUS          PORTS                                                                                   NAMES
ec5674a4002a   symptoma/activemq:latest   "/entrypoint.sh"         41 seconds ago   Up 39 seconds   1883/tcp, 5672/tcp, 0.0.0.0:8161->8161/tcp, 61613-61614/tcp, 0.0.0.0:61616->61616/tcp   mq_container
2736c206a04e   dpage/pgadmin4             "/entrypoint.sh"         41 seconds ago   Up 39 seconds   443/tcp, 0.0.0.0:8888->80/tcp                                                           pgadmin_container
dd6c5fa30023   postgres                   "docker-entrypoint.s…"   41 seconds ago   Up 39 seconds   0.0.0.0:5432->5432/tcp                                                                  postgres_container
b5955c925633   mongo-express              "tini -- /docker-ent…"   41 seconds ago   Up 38 seconds   0.0.0.0:8090->8081/tcp                                                                  mongo_express_container
67a83f31c83d   mongo                      "docker-entrypoint.s…"   41 seconds ago   Up 39 seconds   0.0.0.0:27017->27017/tcp                                                                mongo_container
```

### LIST IMAGES

```docker images```

### DELETE IMAGE
```docker rmi ${imageId}```

## REFERENCE

- Mongo Express UI for Mongo: http://localhost:8090/

- pgadmin UI for posgres: http://localhost:8888
  - username@domain.com
  - password

- MQ UI : http://localhost:8161
  - admin
  - admin

## USAGE

### Services

- MQ Producer
  - http://localhost:8088/actuator/health
 
- MQ Consumer
  - http://localhost:8089/actuator/health 

#### PRODUCER
```curl
curl --location 'http://127.0.0.1:8088/api/book' \
--header 'Content-Type: application/json' \
--data '{
          "property": "victor",
          "customer": "pos_receipts",
          "phoneNumber": "12222222222",
          "startDate": "2010-01-01",
          "endDate": "2010-01-01"
        }'
```

#### CONSUMER
```curl
curl --location 'http://127.0.0.1:8089/api/book' 
```

## NEXT STEPS
- ISTIO : https://istio.io/v1.2/docs/concepts/what-is-istio/
  - https://istio.io/v1.2/docs/setup/consul/quick-start/