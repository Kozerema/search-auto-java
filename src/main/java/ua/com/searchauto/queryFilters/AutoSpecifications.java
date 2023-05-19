package ua.com.searchauto.queryFilters;


import org.springframework.data.jpa.domain.Specification;
import ua.com.searchauto.models.Auto;


public class AutoSpecifications {

    // кількість переглядів оголошення
    //	* кількість переглядів за день, тиждень, місяць
    //
    //
    //	* Середню ціну на авто по регіону продажу авто.
    //Наприклад якщо авто продається у Києві, то буде середня ціна авто по Києву.
    //Якщо у Львівській області, то середня ціна буде по Львівській області
    //	* середня ціна авто по цілій Україні



    public static Specification<Auto> byViews() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.gt(root.get("counterOfViews"), 0);
    }


}
