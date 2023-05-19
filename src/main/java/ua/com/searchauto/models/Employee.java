package ua.com.searchauto.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import ua.com.searchauto.models.enums.Brand;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 2, message = "too short")
    @Size(max = 200, message = "too long")
    private String name;

    @Size(min = 2, message = "too short")
    @Size(max = 200, message = "too long")
    private String surname;

    @Min(value = 0, message = "wrong")
    @Max(value = 150, message = "wrong")
    private int age;

    @Email
    private String email;

    public Employee(String name, String surname, int age, String email) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
    }
}
