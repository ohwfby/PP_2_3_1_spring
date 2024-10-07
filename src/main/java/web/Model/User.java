package web.Model;

import javax.persistence.*;
import javax.validation.constraints.*;
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstName")
    @NotEmpty(message = "Name should not be empty")
    @NotBlank(message = "Name should not be blank")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String firstName;

    @NotEmpty(message = "Last name should not be empty")
    @NotBlank(message = "Name should not be blank")
    @Column(name = "lastName")
    @Size(min = 2, max = 30, message = "Last name should be between 2 and 30 characters")
    private String lastName;

    @Column(name = "age")
    @Min(value = 0, message = "Age should be greater than 0")
    @Max(value = 110, message = "Age should be less than 110")
    private Byte age;

    public User() {
    }

    public User(String firstName, String lastName, Byte age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

}
