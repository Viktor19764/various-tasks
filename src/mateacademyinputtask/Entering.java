package mateacademyinputtask;

import java.util.Scanner;

public class Entering {
    static int identifier;

    public void entering() {
        Logging.stars(20);

        System.out.println("*!for exit press 0!*");
        System.out.println("*                  *");
        System.out.println("*                  *");
        Scanner scanner = new Scanner(System.in);
        System.out.println("* Enter a key:     *\n" +
                "* 1 for students   *,\n* 2 for headmen    *,\n* 3 for professor: *");
        String enterredKey = null;

        //exit when "0" pressed
        while (true) {
            enterredKey = scanner.next();
            if (enterredKey.equals("0")) {
                System.exit(0);
                break;
            }
            if (enterredKey.equals("1")) {
                StudentsMethods.isStudentsMethods = true;
                identifier = 1;
                break;
            }
            if (enterredKey.equals("3")) {
                ProfessorsMethods.isProfessorssMethods = true;
                identifier = 3;
                break;
            } else
                break;
        }
    }
}