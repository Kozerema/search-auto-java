package ua.com.searchauto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.searchauto.models.LoginedPerson;

public interface LoginedPersonDAO extends JpaRepository<LoginedPerson,Integer> {


    LoginedPerson findByEmail (String email);
}