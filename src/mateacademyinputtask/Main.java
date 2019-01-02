package mateacademyinputtask;


/* "Першокурсники":

         В програмі мають бути створені класи: студенти, професор, група (за бажанням класи можна додавати);
         Дизайн класів (їх поля, взаємозв’язки) - також твоя задача;
         Студенти повинні вміти обрати Старосту за особистими якостями одногрупників (правила відбору визначаєш ти). Програма повинна виводити Старосту групи в консоль;
         Професор має вміти провести перекличку та визначити, чи всі студенти присутні (результат виводиться в консоль);
         Набір студентів, груп та професорів може бути заданий за замовчуванням (можна захардкодити);
         Приділи увагу правилам ООП;
         Не забудь прикласти інструкцію користувача до виконаного завдання.

         Під час виконання завдання можуть виникати питання. Це нормально! Ми створили спеціальний slack канал, в якому ти можеш задавати питання нашим тренерам-програмістам. Щоб мати можливість бути на зв’язку з нашими тренерами та ставити питання - відгукнися на slack запрошення, яке ми тобі вислали на пошту.
         */
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
                    while (professorsMethods.isProfessorssMethods()){
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
