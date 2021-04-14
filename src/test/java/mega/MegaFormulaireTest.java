package mega;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class MegaFormulaireTest {

    private ObjectMapper mapper;

    @Before
    public void setUp() {
        this.mapper = new ObjectMapper();
    }

    @Test
    public void whenNotUsingAnnotations_thenOK() throws IOException {
        MegaFormulaire megaFormulaire = this.mapper
                .readerFor(MegaFormulaire.class)
                .readValue(new File("src/main/resources/formulaire_1.json"));

        // Gestion
        assertEquals(megaFormulaire.getGestion().getType(), MetaData.builder().name("Progiciel").internalValue("P").build());
        assertEquals(megaFormulaire.getGestion().getOwner(), MetaData.builder().name("IBM").internalValue("IBM").build());
        assertEquals(megaFormulaire.getGestion().getStatus(), MetaData.builder().name("En projet").internalValue("Proj").build());
        assertEquals(megaFormulaire.getGestion().getOpenDays(), MetaData.builder().name("Samedi + Week end").internalValue("Samedi + Week-end").build());

        // Technique
        assertEquals(megaFormulaire.getTechnique().getLanguages().size(), 3);
        assertEquals(megaFormulaire.getTechnique().getOs().size(), 3);
        assertEquals(megaFormulaire.getTechnique().getSgbd().size(), 2);
    }
}
