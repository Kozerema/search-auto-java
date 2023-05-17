package ua.com.searchauto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.searchauto.models.Auto;

import java.util.List;
import java.util.Map;

public interface AutoDAO extends JpaRepository<Auto,Integer>, JpaSpecificationExecutor<Auto> {


    @Query("select a from Auto a where a.name=:name ")
    List<Auto> getAutoByName(@Param("name") String name);

//    List<Auto> findByName(String name);

    List<Auto> findCarByPower(int power);

//    List<Car> findCarByProducer(String producer);

    @Query("select a from Auto a where a.producer=:producer")
    List<Auto> getCarByProducer(@Param("producer") String producer);

}