package ua.com.searchauto.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/autos")
public class AutoController {

    private AutoDAO autoDAO;
    private AutoService autoService;


    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody @Valid Auto auto) {
        autoService.save(auto);
    }


    @GetMapping("")
    @JsonView(value = {Views.Admin.class})
    public ResponseEntity<List<Auto>> getAutos() {

        return autoService.findAllWithSpecifications(AutoSpecifications.byName("kokos"));
    }

    @GetMapping("/{id}")
    public AutoDTO getAuto(@PathVariable("id") int id) {
        return autoService.getAuto(id);
    }


    //TODO autoService

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Auto>> deleteUsers(@PathVariable("id") int id) {
        autoDAO.deleteById(id);
        return new ResponseEntity<>(autoDAO.findAll(), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public Auto updateUser(@PathVariable("id") int id, @RequestBody Auto auto) {
        Auto auto1 = autoDAO.findById(id).get();
        auto1.setName(auto.getName());
        autoDAO.save(auto1);
        return auto1;
    }


    @GetMapping("/name/{nameValue}")
    @JsonView(value = Views.User.class)

    public ResponseEntity<List<Auto>> autosByName(@PathVariable("nameValue") String nameValue) {

        return new ResponseEntity<List<Auto>>(autoDAO.getAutoByName(nameValue), HttpStatus.OK);

//        return autoDAO.findByName(nameValue);

    }


    @GetMapping("/power/{power}")
    public ResponseEntity<List<Auto>> findCarByPower(@PathVariable int power) {

        return new ResponseEntity<>(autoDAO.findCarByPower(power), HttpStatus.OK);
    }

    @GetMapping("producer/{producer}")
    public ResponseEntity<List<Auto>> findCarByProducer(@PathVariable String producer) {
//        return carDAO.findCarByProducer(producer);

        return new ResponseEntity<>(autoDAO.getCarByProducer(producer), HttpStatus.OK);

    }


    @PostMapping("/saveWithAvatar")
    public void saveWithAvatar(@RequestParam String name,
                               @RequestParam int power,
                               @RequestParam MultipartFile avatar
    ) throws IOException {

        Auto auto = new Auto(name, power);
        String originalFilename = avatar.getOriginalFilename();
        auto.setAvatar("/photo/" + originalFilename);
        String path = "D:" + File.separator + "Document" + File.separator + "images" + File.separator + originalFilename;
        File file = new File(path);
        avatar.transferTo(file);
        autoService.save(auto);
    }





}

