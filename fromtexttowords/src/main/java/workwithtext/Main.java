package workwithtext;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;

public class Main {

    public static void main(String[] args) throws IOException {
        //обнулить файл
        new BufferedWriter(new FileWriter("readyTranslation.txt")).close();
        FromTextToWords fromTextToWord = null;
        ToCsv toCsv = null;

        //if(args.length>0 && args[0]=="input.txt") {
        if(args.length>0) {
            fromTextToWord = new FromTextToWords(args[0]);
            fromTextToWord.fromTextToWords();
            AddSounds.main(null);
        }
        else
            System.out.println("Any input.txt");
    }
}
