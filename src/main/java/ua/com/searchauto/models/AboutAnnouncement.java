package ua.com.searchauto.models;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import ua.com.searchauto.views.Views;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@Builder
//@AllArgsConstructor
public class AboutAnnouncement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String massageToManager;
    private int numberOfViews;
    private boolean status;

    public AboutAnnouncement(String massageToManager, int numberOfViews, boolean status) {
        this.massageToManager = massageToManager;
        this.numberOfViews = numberOfViews;
        this.status=status;
    }
}
