package mateacademyinputtask;

import mateacademyinputtask.arraysofvalues.PersonaDataOfStudents;
import mateacademyinputtask.arraysofvalues.ProfessorsData;

import java.util.Scanner;

public class Logging {

    public String greetingMessageForStudents(Scanner scanner) {
        scanner = new Scanner(System.in);
        System.out.println("Enter your ID:");
        String id = null;
        while (true) {
            id = scanner.next();
            scanner.nextLine();
            if (checkStudentsId(id)) {
                Students students = new Students(id);
                System.out.println("Your name is: " + students.getName() + "\nYour group is " + students.getGroup());
                return id;
            } else {
                System.out.println("Incorrect ID\nPlease reenter");
            }
        }
    }

    public String greetingMessageForProfessors(Scanner scanner) {
        scanner = new Scanner(System.in);
        System.out.println("Dear Professor, for logging enter your ID:");
        String id = null;
        while (true) {
            id = scanner.next();
            scanner.nextLine();
            if (checkProfessorsId(id)) {
                Professor professor = new Professor(id);
                System.out.println("You are logged as: " + professor.getName() + "\nlecturer of " + professor.getDiscipline());
                return id;
            } else {
                System.out.println("Incorrect ID\nPlease reenter");
            }
        }
    }

    private boolean checkStudentsId(String id) {
        PersonaDataOfStudents personaDataOfStudents = new PersonaDataOfStudents();
        for (String[] personaDataOfStudentsRow : personaDataOfStudents.getPersonalDataArray()) {
            if (personaDataOfStudentsRow[0].equals(id))
                return true;
        }
        return false;
    }

    private boolean checkProfessorsId(String id) {
        ProfessorsData professorsData = new ProfessorsData();
        for (String[] professorsNamesRow : professorsData.getProfessorsData()) {
            if (professorsNamesRow[0].equals(id))
                return true;
        }
        return false;
    }

    public static String backExitCheckButtons(Scanner scanner, boolean isStudentsMethods) {
        String enterredKey = scanner.next();
        if (enterredKey.equals("b")) {
            StudentsMethods.isStudentsMethods = false;
            ProfessorsMethods.isProfessorssMethods = false;
        }
        //exit when "0" pressed
        if (enterredKey.equals("0"))
            System.exit(0);
        return enterredKey;
    }

    public static void stars(int weight) {
        ///////////enter *******************
        int m = weight;
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
