package workwithtext;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class WriteReadFiles {

    public BufferedReader readFile(String inputFile) {

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(inputFile));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return reader;
    }

    public void writeFile(Set words, String outputFileName) {
        BufferedWriter out = null;
        Iterator it = words.iterator();
        String line = null;
        try {
            out = new BufferedWriter(new FileWriter(outputFileName));
            while (it.hasNext()) {
                line = it.next().toString();
                if (!Arrays.asList(line.toCharArray()).contains(' ') && !Arrays.asList(line.toCharArray()).contains(0x0A) && line.length() > 1 ) {  //pass empty strings
                    out.write(line);
                    out.newLine();
                }
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
