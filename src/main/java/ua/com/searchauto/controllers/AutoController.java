package ua.com.searchauto.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.searchauto.dao.AutoDAO;
import ua.com.searchauto.models.Auto;
import ua.com.searchauto.models.dto.AutoDTO;
import ua.com.searchauto.queryFilters.AutoSpecifications;
import ua.com.searchauto.services.AutoService;
import ua.com.searchauto.views.Views;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@AllArgsConstructor
@RequestMapping("/autos")

public class AutoController {

    private AutoDAO autoDAO;
    private AutoService autoService;


    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void saveAuto(@RequestBody Auto auto ) {
        autoService.save(auto);
    }


    @GetMapping("")

    public ResponseEntity<List<Auto>> getAutos() {

        return new ResponseEntity<List<Auto>>(autoService.getAutos(), HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public AutoDTO getAuto(@PathVariable("id") int id) {
        return autoService.getAuto(id);
    }


    @PatchMapping("/{id}")
    public Auto updateAuto(@PathVariable("id") int id, @RequestBody Auto auto) {
        return autoService.updateAuto(id,auto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Auto>> deleteAuto(@PathVariable("id") int id) {
        return autoService.deleteAuto(id);
    }


//    @GetMapping("")
//
//    public ResponseEntity<List<Auto>> getAutos() {
//
//        return autoService.findAllWithSpecifications(AutoSpecifications.byName("kokos"));
//    }
//    @GetMapping("/name/{nameValue}")
//    @JsonView(value = Views.User.class)
//
//    public ResponseEntity<List<Auto>> autosByName(@PathVariable("nameValue") String nameValue) {
//
//        return new ResponseEntity<List<Auto>>(autoDAO.getAutoByName(nameValue), HttpStatus.OK);
//
////        return autoDAO.findByName(nameValue);
//
//    }


//    @GetMapping("/power/{power}")
//    public ResponseEntity<List<Auto>> findCarByPower(@PathVariable int power) {
//
//        return new ResponseEntity<>(autoDAO.findCarByPower(power), HttpStatus.OK);
//    }

//    @GetMapping("producer/{producer}")
//    public ResponseEntity<List<Auto>> findCarByProducer(@PathVariable String producer) {
////        return carDAO.findCarByProducer(producer);
//
//        return new ResponseEntity<>(autoDAO.getCarByProducer(producer), HttpStatus.OK);
//
//    }


    @PostMapping("/saveWithAvatar")
    public void saveWithAvatar(@RequestParam String model,
                               @RequestParam int power,
                               @RequestParam int year,
                               @RequestParam String description,
                               @RequestParam String city,
                               @RequestParam String region,
                               @RequestParam int price,
                               @RequestParam MultipartFile avatar
    ) throws IOException {autoService.saveWithAvatar(model,
                power,
                year,
                description,
                city,
                region,
                price,
                avatar);
    }


}

