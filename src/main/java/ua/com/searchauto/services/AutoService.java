package ua.com.searchauto.services;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.com.searchauto.dao.AutoDAO;
import ua.com.searchauto.models.Auto;
import ua.com.searchauto.models.dto.AutoDTO;

import java.util.List;


@Service
@AllArgsConstructor
public class AutoService {
    private AutoDAO autoDAO;

    public void save(Auto auto){
        if (auto==null){
            throw new RuntimeException();
        }
        autoDAO.save(auto);
    }

    public ResponseEntity<List<Auto>> findAllWithSpecifications(Specification<Auto> criteria){

        List<Auto> all = autoDAO.findAll(criteria);
        return new ResponseEntity<>(all, HttpStatus.OK);

    }

    public AutoDTO getAuto(int id){

        AutoDTO autoDTO=null;
        if (id>0){
            autoDTO= new AutoDTO(autoDAO.findById(id).get());
        }
        return autoDTO;
    }


}