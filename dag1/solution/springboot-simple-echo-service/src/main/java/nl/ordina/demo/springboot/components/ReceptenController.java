package nl.ordina.demo.springboot.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceptenController {

    @Autowired
    private ReceptenService receptenService;

    @RequestMapping(value = "recepten", method = RequestMethod.GET)
    public List<Recept> recepten() {
        return receptenService.getAllRecepten();
    }

    @RequestMapping(value = "recepten", method = RequestMethod.POST)
    public void addRecept(@RequestBody Recept recept) {
        receptenService.addRecept(recept);
    }


}
