package mega;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MegaGestion {
    private MetaData type;
    private MetaData owner;
    private MetaData status;
    private MetaData openDays;
}
