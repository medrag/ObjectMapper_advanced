package form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gestion {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String VALUE_TO_UNPACK = "internalValue";
    private String type;
    private String owner;
    private String status;
    private String openDays;

    @JsonProperty("type")
    private void unpackType(Object type) {
        if (type instanceof Map<?, ?>) {
            Map<String, Object> typeMap = MAPPER.convertValue(type, Map.class);
            this.type = (String) typeMap.get(VALUE_TO_UNPACK);
        } else {
            this.type = (String) type;
        }
    }

    @JsonProperty("owner")
    private void unpackOwner(Object owner) {
        if (owner instanceof Map<?, ?>) {
            Map<String, Object> ownerMap = MAPPER.convertValue(owner, Map.class);
            this.owner = (String) ownerMap.get(VALUE_TO_UNPACK);
        } else {
            this.owner = (String) owner;
        }
    }

    @JsonProperty("status")
    private void unpackStatus(Object status) {
        if (status instanceof Map<?, ?>) {
            Map<String, Object> statusMap = MAPPER.convertValue(status, Map.class);
            this.status = (String) statusMap.get(VALUE_TO_UNPACK);
        } else {
            this.status = (String) status;
        }
    }

    @JsonProperty("openDays")
    private void unpackOpenDays(Object openDays) {
        if (openDays instanceof Map<?, ?>) {
            Map<String, Object> openDaysMap = MAPPER.convertValue(openDays, Map.class);
            this.openDays = (String) openDaysMap.get(VALUE_TO_UNPACK);
        } else {
            this.openDays = (String) openDays;
        }
    }
}
