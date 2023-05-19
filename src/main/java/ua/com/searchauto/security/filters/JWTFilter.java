package ua.com.searchauto.security.filters;

import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ua.com.searchauto.dao.LoginedPersonDAO;
import ua.com.searchauto.models.LoginedPerson;


import java.io.IOException;
import java.nio.charset.StandardCharsets;


@Component
@AllArgsConstructor
public class JWTFilter extends OncePerRequestFilter {

    private LoginedPersonDAO loginedPersonDAO;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authorization = request.getHeader("Authorization");
        if(authorization!=null && authorization.startsWith("Bearer ")){
            String token = authorization.replace("Bearer ", "");
            System.out.println("TOKEN:" +token);

            String decodedData = Jwts.parser()
                    .setSigningKey("okten".getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();

            System.out.println("DecodedData: "+decodedData); //kokos

            LoginedPerson clientUser = loginedPersonDAO.findByEmail(decodedData);

            System.out.println("Client: " +clientUser);

            if(clientUser!=null){

                SecurityContextHolder
                        .getContext()
                        .setAuthentication(
                                new UsernamePasswordAuthenticationToken(
                                        clientUser.getEmail(),
                                        clientUser.getPassword(),
                                        clientUser.getAuthorities()
                                )
                        );
            }
        }

        filterChain.doFilter(request,response);
    }
}
