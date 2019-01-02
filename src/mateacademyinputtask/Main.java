package mateacademyinputtask;

public class Main {

    public static void main(String[] args) {

        while (true) {
            Entering entering = new Entering();
            while (entering.isEntering()) {
                entering.entering();
                //clear console
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
            switch (Entering.identifier) {
                case 1:
                    StudentsMethods studentsMethods = new StudentsMethods();
                    while (studentsMethods.isStudentsMethods()) {

                        studentsMethods.studentsMethods();
                        //clear console
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                    }
                    break;
                case 3:
                    ProfessorsMethods professorsMethods = new ProfessorsMethods();
                    while (professorsMethods.isProfessorssMethods()) {
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
