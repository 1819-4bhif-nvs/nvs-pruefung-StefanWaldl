package endpoint;

import daos.PersonDao;
import model.Person;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("surname")
public class PersonEndpoint {

    @Inject
    PersonDao dao;

    @GET
    public List<Person> getAll(){
        return dao.getAll();
    }
}
