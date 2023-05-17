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

    // кількість переглядів оголошення
    //	* кількість переглядів за день, тиждень, місяць
    //
    //
    //	* Середню ціну на авто по регіону продажу авто.
    //Наприклад якщо авто продається у Києві, то буде середня ціна авто по Києву.
    //Якщо у Львівській області, то середня ціна буде по Львівській області
    //	* середня ціна авто по цілій Україні

//    @Query("select a from Auto a where a.brand=:brand")
//    List<Auto> getAutoByName(@Param("brand") String brand);
//
//    List<Auto> findByName(String brand);
//
//    List<Auto> findCarByPower(int power);
//
////    List<Car> findCarByProducer(String producer);
//
////    @Query("select a from Auto a where a.producer=:producer")
////    List<Auto> getCarByProducer(@Param("producer") String producer);

}