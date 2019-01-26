package workwithtext;

import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class FromTextToWords {

    private String filename;

    public FromTextToWords() {
    }

    public FromTextToWords(String filename) {
        this.filename = filename;
    }

    public boolean fromTextToWords() {
        String line = null;
        BufferedReader reader = null;
        //from file to stringBuilder
        reader = new WriteReadFiles().readFile(filename);
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        while (true) {
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (line != null) {
                stringBuilder.append(line);
                stringBuilder.append(" ");
                continue;
            }
            break;
        }
        try {
            reader.close();

        } catch (IOException e) {

        }

        //from stringBuilder to words
        String[] punctuationMarks = {",", ".", "!", "?", "-", ":", "\"", "(", ")", "—", "/", ";", ls, "\n", "\r\n"};
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (Arrays.asList(punctuationMarks).contains(Character.toString(stringBuilder.charAt(i)))) {
                stringBuilder.replace(i, i + 1, " ");
            }
            if ((stringBuilder.charAt(i) == ' '||stringBuilder.charAt(i) == ' ') && i < stringBuilder.length() - 3) {
                stringBuilder.replace(i + 1, i + 2, Character.toString(stringBuilder.charAt(i + 1)).toUpperCase());
                //stringBuilder.replace(i, i + 1, "-");
                //stringBuilder.replace(i+1, i+2, "---");
            }
        }

        String[] wholeStringArray = stringBuilder.toString().split(" ", 0);//нерозривний пробіл
        Set<String> words = new TreeSet();
        for (String el : wholeStringArray) {
            words.addAll(Arrays.asList(el.split(" ", 0)));//звичайний пробіл
        }
        //trim words
        int i = 0;
        for (String el : words) {
            el.trim();
            i++;
        }
        words.remove("");  //delete empty strings
        System.out.println(((TreeSet<String>) words).first());
        //words to file write
        new WriteReadFiles().writeFile(words, "words.txt");
        return true;

    }


}
