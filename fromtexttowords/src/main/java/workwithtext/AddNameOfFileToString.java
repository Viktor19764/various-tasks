package workwithtext;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddNameOfFileToString {
    public static void main(String[] args) throws IOException {
        String file = null;
        if (args.length > 0)
            file = args[0];
        file = "/home/viktor/springinaction.txt";

        List<String> lines = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        List<String> linesChanged = new ArrayList<>();
        for (String oneLine : lines) {
            String subString1 = oneLine.substring(64);
            int indexOfBracket = subString1.indexOf('<');
            String word = subString1.substring(0, indexOfBracket);
            String nameOfMp3 = "[sound:" + word + ".mp3]";
            int indexOfTab = oneLine.indexOf("\t");
            String subStringBeforeTab = oneLine.substring(0, indexOfTab);
            String subStringAfterTab = oneLine.substring(indexOfTab);
            linesChanged.add(subStringBeforeTab + nameOfMp3 + subStringAfterTab);

        }
        for (String lineEl : linesChanged)
            System.out.println(lineEl);

        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/viktor/springinactionwithmp3.txt"));
        for(String lineEl : linesChanged)
           writer.write(lineEl);
        writer.close();


    }
}
