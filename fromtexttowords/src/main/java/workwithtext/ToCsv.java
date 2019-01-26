package workwithtext;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class ToCsv {
    private String inputFilename1 = "words.txt";
    private String inputFilename2 = "onlyTranslation.txt";
    private String outputFileName = "wordswithtranslation.txt";


    public void toCsv() {
        String line1 = null;
        String line2 = null;
        String line = null;
        Set<String> words = new TreeSet();
        //from file to stringBuilder
        BufferedReader reader1 = new WriteReadFiles().readFile(inputFilename1);
        BufferedReader reader2 = new WriteReadFiles().readFile(inputFilename2);
        // StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                line = null;
                line1 = reader1.readLine();
                line2 = reader2.readLine();
                if (line1 != null && line2 != null)
                    line = line1 + ";" + line2;
                if (line == null)
                    break;
                words.add(line);
                continue;
            } catch (IOException e) {
                e.printStackTrace();
            }
//            try {
//                if (reader1.read() != -1 && reader2.read() != -1) {
//                    continue;
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            //break;
        }
        try {
            reader1.close();
            reader2.close();

        } catch (IOException e) {

        }
        new WriteReadFiles().writeFile(words, outputFileName);
    }

}
