package ua.com.searchauto.models.dto;

import lombok.Getter;
import lombok.Setter;
import ua.com.searchauto.models.Auto;

@Getter
@Setter
public class AutoDTO {
    private String name;
    private int power;
    private String avatar;

    public AutoDTO(Auto auto){
        this.name=auto.getName();
        this.power=auto.getPower();
        this.avatar=auto.getAvatar();
    }
}