package business;

import daos.PersonDao;
import model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

@ApplicationScoped
public class InitBean {

    @Inject
    PersonDao dao;

    private void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        /*
        new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream("maennlich.csv"), Charset.defaultCharset()))
                .lines()
                .skip(1)
                .map(a -> new Person(Person.Gender.male,a))
                .forEach(System.out::println);
                //.forEach(dao::save);

        new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream("weiblich.csv"), Charset.defaultCharset()))
                .lines()
                .skip(1)
                .map(a -> new Person(Person.Gender.female,a))
                .forEach(System.out::println);
        //.forEach(dao::save);

        */
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/maennlich.csv")));
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                dao.save(new Person(Person.Gender.male, line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/weiblich.csv")));
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                dao.save(new Person(Person.Gender.female, line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
