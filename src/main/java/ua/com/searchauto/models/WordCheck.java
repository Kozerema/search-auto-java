package ua.com.searchauto.models;

import ua.com.searchauto.services.AutoService;

import java.util.ArrayList;

public class WordCheck {
    AutoService autoService;

    public int counter(){
        int count=0;
        count++;
        return count;
    }

        public void check(Auto auto){
        ArrayList<String> words = new ArrayList<>();
        words.add(auto.getModel());
        words.add(auto.getDescription());
        words.add(auto.getCity());
        words.add(auto.getRegion());

        boolean isContains = words.contains("suka");
        if(isContains==false){
            autoService.save(auto);

    }else if(isContains==true){
            new RuntimeException();
        }
    }


}
