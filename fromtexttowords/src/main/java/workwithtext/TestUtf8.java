package workwithtext;

public class TestUtf8 {
    public static void main(String[] args) {
        int x = (int) 'Ѐ';
        System.out.println(x);
        x = (int) 'Я';
        System.out.println(x);
        x = (int) 'а';
        System.out.println(x);
        String s = "ad\n" +
                "al,\n" +
                "about\n" +
                "above\n" +
                "across\n" +
                "africa\n" +
                "after\n" +
                "afternoon\n" +
                "again\n" +
                "against\n" +
                "ago\n" +
                "ahmar\n" +
                "al\n" +
                "Alaska\n" +
                "alhambra,";
        System.out.println(s.toCharArray()[s.toCharArray().length-1]);

    }
}
