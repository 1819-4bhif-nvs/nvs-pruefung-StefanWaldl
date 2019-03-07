package endpoint;

import daos.PersonDao;
import model.Person;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import java.util.List;

@ApplicationPath("Person")
public class PersonEndpoint {

    @Inject
    PersonDao dao;

    @GET
    public List<Person> getAll(){
        return dao.getAll();
    }
}
