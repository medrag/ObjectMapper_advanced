package mega;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MegaTechnique {
    private List<MetaData> languages;
    private List<MetaData> os;
    private List<MetaData> sgbd;
}
