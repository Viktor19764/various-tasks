package mateacademyinputtask;

import java.util.Scanner;

public class Entering {
    static int identifier;
    boolean isEntering = true;//check if is entering window

    public void entering() {
        Logging.stars(20);

        System.out.println("*!for exit press 0!*");
        System.out.println("*                  *");
        System.out.println("*                  *");
        Scanner scanner = new Scanner(System.in);
        System.out.println("* Enter a key:     *\n" +
                "* 1 for students   *,\n* 2 for headmen    *,\n* 3 for professor: *");
        String enterredKey = scanner.next();
        //exit when "0" pressed
        if (enterredKey.equals("0"))
            System.exit(0);
        if (enterredKey.equals("1")) {
            StudentsMethods studentsMethods = new StudentsMethods();
            isEntering = false;
            identifier = 1;
        }
        if (enterredKey.equals("3")) {
            StudentsMethods studentsMethods = new StudentsMethods();
            isEntering = false;
            identifier = 3;
        }
    }

    public boolean isEntering() {
        return isEntering;
    }
}
