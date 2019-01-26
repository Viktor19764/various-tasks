package workwithtext;

import java.io.BufferedReader;
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
        String[] punctuationMarks = {",", ".", "!", "?", "-", ":", "\"", "(", ")", "—", "/", ";", ls, "\n", "\r\n"};
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (Arrays.asList(punctuationMarks).contains(Character.toString(stringBuilder.charAt(i)))) {
                stringBuilder.replace(i, i + 1, " ");
            }
            if ((stringBuilder.charAt(i) == ' ' || stringBuilder.charAt(i) == ' ') && i < stringBuilder.length() - 3) {
                stringBuilder.replace(i + 1, i + 2, Character.toString(stringBuilder.charAt(i + 1)).toUpperCase());
                //stringBuilder.replace(i, i + 1, "-");
                //stringBuilder.replace(i+1, i+2, "---");
            }
        }
        //stringBuilder.insert(0, "\"");//додавання кавичок на початок кавички для того щоб не розривалося слово апострофом

        String[] wholeStringArray = stringBuilder.toString().split(" ", 0);//нерозривний пробіл
        Set<String> words = new TreeSet();
        Set<String> wordsForTranscription = new TreeSet();
        String[] stringArray2 = null;
        int i = 0;
        for (String el : wholeStringArray) {
            i = 0;
            stringArray2 = el.split(" ", 0);//звичайний пробіл
            words.addAll(Arrays.asList(stringArray2));//множини без кавичок
            for (String el2 : stringArray2) {
                stringArray2[i] = "\"" + stringArray2[i] + "\"";//додавання кавичок до кожного слова
                i++;
            }
            wordsForTranscription.addAll(Arrays.asList(stringArray2));
        }

        words.remove("");  //delete empty strings
        words.remove("\"");  //delete empty strings
        wordsForTranscription.remove("\"");  //delete empty strings
        wordsForTranscription.remove("\"\"");  //delete empty strings
        wordsForTranscription.remove("\"\"\"");  //delete empty strings
        //trim words
        for (String el : words) {
            el.trim();
        }
        for (String el : wordsForTranscription) {
            el.trim();
        }

        //System.out.println(((TreeSet<String>) wordsForTranscription).first());

        //words to file write
        new WriteReadFiles().writeFile(words, "words.txt");
        new WriteReadFiles().writeFile(wordsForTranscription, "wordsfortranscription.txt");
        return true;

    }


}
