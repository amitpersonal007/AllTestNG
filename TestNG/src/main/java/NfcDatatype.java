import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class NfcDatatype {
    private static final String SCHEMA = "{\n" +
            "  \"$schema\": \"http://json-schema.org/draft-04/schema#\",\n" +
            "  \"type\": \"object\",\n" +
            "  \"properties\": {\n" +
            "    \"id\": {\n" +
            "      \"type\": \"integer\"\n" +
            "    },\n" +
            "    \"device_id\": {\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"version\": {\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"platform\": {\n" +
            "      \"type\": \"integer\"\n" +
            "    },\n" +
            "    \"operating_system\": {\n" +
            "      \"type\": \"integer\"\n" +
            "    },\n" +
            "    \"created_at\": {\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"updated_at\": {\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"active\": {\n" +
            "      \"type\": \"boolean\"\n" +
            "    }\n" +
            "  },\n" +
            "  \"required\": [\n" +
            "    \"id\",\n" +
            "    \"device_id\",\n" +
            "    \"version\",\n" +
            "    \"platform\",\n" +
            "    \"operating_system\",\n" +
            "    \"created_at\",\n" +
            "    \"updated_at\",\n" +
            "    \"active\"\n" +
            "  ]\n" +
            "}";

    public static void main(String[] args) {
        String jsonData = "{\"id\": 232, \"device_id\": \"ABC123\", \"version\": \"1.0\", \"platform\": 1, \"operating_system\": 2, \"created_at\": \"2023-07-25\", \"updated_at\": \"2023-07-25\", \"active\": true}";

        // Parse the JSON schema and data
        JsonParser parser = new JsonParser();
        JsonObject schemaObject = parser.parse(SCHEMA).getAsJsonObject();
        JsonObject dataObject = parser.parse(jsonData).getAsJsonObject();

        // Validate data against the schema
        if (validateData(schemaObject, dataObject)) {
            System.out.println("Data is valid according to the schema.");
        } else {
            System.out.println("Data is not valid according to the schema.");
        }
    }

    private static boolean validateData(JsonObject schema, JsonObject data) {
        Gson gson = new Gson();
        MyPropertyValidator validator = gson.fromJson(schema, MyPropertyValidator.class);
        return validator.isValid(data);
    }

    private static class MyPropertyValidator {
        private int id;
        private String device_id;
        private String version;
        private int platform;
        private int operating_system;
        private String created_at;
        private String updated_at;
        private boolean active;

        boolean isValid(JsonObject data) {
            try {
                id = data.get("id").getAsInt();
                device_id = data.get("device_id").getAsString();
                version = data.get("version").getAsString();
                platform = data.get("platform").getAsInt();
                operating_system = data.get("operating_system").getAsInt();
                created_at = data.get("created_at").getAsString();
                updated_at = data.get("updated_at").getAsString();
                active = data.get("active").getAsBoolean();
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }
}

