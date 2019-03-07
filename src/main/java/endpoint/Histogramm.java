package endpoint;

import daos.PersonDao;
import model.Person;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.HashMap;
import java.util.List;

@Path("histogramm")
public class Histogramm {
    @Inject
    PersonDao dao;

    @GET
    public HashMap getHistogram(){
        List<Person> temp = dao.getAll();
        HashMap map = new HashMap<String, Long>();
        for (Person person:temp) {
            for(String letter : person.getName().split("")){
                if(!map.containsKey(letter))
                    map.put(letter, 0);
                map.put(letter, (Long) map.get(letter) + 1);
            }
        };
        return map;
    }

}
