package nl.ordina.demo.springboot.components;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ReceptenRepository {

    @PersistenceContext

    private EntityManager entityManager;

    @Cacheable("recepten")
    public List<Recept> getAllRecepten() {
        Query query = entityManager.createQuery("SELECT r FROM Recept r");
        return (List<Recept>) query.getResultList();
    }

    @Transactional
    @CacheEvict(value = "recepten", allEntries = true)
    public void addRecept(Recept recept) {
        entityManager.persist(recept);
    }
}
