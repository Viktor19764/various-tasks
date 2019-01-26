package workwithtext;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class ToCsv {
    private String inputFilename1 = "wordsfortranscription.txt";
    private String inputFilename2 = "onlyTranslation.txt";
    private String inputFilename3 = "words.txt";
    private String outputFileName = "wordswithtranslation.txt";
    private String transcriptionFileName = "transcription.txt";


    public void toCsv() {
        createTranscriptionFile(inputFilename1);

        String line1 = null;
        String line2 = null;
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
                if (reader3 != null)
                    line3 = reader3.readLine();//transcription
                if (line1 != null && line2 != null && line3 != null)
                    line = line1 + "\n" + line3 + ";" + line2;
                else if (line1 != null && line2 != null)
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
            reader3.close();

        } catch (IOException e) {

        }
        new WriteReadFiles().writeFile(words, outputFileName);
    }

    private void createTranscriptionFile(String inputFileName) {
        BufferedReader reader = new WriteReadFiles().readFile(inputFileName);
        String line = null;
        String[] cmdline = new String[3];
        cmdline[0] = "sh";
        cmdline[1] = "-c";
        while (true) {
            try {
                line = reader.readLine();
                cmdline[2] = "/usr/bin/espeak " + line + "  --ipa >> " + transcriptionFileName;
                Runtime.getRuntime().exec(cmdline).waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            if (line == null)
                break;

        }
        try {
            reader.close();

        } catch (IOException e) {

        }
        //String[] cmdline = { "sh", "-c", "/bin/cat " + inputFileName + " | while read line; do   /usr/bin/espeak  --ipa >> " + transcriptionFileName + "; done"};

        try {
            //Runtime.getRuntime().exec("/bin/cat " + inputFileName + " | while read line; do   /usr/bin/espeak  --ipa >> " + transcriptionFileName + "; done").waitFor();
            //Runtime.getRuntime().exec("/usr/bin/espeak " + s + "  --ipa >> transcription.txt").waitFor();
            Runtime.getRuntime().exec(cmdline).waitFor();
        } catch (IOException e) {
            System.out.println("Ой-ой!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
