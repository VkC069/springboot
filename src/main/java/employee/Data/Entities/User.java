package employee.Data.Entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter@Setter

@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name="name")
    private String name;
    @Column(name="age")
    private Integer age;
    @Column(name="gender")
    private String gender;
    @Column(name="salary")
    private Integer salary;
    public User(){

    }


}
