package ua.com.searchauto.models;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import ua.com.searchauto.models.enums.Brand;
import ua.com.searchauto.views.Views;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Auto {

    //  TODO @Pattern(regexp = "") //регулярка, цен зура? create validator
    //TODO витягнути помилки в валідації



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonView(value = Views.Client.class)
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<Brand> brand = Arrays.asList(Brand.KIA);

    @JsonView(value = Views.Client.class)
    private String model;


    @JsonView(value = Views.Client.class)
    @Min(value = 0, message = "can`t be lower than 0")
    private int power;

    @JsonView(value = Views.Client.class)
    @Min(value = 1970, message = "wrong")
    @Max(value = 2023, message = "wrong")
    private int year;


    private String description;


    @JsonView(value = Views.Client.class)
    @Size(min = 2, message = "too short")
    @Size(max = 200, message = "too long")
    private String city;

    @JsonView(value = Views.Client.class)
    @NotBlank
    @Size(min = 2, message = "too short")
    @Size(max = 200, message = "too long")
    private String region;

    @JsonView(value = Views.Client.class)
    @Positive
    private float price;

//    @ElementCollection(fetch = FetchType.EAGER)
//    @Enumerated(EnumType.STRING)
//    private List<Currency> currency = Arrays.asList(Currency.UAN);

//    private Currency currency;

//    private double usd=36.94;
//    private double eur=39.77;
//
//    public void calculator(){
//        switch (currency){
//            case UAN:
//                double mouthUSD1=price/usd;
//                double mouthEUR1=price/eur;
//             break;
//            case USD:
//                double mouthUAN1=price*usd;
//                double mouthEUR=price/eur;
//                break;
//            case EUR:
//                double mouthUSD=price/usd;
//                double mouthUAN=price*eur;
//                break;
//        }
//
//    }


    @JsonView(value = Views.Client.class)
    private String avatar;


//  private boolean status;
//    @JsonView(value = Views.Premium.class)
    private static int counterOfViews = 1;


    public Auto(String model, int power, int year, String description, String city, String region, float price ) {
        this.model = model;
        this.power = power;
        this.year = year;
        this.description = description;
        this.city = city;
        this.region = region;
        this.price = price;
    }


    public LocalDate date(){
        LocalDate date = LocalDate.now();
        return date;
    }

    public int getCounterOfViews() {
        return counterOfViews++;
    }

}