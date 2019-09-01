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
        Set<String> words = new TreeSet();
        Set<String> wordsForSound = new TreeSet();
        while (true) {
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //add words with two to output set and other to stringbuilder
            if (addWordsWithTwoQuotesToOutputSetAndOtherToStringbuilderAndToSoundsSet(line, stringBuilder, words, wordsForSound))
                continue;
            break;
        }
        try {
            reader.close();

        } catch (IOException e) {

        }

        //from stringBuilder to words
        String[] punctuationMarks = {"®", "\t", "…", "$", "–", "+", "_", "@", "&", "*", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "©", "“", "\\", "%", "{", "}", "[", "]", ">", "<", "=", "#", ",", ".", "!", "?", "-", ":", "\"", "(", ")", "—", "/", ";", ls, "\n", "\r\n"};
        removePunctuationsAndToLowerCase(stringBuilder, punctuationMarks);
        //stringBuilder.insert(0, "\"");//додавання кавичок на початок кавички для того щоб не розривалося слово апострофом

        String[] wholeStringArray = stringBuilder.toString().split(" ", 0);//нерозривний пробіл

        String[] stringArray2 = null;
        int i = 0;
        //набирання множини слів
        inputArraytoWordsSet(wholeStringArray, words);

        wordsForSound.addAll(words);

        Set<String> wordsForTranscription = new TreeSet();
        //add commas quotes
        Set<String> wordsForGoogle = new TreeSet();
        addCommasAndQuotes(words, wordsForGoogle, wordsForTranscription);


        //trim words
        trimWords(wordsForSound, wordsForGoogle, wordsForTranscription);

        //System.out.println(((TreeSet<String>) wordsForTranscription).first());

        //words to file write
        wordsToFileWrite(wordsForSound, wordsForGoogle, wordsForTranscription);
        return true;

    }

    private boolean addWordsWithTwoQuotesToOutputSetAndOtherToStringbuilderAndToSoundsSet(String line, StringBuilder stringBuilder, Set<String> words, Set<String> wordsForSound) {
        if (line == null)
            return false;
        if (line == "")
            return true;
        if (line.length() > 0 && line.charAt(0) != '#') {
            System.out.println(line.charAt(0));
            //додати готовий переклад, спочатку в окремий файл
            //if (line.charAt(0) == '\\' && line.charAt(1) == 't' && line.charAt(2) == 'r') {
            if (line.charAt(0) == '>') {
                System.out.println("!!!!!!!!!!!!!!!!!!!!!");
                String tempLineArr[] = line.split(">");
                System.out.println(Arrays.toString(tempLineArr));
                    wordsForSound.addAll(Arrays.asList(tempLineArr[1].split(" ")));
                new ReadyTranslation().AddToReadyTranslationFile(tempLineArr[1], tempLineArr[2]);


                //- words.add(tempLineArr[1]);
            } else if (line.charAt(0) == '"' && line.charAt(line.length() - 1) == '"') {
                String tempLine = line.substring(1, line.length() - 1);
                if (tempLine.contains(" ")) {
                    wordsForSound.addAll(Arrays.asList(tempLine.split(" ")));
                }
                words.add(tempLine);
            } else {
                stringBuilder.append(line);
                stringBuilder.append(" ");

            }

        }


        return true;
    }


    private void wordsToFileWrite(Set<String> wordsForSound, Set<String> wordsForGoogle, Set<String> wordsForTranscription) {
        new WriteReadFiles().writeFile(wordsForSound, "clearWords.txt");
        new WriteReadFiles().writeFile(wordsForGoogle, "words.txt");
        new WriteReadFiles().writeFile(wordsForGoogle, "wordsForGoogle.txt");
        //add empty lines
        BufferedWriter addTwoEmpltyLines = null;
        try {
            addTwoEmpltyLines = new BufferedWriter(new FileWriter("wordsForGoogle.txt", true));
            addTwoEmpltyLines.write("\n\n");
            addTwoEmpltyLines.close();}
        catch (IOException e) {
            e.printStackTrace();
        }

        new WriteReadFiles().writeFile(wordsForTranscription, "wordsfortranscription.txt");
        //empty file for translation
        try {
            new BufferedWriter(new FileWriter("onlyTranslation.txt")).close();
            new BufferedWriter(new FileWriter("transcription.txt")).close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void inputArraytoWordsSet(String[] wholeStringArray, Set<String> words) {
        int i;
        String[] stringArray2;
        for (String el : wholeStringArray) {
            i = 0;
            stringArray2 = el.split(" ", 0);//звичайний пробіл
            words.addAll(Arrays.asList(stringArray2));//множини без кавичок
        }
        words.remove("");  //delete empty strings
        words.remove("\"");  //delete empty strings

    }

    private void removePunctuationsAndToLowerCase(StringBuilder stringBuilder, String[] punctuationMarks) {
        for (int i = 0; i < stringBuilder.length(); i++) {
            //change all words to lower case
            char c = stringBuilder.charAt(i);
            stringBuilder.setCharAt(i, Character.toLowerCase(c));
            //remove punctuation
            removePunctuation(stringBuilder, punctuationMarks, i);

            clearStartEndOfWord(stringBuilder, i);
        }
    }

    private void addCommasAndQuotes(Set<String> words, Set<String> wordsForGoogle, Set<String> wordsForTranscription) {
        for (String el : words) {
            if (el.length() > 1) {
                wordsForGoogle.add(el + ",");
                //remove commas in middle of string for transcription
                String tmpEl = new StringBuilder((el.replace(",", ""))).toString();
                wordsForTranscription.add("\"" + tmpEl + "\"");
            }
        }
    }

    private void trimWords(Set<String> wordsForSound, Set<String> wordsWithCommas, Set<String> wordsForTranscription) {
        for (String el : wordsForSound) {
            el.trim();
        }
        for (String el : wordsWithCommas) {
            el.trim();
        }
        for (String el : wordsForTranscription) {
            el.trim();
        }
    }

    private void clearStartEndOfWord(StringBuilder stringBuilder, int i) {
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

    private void removePunctuation(StringBuilder stringBuilder, String[] punctuationMarks, int i) {
        if (Arrays.asList(punctuationMarks).contains(Character.toString(stringBuilder.charAt(i)))) {
            stringBuilder.replace(i, i + 1, " ");
        }
    }


}
