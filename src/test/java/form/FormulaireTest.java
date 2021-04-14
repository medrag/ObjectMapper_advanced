package form;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class FormulaireTest {

    private ObjectMapper mapper;

    @Before
    public void setUp() {
        this.mapper = new ObjectMapper();
    }

    @Test
    public void whenUsingAnnotations_on_flatObject_thenOK() throws IOException {
        Formulaire form = this.mapper
                .readerFor(Formulaire.class)
                .readValue(new File("src/main/resources/formulaire_2.json"));

        // Gestion
        assertEquals("Progiciel", form.getGestion().getType());
        assertEquals("IBM", form.getGestion().getOwner());
        assertEquals("En projet", form.getGestion().getStatus());
        assertEquals("Samedi + Week end", form.getGestion().getOpenDays());

        // Technique
        //assertEquals(form.getTechnique().getLanguages().size(), 3);
        assertEquals(form.getTechnique().getOs().size(), 3);
        assertEquals(form.getTechnique().getSgbd().size(), 2);
    }

    @Test
    public void whenUsingAnnotations_on_nestedObject_thenOK() throws IOException {
        Formulaire form = this.mapper
                .readerFor(Formulaire.class)
                .readValue(new File("src/main/resources/formulaire_1.json"));

        // Gestion
        assertEquals("P", form.getGestion().getType());
        assertEquals("IBM", form.getGestion().getOwner());
        assertEquals("Proj", form.getGestion().getStatus());
        assertEquals("Samedi + Week-end", form.getGestion().getOpenDays());

        // Technique
        assertEquals(form.getTechnique().getLanguages().size(), 3);
        assertEquals(form.getTechnique().getOs().size(), 3);
        assertEquals(form.getTechnique().getSgbd().size(), 2);
    }
}
