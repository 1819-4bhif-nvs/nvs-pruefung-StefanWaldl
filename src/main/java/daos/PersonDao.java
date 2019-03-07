package daos;

import model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PersonDao {
    @PersistenceContext
    EntityManager em;

    public List<Person> getAll(){
        return em.createNamedQuery("Person.FindAll")
                .getResultList();
    }

    public void save(Person person){
        em.persist(person);
    }
    public void flush(){
        em.flush();
    }
}
