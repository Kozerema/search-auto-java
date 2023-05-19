package ua.com.searchauto.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.searchauto.models.Auto;
import ua.com.searchauto.models.dto.AutoDTO;
import ua.com.searchauto.services.AutoService;
import ua.com.searchauto.views.Views;



import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/autos")

public class AutoController {

    private AutoService autoService;


    @PostMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public void saveAuto(@RequestBody Auto auto) {

//        autoService.check(auto);
        autoService.save(auto);
    }


    @GetMapping("/user")
    public ResponseEntity<List<Auto>> getAllAutos() {
        return new ResponseEntity<List<Auto>>(autoService.getAutos(), HttpStatus.OK);
    }

    @JsonView(value = Views.Client.class)
    @GetMapping("/client")
    public ResponseEntity<List<Auto>> getAllAutosClient() {
        return new ResponseEntity<List<Auto>>(autoService.getAutos(), HttpStatus.OK);
    }


    @JsonView(value = Views.Basic.class)
    @GetMapping("/users/basic/{id}")
    public AutoDTO getOneAutoBasic(@PathVariable("id") int id) {
        return autoService.getAuto(id);
    }

    @JsonView(value = Views.Premium.class)
    @GetMapping("/users/premium/{id}")
    public AutoDTO getOneAutoPremium(@PathVariable("id") int id) {
        return autoService.getAuto(id);
    }

    @JsonView(value = Views.Client.class)
    @GetMapping("/clients/{id}")
    public AutoDTO getOneAutoClient(@PathVariable("id") int id) {
        return autoService.getAuto(id);
    }



    @PatchMapping("/{id}")
    public Auto updateAuto(@PathVariable("id") int id, @RequestBody Auto auto) {
        return autoService.updateAuto(id, auto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Auto>> deleteAuto(@PathVariable("id") int id) {
        return autoService.deleteAuto(id);
    }


    @JsonView(value = Views.Premium.class)
    @GetMapping("/users/statistics")

    public ResponseEntity<List<Auto>> getAutosByViews() {

//
//        List<Auto> getAll=autoDAO.findAll(AutoSpecifications.byViews());

//        return (ResponseEntity<List<Auto>>) getAll;
//        return autoService.findAllWithSpecifications();
        return null;
    }





    @PostMapping("/users/saveWithAvatar")
    public void saveWithAvatar(@RequestParam String model,
                               @RequestParam int power,
                               @RequestParam int year,
                               @RequestParam String description,
                               @RequestParam String city,
                               @RequestParam String region,
                               @RequestParam int price,
                               @RequestParam MultipartFile avatar
    ) throws IOException {
        autoService.saveWithAvatar(model,
                power,
                year,
                description,
                city,
                region,
                price,
                avatar);
    }


}

