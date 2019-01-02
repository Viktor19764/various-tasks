package mateacademyinputtask;

import mateacademyinputtask.arraysofvalues.PersonaDataOfStudents;
import mateacademyinputtask.arraysofvalues.ProfessorsData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProfessorsMethods {

    public static boolean isProfessorssMethods = true;
    private String status;

    public void professorsMethods() {
        Logging.stars(36);
        System.out.println("*        !for exit press 0!        *");
        System.out.println("*          Professors area         *");
        System.out.println("*   for previous page - press b    *");
        System.out.println("*                                  *");
        System.out.println("*      For rollcall press 1        *");
        Scanner scanner = new Scanner(System.in);
        if (Logging.backExitCheckButtons(scanner, isProfessorssMethods).equals("1")) {//check pressed button
            Logging logging = new Logging();
            String id = logging.greetingMessageForProfessors(scanner);

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
                System.out.printf("%2s", listOfStudentsOfDisciplineElement[0]);
                System.out.printf(".");
                System.out.printf("%-23s", " " + listOfStudentsOfDisciplineElement[1]);
                System.out.println(listOfStudentsOfDisciplineElement[2]);
            }
            try {
                System.out.println("Rollcall is ready\nPress any button");
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private List<String[]> listOfStudentsOfDiscipline(Professor professor) {
        PersonaDataOfStudents personaDataOfStudents = new PersonaDataOfStudents();
        ProfessorsData professorsData = new ProfessorsData();
        List<String[]> listOfStudentsOfDiscipline = new ArrayList<>();
        //String[] person;
        for (String[] disciplines : professorsData.getProfessorsData()) {
            for (String[] group : personaDataOfStudents.getDisciplinesOfGroupsArray()) {
                for (String[] person : personaDataOfStudents.getPersonalDataArray()) {
                    if (professor.getId().equals(disciplines[0]) && Arrays.asList(group).contains(disciplines[2]) && person[4].equals(group[0]))
                        listOfStudentsOfDiscipline.add(person);
                }
            }
        }
        return listOfStudentsOfDiscipline;
    }
}