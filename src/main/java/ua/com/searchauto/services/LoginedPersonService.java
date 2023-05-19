package ua.com.searchauto.services;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.searchauto.dao.LoginedPersonDAO;
import ua.com.searchauto.models.Auto;
import ua.com.searchauto.models.LoginedPerson;
import ua.com.searchauto.models.dto.LoginedPersonDTO;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Service

    public class LoginedPersonService  implements UserDetailsService {

        private LoginedPersonDAO loginedPersonDAO;
        private AuthenticationManager authenticationManager;
        private LoginedPersonDTO loginedPersonDTO;
    private PasswordEncoder passwordEncoder;

        @Autowired
        public LoginedPersonService (LoginedPersonDAO loginedPersonDAO, @Lazy AuthenticationManager authenticationManager) {
            this.loginedPersonDAO = loginedPersonDAO;
            this.authenticationManager = authenticationManager;
        }


        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            return loginedPersonDAO.findByEmail(username);
        }

        public ResponseEntity<String> login(LoginedPersonDTO loginedPersonDTO) {
            System.out.println(loginedPersonDTO);
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                    loginedPersonDTO.getUsername(), loginedPersonDTO.getPassword()
            );
            System.out.println(usernamePasswordAuthenticationToken);

            Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            if(authenticate!=null){
                String jwtToken = Jwts.builder()
                        .setSubject(authenticate.getName()) ///username-kokos
                        .signWith(SignatureAlgorithm.HS512, "okten".getBytes(StandardCharsets.UTF_8))
                        .compact();
                System.out.println(jwtToken);


                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.add("Authorization","Bearer "+jwtToken);
                return new ResponseEntity<>("you are logged in",httpHeaders, HttpStatus.OK);

            }
            return new ResponseEntity<>("bad credentials", HttpStatus.FORBIDDEN);
        }
//bad request не приходить
public void save( LoginedPersonDTO loginedPersonDTO) {

    LoginedPerson loginedPerson= new LoginedPerson();
    loginedPerson.setEmail(loginedPersonDTO.getUsername());
    loginedPerson.setPassword(passwordEncoder.encode(loginedPersonDTO.getPassword()));


    loginedPersonDAO.save(loginedPerson);
}
    public List<String> getAllUsersWithoutSensetiveInfo() {

        return loginedPersonDAO.findAll().stream().map(clientUser -> clientUser.getEmail()).collect(Collectors.toList());

    }

    public List<LoginedPerson> getAllUsers() {
        return loginedPersonDAO.findAll();

    }

    }

