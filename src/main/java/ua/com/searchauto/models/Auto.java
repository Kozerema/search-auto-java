package ua.com.searchauto.models;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;
import ua.com.searchauto.views.Views;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(value = Views.Admin.class)
    private int id;


    @NotBlank
    @Size(min = 2, message = "too short")
    @JsonView(value = {Views.Client.class, Views.User.class, Views.Admin.class})
    //  @Pattern(regexp = "") //регулярка, цен зура?
    private String name;

    @JsonView(value = {Views.Client.class, Views.User.class})
    private String producer;


    @Max(value = 1100, message = "too much")
    @Min(value = 0, message = "can`t be lower than 0")


    @JsonView(value = {Views.User.class, Views.Admin.class})
    private int power;

    private String avatar;

    public Auto(String name, String producer, int power) {
        this.name = name;
        this.producer = producer;
        this.power = power;
    }

}
