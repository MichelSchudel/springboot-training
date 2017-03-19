package nl.ordina.demo.springboot;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.Arrays;
import java.util.List;

import nl.ordina.demo.springboot.components.Recept;
import nl.ordina.demo.springboot.components.ReceptenController;
import nl.ordina.demo.springboot.components.ReceptenService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ReceptenController.class)
public class MCVTesterIT {

    @Autowired
    private ReceptenController receptenController;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ReceptenService receptenService;

    @Before
    public void setup() {
        Recept recept = new Recept();
        recept.setId(1L);
        recept.setIngredienten(Arrays.asList("vla"));
        recept.setTitel("vlaflip");
        recept.setOmschrijving("omschrijving");
        when(receptenService.getAllRecepten()).thenReturn(Arrays.asList(recept));

    }

    @Test
    public void test_controller_method() {
        List<Recept> receptList = receptenController.recepten();
    }

    @Test
    public void test_boundary() throws Exception {
        mvc.perform(get("/recepten").accept(MediaType.APPLICATION_JSON)).andExpect(content().string(" ok"));
        List<Recept> receptList = receptenController.recepten();
    }

}
