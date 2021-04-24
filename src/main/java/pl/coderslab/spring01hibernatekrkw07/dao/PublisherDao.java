package pl.coderslab.spring01hibernatekrkw07.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernatekrkw07.entity.Book;
import pl.coderslab.spring01hibernatekrkw07.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PublisherDao {
    @PersistenceContext
    private EntityManager em;

    public void create(Publisher e){
        em.persist(e);
    }

    public Publisher readById(long id){
        return em.find(Publisher.class, id);
    }

    public void update(Publisher e){
        em.merge(e);
    }

    public void delete(Publisher e){
        em.remove(em.contains(e) ? e : em.merge(e));
    }
}
