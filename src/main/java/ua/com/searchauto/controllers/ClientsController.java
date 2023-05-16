package ua.com.searchauto.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.com.searchauto.dao.ClientUserDAO;
import ua.com.searchauto.models.ClientUser;
import ua.com.searchauto.models.dto.ClientUserDTO;
import ua.com.searchauto.services.ClientUserService;

import java.security.AuthProvider;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class ClientsController {

    ///TODO services для client

    private ClientUserDAO clientUserDAO;
    private PasswordEncoder passwordEncoder;
    private ClientUserService clientUserService;


    @PostMapping("clients/save")
    public void saveClient(@RequestBody ClientUserDTO clientUserDTO) {

        ClientUser clientUser = new ClientUser();
        clientUser.setEmail(clientUserDTO.getUsername());
        clientUser.setPassword(passwordEncoder.encode(clientUserDTO.getPassword()));


        clientUserDAO.save(clientUser);

    }

    @PostMapping("clients/login")
    public ResponseEntity<String >login(@RequestBody ClientUserDTO clientUserDTO){

        return clientUserService.login(clientUserDTO);

    }

    //TODO Views зробити
    //OPEN
    @GetMapping("/clients/all")
    public List<String> getAllClientsWithoutSensetiveInfo(){
//        return clientUserDAO.findAll();
        return clientUserDAO.findAll().stream().map(clientUser -> clientUser.getEmail()).collect(Collectors.toList());

    }

    //ADMIN
    @GetMapping("/admin/all")
    public List<ClientUser> getAllClients(){
        return clientUserDAO.findAll();

    }
}
