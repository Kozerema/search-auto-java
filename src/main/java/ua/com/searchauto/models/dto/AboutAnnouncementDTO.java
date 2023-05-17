package ua.com.searchauto.models.dto;

import lombok.Getter;
import lombok.Setter;
import ua.com.searchauto.models.AboutAnnouncement;

@Getter
@Setter
public class AboutAnnouncementDTO {
    private String massageToManager;
    private int numberOfViews;
    private boolean status;

    public AboutAnnouncementDTO(String massageToManager, int numberOfViews, boolean status) {
        this.massageToManager = massageToManager;
        this.numberOfViews = numberOfViews;
        this.status = status;
    }
}
