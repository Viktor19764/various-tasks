package workwithtext;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        FromTextToWords fromTextToWord = null;
        ToCsv toCsv = null;

        //if(args.length>0 && args[0]=="input.txt") {
        if(args.length>0) {
            fromTextToWord = new FromTextToWords(args[0]);
            fromTextToWord.fromTextToWords();
        }
        else
            System.out.println("Any input.txt");
    }
}
