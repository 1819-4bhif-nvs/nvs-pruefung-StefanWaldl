package daos;

import model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import java.util.List;

@Stateless
public class PersonDao {

    EntityManager em;

    public List<Person> getAll(){
        return em.createNamedQuery("Person.FindALl")
                .getResultList();
    }

    public void save(Person person){
        em.persist(person);
        em.flush();
    }
}
