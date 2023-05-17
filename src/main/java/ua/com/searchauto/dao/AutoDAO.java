package ua.com.searchauto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.searchauto.models.Auto;

import java.util.List;
import java.util.Map;

public interface AutoDAO extends JpaRepository<Auto,Integer>, JpaSpecificationExecutor<Auto> {


//    @Query("select a from Auto a where a.brand=:brand ")
//    List<Auto> getAutoByName(@Param("brand") String brand);
//
////    List<Auto> findByName(String name);
//
//    List<Auto> findCarByPower(int power);
//
////    List<Car> findCarByProducer(String producer);
//
//    @Query("select a from Auto a where a.power=:power")
//    List<Auto> getCarByProducer(@Param("power") int power);

}
