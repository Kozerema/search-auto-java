package ua.com.searchauto.queryFilters;


import org.springframework.data.jpa.domain.Specification;
import ua.com.searchauto.models.Auto;


public class AutoSpecifications {

    public static Specification<Auto> byName(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), name);
    }



}
