package ua.com.searchauto.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.com.searchauto.models.LoginedPerson;
import ua.com.searchauto.models.dto.LoginedPersonDTO;
import ua.com.searchauto.services.LoginedPersonService;

import java.util.List;

@RestController
@AllArgsConstructor
public class LoginedPersonController {

    private LoginedPersonService loginedPersonService;


    @PostMapping("/clients/save")
    public void saveClient(@RequestBody LoginedPersonDTO loginedPersonDTO) {

        loginedPersonService.save(loginedPersonDTO);

    }

    @PostMapping("/clients/login")
    public ResponseEntity<String> login(@RequestBody LoginedPersonDTO loginedPersonDTO) {

        return loginedPersonService.login(loginedPersonDTO);

    }


    @GetMapping("/managers/users/all")
    public List<String> getAllUsersWithoutSensetiveInfo() {

        return loginedPersonService.getAllUsersWithoutSensetiveInfo();

    }


    @GetMapping("/managers/all")
    public List<LoginedPerson> getAllUsers() {
        return loginedPersonService.getAllUsers();

    }
}

