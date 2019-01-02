package mateacademyinputtask;

public class Main {

    public static void main(String[] args) {

        Entering entering = new Entering();
        StudentsMethods studentsMethods = new StudentsMethods();
        ProfessorsMethods professorsMethods = new ProfessorsMethods();

        while (true) {
            entering.entering();
            //clear console
            System.out.print("\033[H\033[2J");
            System.out.flush();

            switch (Entering.identifier) {
                case 1:
                    while (StudentsMethods.isStudentsMethods) {
                        studentsMethods.studentsMethods();
                        //clear console
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                    }
                    break;
                case 3:
                    while (ProfessorsMethods.isProfessorssMethods) {
                        professorsMethods.professorsMethods();
                        //clear console
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                    }
                    break;
            }
        }
    }
}