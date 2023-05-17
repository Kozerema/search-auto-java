package ua.com.searchauto.models.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import ua.com.searchauto.models.Auto;

@Getter
@Setter
public class AutoDTO {
    private String model;
    private int power;
    private String avatar;

    private  int counterOfViews = 0;
    public AutoDTO( Auto auto) {
        this.model = auto.getModel();
        this.power = auto.getPower();
        this.avatar = auto.getAvatar();
        this.counterOfViews=auto.getCounterOfViews();
    }
}