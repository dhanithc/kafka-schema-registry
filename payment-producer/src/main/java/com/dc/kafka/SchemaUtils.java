package com.dc.kafka;

import com.dc.kafka.json.btlnse.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.kjetland.jackson.jsonSchema.JsonSchemaConfig;
import com.kjetland.jackson.jsonSchema.JsonSchemaDraft;
import com.kjetland.jackson.jsonSchema.JsonSchemaGenerator;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by dhanith on 1/31/2024
 */
public class SchemaUtils {

    private static final Logger LOG = LoggerFactory.getLogger(SchemaUtils.class);
    public static <T> String generateJsonSchema(Class<T> className) {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonSchemaConfig config = JsonSchemaConfig.nullableJsonSchemaDraft4().withJsonSchemaDraft(JsonSchemaDraft.DRAFT_2019_09);
        JsonSchemaGenerator jsonSchemaGenerator = new JsonSchemaGenerator(objectMapper, config);

        // Generate JSON schema
        JsonNode jsonSchemaNode = jsonSchemaGenerator.generateJsonSchema(className);

        // Customize the schema to set "additionalProperties": false
        if (jsonSchemaNode.isObject()) {
            ((ObjectNode) jsonSchemaNode).put("additionalProperties", false);
        }

        String schemaAsString;
        try {
            schemaAsString = objectMapper.writeValueAsString(jsonSchemaNode);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        LOG.info("Schema: " + schemaAsString);

        return schemaAsString;
    }

    public static String generateJsonSchemaTypeString(String schema) {

        String jsonSchemaNode = new JSONObject()
                .put("schema", schema)
                .put("schemaType", "JSON")
                .toString();
        LOG.info("SchemaRequest: " + jsonSchemaNode);

        return jsonSchemaNode;
    }

    public static void main(String[] args) {
        String schema = SchemaUtils.generateJsonSchema(Payment.class);
        SchemaUtils.generateJsonSchemaTypeString(schema);
    }
}
