package mega;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MegaFormulaire {
    private MegaGestion gestion;
    private MegaTechnique technique;
}
