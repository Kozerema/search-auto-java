package ua.com.searchauto.models;

public class WordCheck {
    static boolean checkWord(String input, String words) {
        if(words.contains(input)) {
            return true;
        }
        else {
            return false;
        }

    }

    public static void main(String[] args) {

        String words = "admin,administrator,babo,sir,melon";

//        System.out.print(WordCheck.checkWord("babo",words));


    }

}
