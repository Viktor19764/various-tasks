package workwithtext;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class ToCsv {
    private String inputFilename1 = "wordsfortranscription.txt";
    private String inputFilename2 = "onlyTranslation.txt";
    private String inputFilename3 = "words.txt";
    private String outputFileName = "wordswithtranslation.txt";
    private String transcriptionFileName = "transcription.txt";

    public void toCsvWithoutEspeak() {
        System.out.println("start toCsvWithoutEspeak()");
        addReadyTranslationToThreeFiles();//додати до файлів ручний переклад
        String line1 = null;
        String line2 = null;
        String line3NoTrimed = null;
        String line3 = null;
        String line = null;
        Set<String> words = new TreeSet();
        //from file to stringBuilder
        BufferedReader reader3 = null;
        BufferedReader reader1 = new WriteReadFiles().readFile(inputFilename3);
        BufferedReader reader2 = new WriteReadFiles().readFile(inputFilename2);
        reader3 = new WriteReadFiles().readFile(transcriptionFileName);
        // StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                line = null;
                line1 = reader1.readLine();
                line2 = reader2.readLine();
                line3NoTrimed = reader3.readLine();
                if (line3NoTrimed != null)
                    line3 = line3NoTrimed.trim();//transcription

                if (line1 != null && line2 != null && line3 != null && !line1.equals(line2))
                //підняття регістру першої букви якщо потрібно у слові  англійською
                {
                    char[] line1ToCharArray = line1.toCharArray();
                    if (line1.length() > 0 && line2.length() > 0 && line2.toCharArray()[0] >= 1024 && line2.toCharArray()[0] <= 1071) {
                        //підняття першої букви у words.txt якщо потрібно
                        if (line1ToCharArray[0] > 96) {
                            line1ToCharArray[0] = (char) (line1ToCharArray[0] - 32);
                            line1 = "";
                            for (int i = 0; i < line1ToCharArray.length; i++)
                                line1 += String.valueOf(line1ToCharArray[i]);
                        }

                    }

                    //видалення коми на останньому місці
                    if (line1.length() > 1) {
                        if (line1ToCharArray[line1ToCharArray.length - 1] == ',') {
                            line1 = "";
                            for (int i = 0; i < line1ToCharArray.length - 1; i++) {
                                System.out.println(line1ToCharArray[i]);
                                line1 += String.valueOf(line1ToCharArray[i]);
                            }
                        }
                    }
                    if (line2.length() > 1) {
                        char[] line2ToCharArray = line2.toCharArray();
                        if (line2ToCharArray[line2ToCharArray.length - 1] == ',') {
                            line2 = "";
                            for (int i = 0; i < line2ToCharArray.length - 1; i++)
                                line2 += String.valueOf(line2ToCharArray[i]);
                        }
                    }


                    //line = "<font color=\"yellow\"><h1>"+line1 + "</h1>" + line3 + "</font>;" + line2;
                    line = "<b>" + line1 + "</b><br><div><i>/" + line3 + "/</i></div>" + lineMp3(line1) + "\\" + line2;
                } else if (line1 != null && line2 != null)
                    line = line1 + "\\" + line2;
                if (line == null)
                    break;
                //check if translated to Ukrainian
                if (!line1.toLowerCase().equals(line2.toLowerCase()))
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
            reader3.close();

        } catch (IOException e) {

        }
        new WriteReadFiles().writeFile(words, outputFileName);
    }

    public void toCsv() {
        createTranscriptionFile(inputFilename1);
        toCsvWithoutEspeak();


    }

    private void createTranscriptionFile(String inputFileName) {
        //clear file
        try {
            new BufferedWriter(new FileWriter(transcriptionFileName)).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new WriteReadFiles().readFile(inputFileName);
        String line = null;
        String[] cmdline = new String[3];
        cmdline[0] = "sh";
        cmdline[1] = "-c";
        while (true) {
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (line == null)
                break;
            try {

                cmdline[2] = "/usr/bin/espeak " + line + "  --ipa >> " + transcriptionFileName;
                Runtime.getRuntime().exec(cmdline).waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

        }
        try {
            reader.close();

        } catch (IOException e) {

        }
        //String[] cmdline = { "sh", "-c", "/bin/cat " + inputFileName + " | while read line; do   /usr/bin/espeak  --ipa >> " + transcriptionFileName + "; done"};

//        try {
//            //Runtime.getRuntime().exec("/bin/cat " + inputFileName + " | while read line; do   /usr/bin/espeak  --ipa >> " + transcriptionFileName + "; done").waitFor();
//            //Runtime.getRuntime().exec("/usr/bin/espeak " + s + "  --ipa >> transcription.txt").waitFor();
//            Runtime.getRuntime().exec(cmdline).waitFor();
//        } catch (IOException e) {
//            System.out.println("Ой-ой!");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    String lineMp3(String line) {
        String lineWithMp3 = "";
        String fileName = line.toLowerCase();
        String new_line = line.replaceAll(",", " ");
        String[] lineArray = new_line.split(" ");
        for (String el : lineArray) {
            if (el.length() > 1)
                lineWithMp3 += "[sound:" + el + ".mp3]";
        }
        //File file = new File("/home/viktor/.local/share/Anki2/Користувач 1/collection.media/" +fileName + ".mp3");
        //if(file.exists()){
        // return "[sound:"+fileName+".mp3]";
        //}
        //return "";
        return lineWithMp3;
    }

    private void addReadyTranslationToThreeFiles() {
        BufferedReader reader1 = new WriteReadFiles().readFile("readyTranslation.txt");
        String line = null;
        while (true) {
            try {
                line = reader1.readLine();
                if (line == null)
                    break;
                BufferedWriter addEngishPhraseToWordsFile = new BufferedWriter(new FileWriter("words.txt", true));
                addEngishPhraseToWordsFile.write(line.split("<>")[0]+"\n");
                addEngishPhraseToWordsFile.close();

                BufferedWriter addTranslationToTranslationsFile = new BufferedWriter(new FileWriter("onlyTranslation.txt", true));
                addTranslationToTranslationsFile.write(line.split("<>")[1]+"\n");
                addTranslationToTranslationsFile.close();

                BufferedWriter addTranscriptionFile = new BufferedWriter(new FileWriter("transcription.txt", true));
                addTranscriptionFile.write(line.split("<>")[2]+"\n");
                addTranscriptionFile.close();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
