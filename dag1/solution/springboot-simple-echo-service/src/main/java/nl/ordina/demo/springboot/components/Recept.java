package nl.ordina.demo.springboot.components;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recept {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titel;

    @ElementCollection
    private List<String> ingredienten;

    private String omschrijving;

    public Recept() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setIngredienten(List<String> ingredienten) {
        this.ingredienten = ingredienten;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public Recept(String titel, List<String> ingredienten, String omschrijving) {
        this.titel = titel;
        this.ingredienten = ingredienten;
        this.omschrijving = omschrijving;
    }

    public String getTitel() {
        return titel;
    }

    public List<String> getIngredienten() {
        return ingredienten;
    }

    public String getOmschrijving() {
        return omschrijving;
    }
}
