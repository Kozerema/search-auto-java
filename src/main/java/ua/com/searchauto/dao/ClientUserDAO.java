package ua.com.searchauto.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.searchauto.models.ClientUser;

public interface ClientUserDAO  extends JpaRepository <ClientUser,Integer>{


    ClientUser findByEmail (String email);
}
