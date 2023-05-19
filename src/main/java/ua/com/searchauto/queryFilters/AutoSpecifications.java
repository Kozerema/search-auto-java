package ua.com.searchauto.queryFilters;


import org.springframework.data.jpa.domain.Specification;
import ua.com.searchauto.models.Auto;


public class AutoSpecifications {

    public static Specification<Auto> byViews() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.gt(root.get("counterOfViews"), 0);
    }


}
