package ua.com.searchauto.models.dto;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Basic;
import lombok.Getter;
import lombok.Setter;
import ua.com.searchauto.models.Auto;
import ua.com.searchauto.views.Views;

import java.time.LocalDate;


@Getter
@Setter
public class AutoDTO {
    @JsonView(value = {Views.Premium.class, Views.Basic.class})
    private String model;
    @JsonView(value = {Views.Premium.class, Views.Basic.class})
    private int power;
    @JsonView(value = {Views.Premium.class, Views.Basic.class})
    private String avatar;

    private String brand;
    private int year;

    @JsonView(value = Views.Premium.class)

    private int counterOfViews = 0;
    @JsonView(value = Views.Premium.class)
    private LocalDate date;

    public AutoDTO(Auto auto) {
        this.model = auto.getModel();
        this.power = auto.getPower();
        this.brand = auto.getBrand().toString();
        this.avatar = auto.getAvatar();
        this.year=auto.getYear();
        this.counterOfViews = auto.getCounterOfViews();
        this.date = auto.date();
    }


}