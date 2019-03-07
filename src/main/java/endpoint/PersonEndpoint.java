package endpoint;

import daos.PersonDao;
import model.Person;

import javax.inject.Inject;
import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("surname")
public class PersonEndpoint {

    @Inject
    PersonDao dao;

    @GET
    public String getCountAll(){
        List temp = dao.getAll();
        int countMale = 0;
        int countFemale = 0;
        for(Person person : dao.getAll()) {
            if(person.getGender() == Person.Gender.male)
                countMale++;
            else
                countFemale++;
        }
        int countAll = countMale + countFemale;
        return Json.createObjectBuilder().add("total_all", countAll)
                .add("total_male", countMale)
                .add("total_female", countFemale).build().toString();
    }
}
