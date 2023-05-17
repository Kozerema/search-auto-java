package ua.com.searchauto.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.searchauto.models.Auto;
import ua.com.searchauto.models.enums.BrandOfAuto;
import ua.com.searchauto.models.enums.Currency;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutoDTO {
//    private BrandOfAuto brand;
    private String model;
    private int power;
    private String avatar;

    private String description;
    private int year;
    private String city;
    private String region;
    private int price;

//    private Currency currency;

    public AutoDTO(Auto auto) {
//        this.brand = auto.getBrand();
//        this.model = auto.getModel();
//        this.power = auto.getPower();
//        this.avatar = auto.getAvatar();
//        this.description = auto.getDescription();
//        this.year = auto.getYear();
        this.city = auto.getCity();
        this.region = auto.getRegion();
        this.price = auto.getPrice();
//        this.currency = auto.getCurrency();
    }


}
