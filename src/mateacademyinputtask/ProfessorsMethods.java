package mateacademyinputtask;

import mateacademyinputtask.arraysofvalues.PersonaDataOfStudents;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProfessorsMethods {

    private boolean isProfessorssMethods = true;
    private String status;

    public void professorsMethods() {
        GreetingMessages.stars();
        System.out.println("*        !for exit press 0!        *");
        System.out.println("*          Professors area         *");
        System.out.println("*   for previous page - press b    *");
        System.out.println("*                                  *");
        System.out.println("*      For rollcall press 1        *");
        Scanner scanner = new Scanner(System.in);
        String enterredKey = scanner.next();

        if (enterredKey.equals("b"))
            isProfessorssMethods = false;
        //exit when "0" pressed
        if (enterredKey.equals("0"))
            System.exit(0);


        //for rollcall
        if (enterredKey.equals("1")) {
            GreetingMessages greetingMessages = new GreetingMessages();
            String id = greetingMessages.greetingMessageForProfessors(scanner);

            Professor professor = new Professor(id);

            List<String[]> listOfStudentsOfDiscipline = listOfStudentsOfDiscipline(professor);

            System.out.println("List of students:");

            int i = 1;
            for (String[] listOfStudentsOfDisciplineElement : listOfStudentsOfDiscipline) {
                System.out.println(i + ".\t" + listOfStudentsOfDisciplineElement[1]);
                i++;
            }
            System.out.println("Rollcall:\nif is present, press 1,\nif is absent, press 0");
            boolean checkButton;
            i = 0;
            for (String[] listOfStudentsOfDisciplineElement : listOfStudentsOfDiscipline) {
                System.out.println(i + 1 + ".\t" + listOfStudentsOfDisciplineElement[1]);

                do {
                    checkButton = true;
                    status = scanner.next();
                    if (status.equals("1"))
                        status = "present";
                    else if (status.equals("0"))
                        status = "absent";
                    else
                        checkButton = false;
                } while (!checkButton);

                listOfStudentsOfDiscipline.set(i, new String[]{"" + (i + 1), listOfStudentsOfDisciplineElement[1], status});
                i++;
            }
            System.out.println();
            System.out.println("Results of rollcall:");
            for (String[] listOfStudentsOfDisciplineElement : listOfStudentsOfDiscipline) {
                //System.out.println(listOfStudentsOfDisciplineElement[0] + ".\t" + listOfStudentsOfDisciplineElement[1] + "\t " + listOfStudentsOfDisciplineElement[2]);
                System.out.printf(listOfStudentsOfDisciplineElement[0]+".");
                System.out.printf("%-23s", " " + listOfStudentsOfDisciplineElement[1]);
                System.out.println(listOfStudentsOfDisciplineElement[2]);
            }
            try {
                System.out.println("Rollcall is ready");
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    private List<String[]> listOfStudentsOfDiscipline(Professor professor) {
        PersonaDataOfStudents personaDataOfStudents = new PersonaDataOfStudents();
        List<String[]> listOfStudentsOfDiscipline = new ArrayList<>();
        for (String[] person : personaDataOfStudents.getPersonalDataArray()) {
            if (professor.getDiscipline().equals(person[4])) {
                listOfStudentsOfDiscipline.add(person);
            }
        }
        return listOfStudentsOfDiscipline;
    }

    public boolean isProfessorssMethods() {
        return isProfessorssMethods;
    }
}
