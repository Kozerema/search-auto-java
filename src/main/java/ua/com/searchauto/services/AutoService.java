package ua.com.searchauto.services;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.com.searchauto.dao.AutoDAO;
import ua.com.searchauto.models.Auto;
import ua.com.searchauto.models.dto.AutoDTO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class AutoService {
    private AutoDAO autoDAO;





    public int counter(){
        int count=0;
        count++;
        return count;
    }


    public void save( Auto auto){
        if (auto==null){
            throw new RuntimeException();
        }
        ArrayList<String> words = new ArrayList<>();
        words.add(auto.getModel());
        words.add(auto.getDescription());
        words.add(auto.getCity());
        words.add(auto.getRegion());

        boolean isContains = words.contains("suka");
//        boolean isContains = words.contains("suka");
//        boolean isContains = words.contains("suka");
//        boolean isContains = words.contains("suka");
//        boolean isContains = words.contains("suka");
//        boolean isContains = words.contains("suka");
        if(isContains==false){
            System.out.println("suka");

                    autoDAO.save(auto);

    }else if(isContains==true){
            throw new RuntimeException();
        }
    }




    public List<Auto> getAutos() {

        return autoDAO.findAll();
    }

    public AutoDTO getAuto(int id) {

        AutoDTO autoDTO = null;
        if (id > 0) {
            autoDTO = new AutoDTO(autoDAO.findById(id).get());

        }
        return autoDTO;
    }

    public void saveWithAvatar(String model,
                               int power,
                               int year,
                               String description,
                               String city,
                               String region,
                               int price,
                               MultipartFile avatar) throws IOException {
        Auto auto = new Auto(model, power, year, description, city, region, price);
        String originalFilename = avatar.getOriginalFilename();
        auto.setAvatar("/photo/" + originalFilename);
        String path = "D:" + File.separator + "Document" + File.separator + "images" + File.separator + originalFilename;
        File file = new File(path);
        avatar.transferTo(file);
        save(auto);
    }

    public Auto updateAuto(int id, Auto auto) {
        Auto auto1 = autoDAO.findById(id).get();
        auto1.setModel(auto.getModel());
        auto1.setCity(auto.getCity());
        auto1.setBrand(auto.getBrand());
        auto1.setPower(auto.getPower());
        auto1.setYear(auto.getYear());
        auto1.setDescription(auto.getDescription());
        auto1.setRegion(auto.getRegion());
        auto1.setPrice(auto.getPrice());
        auto1.setAvatar(auto.getAvatar());
        autoDAO.save(auto1);
        return auto1;
    }

    public ResponseEntity<List<Auto>> deleteAuto(int id) {
        autoDAO.deleteById(id);
        return new ResponseEntity<>(autoDAO.findAll(), HttpStatus.OK);
    }

    ///////////////////////////////

    public ResponseEntity<List<Auto>> findAllWithSpecifications(Specification<Auto> criteria) {

        List<Auto> all = autoDAO.findAll(criteria);
        return new ResponseEntity<>(all, HttpStatus.OK);

    }
///////////////
//public static boolean isValidEmailAddress(String email) {
//    boolean result = true;
//    try {
//        InternetAddress emailAddr = new InternetAddress(email);
//        emailAddr.validate();
//    } catch (AddressException ex) {
//        result = false;
//    }
//    return result;
//}


}