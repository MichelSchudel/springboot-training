package nl.ordina.demo.springboot.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceptenService {

    @Autowired
    private ReceptenRepository receptenRepository;

    public List<Recept> getAllRecepten() {
        // Recept recept = new Recept("vlaflip", Arrays.asList("gele vla", "bruine vla"), "mengen en klaar!");
        // return Arrays.asList(recept);
        return receptenRepository.getAllRecepten();
    }

    public void addRecept(Recept recept) {
        receptenRepository.addRecept(recept);
    }
}
