package workwithtext;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
        String[] punctuationMarks = {"®","\t","…","$","–", "+", "_", "@", "&", "*", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "©", "“", "\\", "%", "{", "}", "[", "]", ">", "<", "=", "#", ",", ".", "!", "?", "-", ":", "\"", "(", ")", "—", "/", ";", ls, "\n", "\r\n"};
        for (int i = 0; i < stringBuilder.length(); i++) {
            //change all words to lower case
            char c = stringBuilder.charAt(i);
            stringBuilder.setCharAt(i, Character.toLowerCase(c));
            //remove punctuation
            if (Arrays.asList(punctuationMarks).contains(Character.toString(stringBuilder.charAt(i)))) {
                stringBuilder.replace(i, i + 1, " ");
            }

            if ((stringBuilder.charAt(i) == ' ' || stringBuilder.charAt(i) == ' ') && i < stringBuilder.length() - 3) {
                //replace "'" on start of word
                if (stringBuilder.charAt(i + 1) == '\'') {
                    stringBuilder.replace(i + 1, i + 2, " ");
                }
                //replace "'" on end of word
                if (i > 0 && stringBuilder.charAt(i - 1) == '\'') {
                    stringBuilder.replace(i - 1, i, " ");
                }
                //stringBuilder.replace(i + 1, i + 2, Character.toString(stringBuilder.charAt(i + 1)).toUpperCase());
                //stringBuilder.replace(i, i + 1, "-");
                //stringBuilder.replace(i+1, i+2, "---");
            }
        }
        //stringBuilder.insert(0, "\"");//додавання кавичок на початок кавички для того щоб не розривалося слово апострофом

        String[] wholeStringArray = stringBuilder.toString().split(" ", 0);//нерозривний пробіл
        Set<String> words = new TreeSet();
        String[] stringArray2 = null;
        int i = 0;
        //набирання множини слів
        for (String el : wholeStringArray) {
            i = 0;
            stringArray2 = el.split(" ", 0);//звичайний пробіл
            words.addAll(Arrays.asList(stringArray2));//множини без кавичок
        }

        words.remove("");  //delete empty strings
        words.remove("\"");  //delete empty strings

        //add commas quotes
        Set<String> wordsWithCommas = new TreeSet();
        Set<String> wordsForTranscription = new TreeSet();
        for(String el: words){
            if(el.length()>1) {
                wordsWithCommas.add(el + ",");
                wordsForTranscription.add("\"" + el + "\"");
            }
        }


        //trim words
        for (String el : wordsWithCommas) {
            el.trim();
        }
        for (String el : wordsForTranscription) {
            el.trim();
        }

        //System.out.println(((TreeSet<String>) wordsForTranscription).first());

        //words to file write
        new WriteReadFiles().writeFile(wordsWithCommas, "words.txt");
        new WriteReadFiles().writeFile(wordsForTranscription, "wordsfortranscription.txt");
        //empty file for translation
        try {
            new BufferedWriter(new FileWriter("onlyTranslation.txt")).close();
            new BufferedWriter(new FileWriter("transcription.txt")).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;

    }


}
