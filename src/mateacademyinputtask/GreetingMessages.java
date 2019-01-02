package mateacademyinputtask;

import java.util.Scanner;

public class GreetingMessages {

    public String greetingMessageForStudents(Scanner scanner) {
        scanner = new Scanner(System.in);
        System.out.println("Enter your ID:");
        String id = scanner.next();
        scanner.nextLine();
        System.out.println("Your name is: " + new Students(id).getName() + "\nYour group is " + new Students(id).getGroup());
        return id;
    }

    public String greetingMessageForProfessors(Scanner scanner) {
        scanner = new Scanner(System.in);
        System.out.println("Dear Professor, for logging enter your ID:");
        String id = scanner.next();
        scanner.nextLine();
        System.out.println("You are logged as: " + new Professor(id).getName() + "\nlecturer of " + new Professor(id).getDiscipline());
        return id;
    }

    public static void stars(){
        ///////////enter *******************
        int m = 36;
        int n = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //if (i == 0 || i == n - 1) {
                if (i == 0) {
                    System.out.print('*');
                } else {
                    if (j == 0 || j == m - 1) {
                        System.out.print('*');
                    } else {
                        System.out.print(' ');
                    }
                }
            }
            System.out.print("\n\r");
        }/////////////////
    }


}
