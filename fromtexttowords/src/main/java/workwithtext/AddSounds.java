package workwithtext;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class AddSounds {
    private  static String ankiMediaDirectory = System.getProperty("user.home") +"/.local/share/Anki2/Користувач 1/collection.media/";

    public static void main(String[] args) throws MalformedURLException {
        System.out.println("start");
        // TODO Auto-generated method stub
    /*    System.setProperty("webdriver.chrome.driver", "lib/chromedriver"); // path of chromedriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://wooordhunt.ru/word/drizzling");
        driver.manage().window().maximize();
        driver.getTitle();*/


        BufferedReader wordsReader = null;
        try {
            wordsReader = new BufferedReader(new FileReader("clearWords.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String word = null;
        String check=null;
        int i =0;
        while(true){
            System.out.println(i);
            try {
                word = wordsReader.readLine();
                System.out.println(word);
            } catch (IOException e) {
                e.printStackTrace();
            }
            File file = new File(ankiMediaDirectory +word + ".mp3");

            if(!file.exists()){
                System.out.println("!"+word);
                URL website = new URL("https://wooordhunt.ru/data/sound/word/uk/mp3/"+word+".mp3");
                try(
                        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
                        FileOutputStream fos = new FileOutputStream(ankiMediaDirectory +word + ".mp3");
                        //FileOutputStream fos = new FileOutputStream("/home/viktor/.local/share/Anki2/Користувач 1/collection.media/" +word + ".mp3");
                ){
                    fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            try {
                check = FileUtils.getMimeType("file://"+ankiMediaDirectory +word + ".mp3");
                System.out.println(check);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(check=="text/html"){
                new File(ankiMediaDirectory +word + ".mp3").delete();
            }

            if(word==null)
                break;
            i++;
        }

        System.out.println("sound words checked");
    }
}

class FileUtils {
    public static String getMimeType(String fileUrl)
            throws java.io.IOException, MalformedURLException {
        String type = null;
        URL u = new URL(fileUrl);
        URLConnection uc = null;
        uc = u.openConnection();
        type = uc.getContentType();
        return type;
    }

}
