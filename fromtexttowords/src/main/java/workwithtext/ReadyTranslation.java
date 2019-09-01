package workwithtext;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReadyTranslation {

    public void AddToReadyTranslationFile(String englishPhrase, String translation) {

        BufferedWriter addTranslationLine = null;
        try {
            addTranslationLine = new BufferedWriter(new FileWriter("readyTranslation.txt", true));
            addTranslationLine.write(englishPhrase + "<>" + translation + "<>");
            addTranslationLine.close();
            //додати транскрипцію
            String cmdline[] = new String[3];

            cmdline[0] = "sh";
            cmdline[1] = "-c";
            String line = null;


            line = new StringBuilder((englishPhrase.replace(",", ""))).toString();
            cmdline[2] = "/usr/bin/espeak " + "\"" + line + "\"" + "  --ipa >> " + "readyTranslation.txt";
            Runtime.getRuntime().exec(cmdline).waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
