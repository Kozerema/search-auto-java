package ua.com.searchauto.models;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;
import ua.com.searchauto.models.enums.BrandOfAuto;
import ua.com.searchauto.models.enums.ClientRole;
import ua.com.searchauto.models.enums.Currency;
import ua.com.searchauto.views.Views;

import java.util.Arrays;
import java.util.List;


@NoArgsConstructor

@Getter
@Setter
@ToString
@Entity
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    //    private BrandOfAuto brand;
    private List<BrandOfAuto> brand = Arrays.asList(BrandOfAuto.BMW);
    @NotBlank
    @Size(max = 15, message = "too long")
    @JsonView(value = {Views.Client.class, Views.User.class, Views.Admin.class, Views.Manager.class})
    //  @Pattern(regexp = "") //регулярка, цен зура?
    private String model;


    @Max(value = 1100, message = "too much")
    @Min(value = 0, message = "can`t be lower than 0")


    @JsonView(value = {Views.User.class, Views.Admin.class})
    private int power;

    private String avatar; ////////масив

    private String description;
    @NotBlank
    private int year;
    private String city;
    private String region;
    private int price;
//    private Currency currency;
//private List<Currency> currency = Arrays.asList(Currency.USD);

    public Auto(String model, int power,  int year, String city, String region, int price) {
//        this.brand = brand;
        this.model = model;
        this.power = power;
//        this.avatar = avatar;
//        this.description = description;
        this.year = year;
        this.city = city;
        this.region = region;
        this.price = price;
//        this.currency = currency;
    }
}


