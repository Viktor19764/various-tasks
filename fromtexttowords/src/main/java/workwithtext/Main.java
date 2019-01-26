package workwithtext;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        FromTextToWords fromTextToWord = new FromTextToWords(args[0]);
        fromTextToWord.fromTextToWords();

    }

}
