package pl.coderslab.spring01hibernatekrkw07.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernatekrkw07.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDao {
    @PersistenceContext
    private EntityManager em;

    public void create(Person e){
        em.persist(e);
    }

    public Person readById(long id){
        return em.find(Person.class, id);
    }

    public void update(Person e){
        em.merge(e);
    }

    public void delete(Person e){
        em.remove(em.contains(e) ? e : em.merge(e));
    }

    public List<Person> readAll(){
        Query q = em.createQuery("SELECT e FROM Person e");
        return q.getResultList();
    }
}
