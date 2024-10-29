# Kafka Schema Registry

### Start the platform
```
docker-compose up -d
```

### Start Producer
```
docker exec -it broker kafka-console-producer --broker-list broker:29092 --topic commands
```

### Start Consumer
```
docker exec -it broker kafka-console-consumer --bootstrap-server broker:29092 --topic commands
```

### Run interactive shell inside the Broker container
```
docker exec -it broker bash
```

### Change to Log Directory
```
cd /var/lib/kafka/data
```

### Inspect binary file
```
less 00000000000000000000.log
```

### Start AVRO Producer
Unix / Linux
```
docker exec -it schema-registry kafka-avro-console-producer --broker-list broker:29092 --topic commands-avro --property value.schema='{"type":"record","name":"AudioCommand","fields":[{"name":"command","type":"string"}]}'
```
Windows
```
docker exec -it schema-registry kafka-avro-console-producer --broker-list broker:29092 --topic commands-avro --property value.schema='{\"type\":\"record\",\"name\":\"AudioCommand\",\"fields\":[{\"name":\"command\",\"type\":\"string\"}]}'
```

### Start AVRO Consumer
```
docker exec -it schema-registry kafka-avro-console-consumer --bootstrap-server broker:29092 --topic commands-avro --from-beginning
```

### JSON Message
```
{ "command":"Hey, tell me something about Docker" }
```

### Stop the platform
```
docker-compose down
```

-------------------------------------------------------------------------------
###Reset offset by shifting 1
```
docker exec -it broker kafka-consumer-groups --bootstrap-server broker:9092 --group json.payment.consumer --describe

docker exec -it broker kafka-consumer-groups --bootstrap-server broker:9092 --group json.reminders.consumer --reset-offsets --shift-by 1 --topic reminders-json --execute
```


------------------
###produce JSON form console
```
docker exec -it schema-registry kafka-json-schema-console-producer --bootstrap-server broker:29092 --topic test-json --property schema.registry.url=http://schema-registry:8081 --property value.schema='{\"type\":\"object\", \"properties\":{\"id\":{\"type\":\"string\"},\"amount\":{\"type\":\"number\"} }}' --property "parse.key=true" --property "key.separator=:" --property key.serializer=org.apache.kafka.common.serialization.StringSerializer

docker exec -it schema-registry kafka-json-schema-console-producer --bootstrap-server broker:29092 --topic test-json --property schema.registry.url=http://schema-registry:8081 --property value.schema='{"type":"object", "properties":{"id":{"type":"string"},"amount":{"type":"number"} }}' --property "parse.key=true" --property "key.separator=:" --property key.serializer=org.apache.kafka.common.serialization.StringSerializer

2:{"id": "2", "amount": 23}
3:{"id": "3", "amount": 27}
```

```
docker exec -it schema-registry kafka-json-schema-console-producer --bootstrap-server broker:29092 --topic test-json --property schema.registry.url=http://schema-registry:8081 --property value.schema.id=1 --property "parse.key=true" --property "key.separator=:" --property key.serializer=org.apache.kafka.common.serialization.StringSerializer

2:{"test": "2", "event": "2"}
```

### produce Avro form console
### produce with schema value
```
docker exec -it schema-registry kafka-avro-console-producer --bootstrap-server broker:29092 --topic commands-avro --property schema.registry.url=http://schema-registry:8081 --property value.schema='{\"type\":\"record\",\"name\":\"AudioCommand\",\"fields\":[{\"name\":\"command\",\"type\":\"string\"}]}'
```
### JSON Message
```
{ "command":"Test Audio Command" }
```

### produce with schema value and key
```
docker exec -it schema-registry kafka-avro-console-producer --bootstrap-server broker:29092 --topic commands-avro --property schema.registry.url=http://schema-registry:8081 --property value.schema='{\"type\":\"record\",\"name\":\"AudioCommand\",\"fields\":[{\"name\":\"command\",\"type\":\"string\"}]}' --property "parse.key=true" --property "key.separator=:" --property key.serializer=org.apache.kafka.common.serialization.StringSerializer
```

### JSON Message
```
1:{ "command":"Test Audio Command" }
```

### produce with existing schema schema id and key
```
docker exec -it schema-registry kafka-avro-console-producer --bootstrap-server broker:29092 --topic commands-avro --property schema.registry.url=http://schema-registry:8081 --property value.schema.id=2 --property "parse.key=true" --property "key.separator=:" --property key.serializer=org.apache.kafka.common.serialization.StringSerializer
```

### JSON Message
```
1:{ "command":"Test Audio Command" }
3:{ "command0":"Test Audio Command0","command":"Test Audio Command1" }
```
