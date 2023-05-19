package ua.com.searchauto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import ua.com.searchauto.models.Auto;

import java.util.List;

@Service
public interface AutoDAO extends JpaRepository<Auto,Integer>, JpaSpecificationExecutor<Auto> {



}