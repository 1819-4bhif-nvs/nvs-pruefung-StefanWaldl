package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQuery(name = "Person.FindAll", query = "select x from Person x")
public class Person  implements Serializable {

    public enum Gender{
        male,
        female
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SURNAME_PK")
    Long id;
    Gender gender;
    String name;

    public Person(Gender gender, String name){
        this.gender = gender;
        this.name = name;
    }


}
