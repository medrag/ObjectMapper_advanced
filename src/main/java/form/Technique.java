package form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Technique {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String VALUE_TO_UNPACK = "internalValue";
    private List<String> languages;
    private List<String> os;
    private List<String> sgbd;

    @JsonProperty("languages")
    private void unpackLanguage(List<Object> languages) {
        if (languages != null) {
            this.languages = languages.stream()
                    .map(object -> {
                        if (object instanceof Map<?,?>) {
                            Map<String, Object> map = MAPPER.convertValue(object, Map.class);
                            return (String) map.get(VALUE_TO_UNPACK);
                        } else {
                            return (String) object;
                        }
                    }).collect(Collectors.toList());
        } else {
            this.languages = Collections.emptyList();
        }
    }

    @JsonProperty("os")
    private void unpackOs(List<Object> os) {
        if (os != null) {
            this.os = os.stream()
                    .map(object -> {
                        if (object instanceof Map<?,?>) {
                            Map<String, Object> map = MAPPER.convertValue(object, Map.class);
                            return (String) map.get(VALUE_TO_UNPACK);
                        } else {
                            return (String) object;
                        }
                    }).collect(Collectors.toList());
        } else {
            this.os = Collections.emptyList();
        }
    }

    @JsonProperty("sgbd")
    private void unpackSgbd(List<Object> sgbd) {
        if (sgbd != null) {
            this.sgbd = sgbd.stream()
                    .map(object -> {
                        if (object instanceof Map<?,?>) {
                            Map<String, Object> map = MAPPER.convertValue(object, Map.class);
                            return (String) map.get(VALUE_TO_UNPACK);
                        } else {
                            return (String) object;
                        }
                    }).collect(Collectors.toList());
        } else {
            this.os = Collections.emptyList();
        }
    }
}
