package ua.com.searchauto.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import ua.com.searchauto.models.enums.Brand;
import ua.com.searchauto.models.enums.Currency;

import java.time.LocalDateTime;
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

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<Brand> brand = Arrays.asList(Brand.KIA);

    /////make змінну або метод

    //    @Pattern.List(value = {@Pattern(regexp = "^[a@][s\\$][s\\$]$"),
//            @Pattern(regexp = "[a@][s\\$][s\\$]h[o0][l1][e3][s\\$]?"),
//            @Pattern(regexp = "b[a@][s\\$][t\\+][a@]rd "),
//            @Pattern(regexp = "b[e3][a@][s\\$][t\\+][i1][a@]?[l1]([i1][t\\+]y)?"),
//            @Pattern(regexp = "b[e3][a@][s\\$][t\\+][i1][l1][i1][t\\+]y"),
//            @Pattern(regexp = "b[e3][s\\$][t\\+][i1][a@][l1]([i1][t\\+]y)?"),
//            @Pattern(regexp = "b[i1][t\\+]ch[s\\$]?"),
//            @Pattern(regexp = "^(c|k|ck|q)[o0](c|k|ck|q)[s\\$]?$"),
//            @Pattern(regexp = "^cum[s\\$]?$"),
//            @Pattern(regexp = "d[i1]ck"),
//            @Pattern(regexp = "(ph|f)[a@]g[s\\$]?"),
//            @Pattern(regexp = "(ph|f)u(c|k|ck|q)"),
//            @Pattern(regexp = "h[o0]m?m[o0]"),
//            @Pattern(regexp = "g[a@]y"),
//            @Pattern(regexp = "j[a@](c|k|ck|q)\\-?[o0](ph|f)(ph|f)?"),
//            @Pattern(regexp = "p[o0]rn"),
//            @Pattern(regexp = "[s\\$][e3]x"),
//            @Pattern(regexp = "[s\\$]h[i1][t\\+][s\\$]?"),
//            @Pattern(regexp = "[o0]rg[a@][s\\$]m[s\\$]?")
//
//    })
    private String model;


    @Min(value = 0, message = "can`t be lower than 0")
    private int power;

    @Min(value = 1970, message = "wrong")
    @Max(value = 2023, message = "wrong")
    private int year;


    private String description;


    @Size(min = 2, message = "too short")
    @Size(max = 200, message = "too long")
    private String city;
    @NotBlank
    @Size(min = 2, message = "too short")
    @Size(max = 200, message = "too long")
    private String region;

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

    private String avatar;

//  private boolean status;

    private static int counterOfViews = 1;

    public Auto(String model, int power, int year, String description, String city, String region, float price) {
        this.model = model;
        this.power = power;
        this.year = year;
        this.description = description;
        this.city = city;
        this.region = region;
        this.price = price;

//
    }



    public int getCounterOfViews() {
        LocalDateTime myObj = LocalDateTime.now();
        return counterOfViews++;
    }

}