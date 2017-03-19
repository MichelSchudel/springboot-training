package nl.ordina.demo.springboot;

import nl.ordina.demo.springboot.components.Recept;
import nl.ordina.demo.springboot.components.ReceptenController;
import nl.ordina.demo.springboot.components.ReceptenRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EchoServiceIT {

    @Autowired
    private ReceptenController receptenController;

    @MockBean
    private ReceptenRepository receptenRepository;

    @Test
    public void test() {
        Recept recept = new Recept();
        receptenController.addRecept(recept);
    }
}
