package workwithtext;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReverseDirectionTranslate {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader abc = new BufferedReader(new FileReader(file));
        List<String> lines = new ArrayList<>();
        List<String> newLines = new ArrayList<>();
        String line = null;

        while((line = abc.readLine()) != null){
            lines.add(line);
        }
        abc.close();
        for (String oneLine : lines){
            StringBuffer operationalLine = new StringBuffer(oneLine);
            int indexOfTab = operationalLine.indexOf("\t");
            String ukrSubstr = operationalLine.substring(indexOfTab+1);
            operationalLine.replace(indexOfTab,operationalLine.length(),"");
            String newString = ukrSubstr  + operationalLine;
            newLines.add(newString);
        }

        FileWriter writer = new FileWriter("ukr_eng.txt");
        for(String str:newLines){
            writer.write(str+System.lineSeparator());
        }
        writer.close();

    }
}
