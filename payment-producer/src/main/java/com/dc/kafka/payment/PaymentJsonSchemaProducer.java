package com.dc.kafka.payment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.confluent.kafka.schemaregistry.json.JsonSchemaUtils;
import io.confluent.kafka.schemaregistry.json.SpecificationVersion;
import io.confluent.kafka.serializers.json.KafkaJsonSchemaSerializer;
import io.confluent.kafka.serializers.json.KafkaJsonSchemaSerializerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class PaymentJsonSchemaProducer {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentJsonSchemaProducer.class);
    private static final String JSON_PAYMENT_TOPIC = "payment-json";

    public static void main(String[] args) throws JsonProcessingException {

        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaJsonSchemaSerializer.class.getName());
        props.put(KafkaJsonSchemaSerializerConfig.FAIL_INVALID_SCHEMA, "true");
        props.put(KafkaJsonSchemaSerializerConfig.SCHEMA_SPEC_VERSION, SpecificationVersion.DRAFT_2019_09.toString());
        props.put(KafkaJsonSchemaSerializerConfig.AUTO_REGISTER_SCHEMAS, "false");
        props.put(KafkaJsonSchemaSerializerConfig.USE_LATEST_VERSION, "true");
//        props.put(KafkaJsonSchemaSerializerConfig.USE_SCHEMA_ID, 1);
        props.put(KafkaJsonSchemaSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");

        ObjectMapper mapper = new ObjectMapper();
        //JSON schema in JSON format
        JsonNode rawSchemaJson1 = mapper.readTree("""
                {
                  "$schema": "http://json-schema.org/draft/2019-09/schema#",
                  "title": "Payment",
                  "type": "object",
                  "additionalProperties": true,
                  "properties": {
                    "id": {
                      "type": "string",
                      "pattern": "^.*\\\\S+.*$",
                      "minLength": 1
                    },
                    "currNo": {
                      "type": "integer"
                    },
                    "companyCode": {
                      "oneOf": [
                        {
                          "type": "null",
                          "title": "Not included"
                        },
                        {
                          "type": "string"
                        }
                      ]
                    },
                    "bu": {
                      "oneOf": [
                        {
                          "type": "null",
                          "title": "Not included"
                        },
                        {
                          "type": "string"
                        }
                      ]
                    },
                    "audit": {
                      "oneOf": [
                        {
                          "type": "null",
                          "title": "Not included"
                        },
                        {
                          "$ref": "#/definitions/Audit"
                        }
                      ],
                      "javaType": "com.dc.kafka.json.btlnse"
                    },
                    "countryCode": {
                      "oneOf": [
                        {
                          "type": "null",
                          "title": "Not included"
                        },
                        {
                          "type": "string"
                        }
                      ]
                    },
                    "testOptionalField": {
                      "oneOf": [
                        {
                          "type": "null",
                          "title": "Not included"
                        },
                        {
                          "type": "string"
                        }
                      ]
                    },
                    "testRequiredField": {
                      "type": "string"
                    }
                  },
                  "required": [
                    "id",
                    "currNo",
                    "testRequiredField"
                  ],
                  "definitions": {
                    "Audit": {
                      "type": "object",
                      "additionalProperties": true,
                      "javaType": "com.dc.kafka.json.btlnse",
                      "properties": {
                        "companyId": {
                          "type": "string"
                        },
                        "eventCreationTime": {
                          "oneOf": [
                            {
                              "type": "null",
                              "title": "Not included"
                            },
                            {
                              "type": "string"
                            }
                          ]
                        },
                        "inputter": {
                          "oneOf": [
                            {
                              "type": "null",
                              "title": "Not included"
                            },
                            {
                              "type": "array",
                              "items": {
                                "type": "string"
                              }
                            }
                          ]
                        },
                        "eventId": {
                          "oneOf": [
                            {
                              "type": "null",
                              "title": "Not included"
                            },
                            {
                              "type": "string"
                            }
                          ]
                        },
                        "dateTime": {
                          "oneOf": [
                            {
                              "type": "null",
                              "title": "Not included"
                            },
                            {
                              "type": "array",
                              "items": {
                                "type": "string"
                              }
                            }
                          ]
                        }
                      },
                      "required": [
                        "companyId"
                      ]
                    }
                  }
                }
                """);

        //Create an envelope with payload using JsonSchemaUtils.envelope
        JsonNode objectNode1 = mapper.readTree("""
                {
                  "id": "KNW",
                  "currNo": 16732,
                  "companyCode": "SG00011",
                  "bu": "0058",
                  "audit": {
                    "companyId": "SG00011",
                    "eventCreationTime": "2024-01-26T16:40:34",
                    "inputter": [
                      "242343_SYS.E232_I_INAU"
                    ],
                    "eventId": "24234343-d34355-3432-2323-23232323",
                    "dateTime": [
                      "2019-04-08T16:40:00+08:00",
                      "2019-04-08T16:40:00+08:00"
                    ]
                  },
                  "countryCode": "KR",
                  "testOptionalField": null,
                  "testRequiredField": "RF"
                }
                """);

        //Create a producer record and send it to Kafka
        ProducerRecord<String, ObjectNode> record = new ProducerRecord<>("payment-json", "JScP", JsonSchemaUtils.envelope(rawSchemaJson1, objectNode1));

        LOG.info("Sending a payment:" + objectNode1);

        try (Producer<String, ObjectNode> producer = new KafkaProducer<>(props)){
            producer.send(record, (metadata, exception) -> {
                if (exception == null) {
                    LOG.info("Message sent successfully. Topic: " + metadata.topic() +
                            ", Partition: " + metadata.partition() +
                            ", Offset: " + metadata.offset());
                } else {
                    LOG.error("Error sending message: " + exception.getMessage());
                }
            });
        }
    }
}
