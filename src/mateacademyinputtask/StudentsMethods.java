package mateacademyinputtask;

import mateacademyinputtask.arraysofvalues.PersonaDataOfStudents;

import java.io.*;
import java.util.*;

public class StudentsMethods implements Serializable {
    private boolean isAllVoted = false;
    boolean isStudentsMethods = true;
    private Map<String, Integer> highScore;//
    private List<String> votedIds;

    public StudentsMethods() {
    }

    public void studentsMethods() {
        GreetingMessages.stars();

        System.out.println("*        !for exit press 0!        *");
        System.out.println("*          Students area           *");
        System.out.println("*   for previous page - press b    *");
        System.out.println("*                                  *");
        System.out.println("* For election of headman press 1  *");
        Scanner scanner = new Scanner(System.in);
        String enterredKey = scanner.next();


//        KeyEvent mainMenu = null;
//        if (mainMenu.getKeyCode() == KeyEvent.VK_SPACE) {
//            isStudentsMethods = false;
//        }

        if (enterredKey.equals("b"))
            isStudentsMethods = false;
        //exit when "0" pressed
        if (enterredKey.equals("0"))
            System.exit(0);
        if (enterredKey.equals("1")) {
            GreetingMessages greetingMessages = new GreetingMessages();
            String id = greetingMessages.greetingMessageForStudents(scanner);
            String currentGroup = findGroup(id);
//            System.out.println("Enter your ID:");
//            String id = scanner.next();
//            scanner.nextLine();
//            System.out.println(id);
//            System.out.println("Your name is " + new Students(id).getName() + "\nYour group is " + new Students(id).getGroup());

            ////////////
            if (readHighScore() != null)
                highScore = new HashMap<>(readHighScore());
            else
                highScore = new HashMap<>();
            if (readvotedIds() != null)
                votedIds = new ArrayList<>(readvotedIds());
            else
                votedIds = new ArrayList<>();
            if (votedIds != null && votedIds.contains(id)) {

                System.out.println("You are voted");
                checkIfAllVoted(currentGroup);
                System.out.println("Press any key");
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            //if (false) {//check if already was election
//            if (readHighScore() != null && votedIds != null) {
//                highScore = new HashMap<>(readHighScore());
//                votedIds = new ArrayList<>(readvotedIds());
//            } else {
//                highScore = new HashMap<>();
//                votedIds = new ArrayList<>();
//            }


            Students maxRatingStudent = null;
            if (maxRatePersonIdAndRating(currentGroup) != null)
                maxRatingStudent = new Students(maxRatePersonIdAndRating(currentGroup).getKey());
            if (maxRatePersonIdAndRating(currentGroup) != null && highScore.size() > 0 && maxRatingStudent.getRating() > 0) {//check if already was election
                System.out.println("Candidate for headman is: \n" + "ID: " + maxRatingStudent.getId() + " " +
                        maxRatingStudent.getName() + " , rating is: " + maxRatingStudent.getRating());
                votedIds.add(id);
                electionOfHeadman(id, scanner, currentGroup);//id for electing only in its group
            } else if (!votedIds.contains(id)) {
                votedIds.add(id);
                electionOfHeadman(id, scanner, currentGroup);//id for electing only in its group
            } else {//if all students voted

                checkIfAllVoted(currentGroup);

            }


        }


    }

    private int electionOfHeadman(String id, Scanner scanner, String currentGroup) {
        PersonaDataOfStudents personaDataOfStudents = new PersonaDataOfStudents();
        //searching group of current student
        //String currentGroup = null;
        String currentName = null;
        //currentGroup = findGroup(id);
        if (currentGroup == null) {
            System.out.println("Incorrect ID\nPress any key");
            scanner.next();
            return -1;
        }
        //evaluation not the given user  and only current group
        for (String[] person : personaDataOfStudents.getPersonalDataArray()) {
            if (!id.equals(person[0]) && currentGroup.equals(person[4])) {
                Students students = new Students(person[0]);

                System.out.println("Estimate creativity for:");
                students.setCreativity(inputDialog(scanner, person, students));

                System.out.println("Estimate sociability for:");
                students.setSociability(inputDialog(scanner, person, students));

                System.out.println("Estimate cooperate ability for:");
                students.setCooperateAbility(inputDialog(scanner, person, students));

                System.out.println("Estimate initiative for:");
                students.setInitiative(inputDialog(scanner, person, students));

                System.out.println("Estimate persistence for:");
                students.setPersistence(inputDialog(scanner, person, students));

                System.out.println("Estimate adaptability for:");
                students.setAdaptability(inputDialog(scanner, person, students));

                System.out.println("Estimate lidership for:");
                students.setLeadership(inputDialog(scanner, person, students));

                System.out.println("Estimate cultural awareness for:");
                students.setCulturalAwareness(inputDialog(scanner, person, students));

                students.setRating();

                System.out.println("********************");
                System.out.println("Total rating for: " + person[1] + " : " + students.getRating());
                System.out.println("********************");

                highScore.put(students.getId(), students.getRating());
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            //serialize rating values
            try {
                FileOutputStream fileOutputStream = new FileOutputStream("highScoreAll.out");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(highScore);
                objectOutputStream.flush();
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //serialize voted values
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("votedIdsAll.out");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(votedIds);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return 1;
    }

    public boolean isStudentsMethods() {
        return isStudentsMethods;
    }

    private int inputDialog(Scanner scanner, String person[], Students students) {
        System.out.println("Student: " + person[1] + ", grade (from 1 to 10):");
        //int enterredKey = Integer.parseInt(scanner.next());
        int enterredKey = 0;
        while (true) {   //check correct input for numbers 1-10
            try {
                enterredKey = scanner.nextInt();


                if (enterredKey == 1 || enterredKey == 2 || enterredKey == 3 || enterredKey == 4 || enterredKey == 5 || enterredKey == 6 || enterredKey == 7 || enterredKey == 8 || enterredKey == 9 || enterredKey == 10)
                    break;
                else
                    System.out.println("Reenter correct grade (1-10)");
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Reenter correct grade (1-10)");
            }
        }
        //students.setRating(enterredKey);
        return enterredKey;
    }

    private Map.Entry<String, Integer> maxRatePersonIdAndRating(String currentGroupp) {
        //search max rating for setting headman
        PersonaDataOfStudents personaDataOfStudents = new PersonaDataOfStudents();
        Map.Entry<String, Integer> maxRating = null;
        for (String[] personaDataOfStudent : personaDataOfStudents.getPersonalDataArray()) {
            for (Map.Entry<String, Integer> entry : highScore.entrySet()) {
                if (personaDataOfStudent[4].equals(currentGroupp) && personaDataOfStudent[0].equals(entry.getKey())) {
                    if (maxRating == null || entry.getValue().compareTo(maxRating.getValue()) > 0)
                        maxRating = entry;
                }

            }
        }
        return maxRating;
    }

    private ArrayList<String> readvotedIds() {
        try {
            FileInputStream fileInputStream = new FileInputStream("votedIdsAll.out");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (ArrayList<String>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            //String path = new File("").getAbsolutePath();
            File file = new File("votedIdsAll.out");
            try {
                file.createNewFile();
            } catch (IOException e1) {
                System.out.println("No access to saving dates");
            }
        }
        return null;
    }

    public Map<String, Integer> readHighScore() {
        try {
            FileInputStream fileInputStream = new FileInputStream("highScoreAll.out");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Map<String, Integer>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            //String path = new File("").getAbsolutePath();
            File file = new File("highScoreAll.out");
            try {
                file.createNewFile();
            } catch (IOException e1) {
                System.out.println("No access to saving dates");
            }
        }
        return null;
    }

    private String findGroup(String id) {
        String currentGroup = null;
        PersonaDataOfStudents personaDataOfStudents = new PersonaDataOfStudents();
        for (String[] person : personaDataOfStudents.getPersonalDataArray()) {
            if (id.equals(person[0])) {
                currentGroup = person[4];
                //System.out.println("Your name is: " + person[1] + "\nYour group: " + currentGroup);
            }
        }
        return currentGroup;
    }

    private boolean checkIfAllVoted(String currentGroup) {
        List<String> membersOfGroup = new ArrayList<>();
        PersonaDataOfStudents personaDataOfStudents = new PersonaDataOfStudents();
        for (String[] person : personaDataOfStudents.getPersonalDataArray()) {
            if (currentGroup.equals(person[4])) {
                membersOfGroup.add(person[0]);
            }

        }
        for (String membersOfGroupElement : membersOfGroup) {
            isAllVoted = true;
            if (!votedIds.contains(membersOfGroupElement)) {
                isAllVoted = false;
                break;
            }
        }
        if (isAllVoted) {
//                    currentGroup= Groups.CHEMISTRY.toString();
            //System.out.println("Group: " + currentGroup);
//                    String idd = maxRatePersonIdAndRating(currentGroup).getKey();
//                    maxRatingStudent = new Students(idd);

            Students maxRatingStudent = new Students(maxRatePersonIdAndRating(currentGroup).getKey());
            System.out.println("Your headman is:\n" + maxRatingStudent.getName());
        }
        return isAllVoted;
    }

}
