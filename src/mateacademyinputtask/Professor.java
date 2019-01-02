package mateacademyinputtask;

import mateacademyinputtask.arraysofvalues.ProfessorsNames;

public class Professor implements Person {
    //personal data
    private String id;
    private String name;
    private String discipline;

    public Professor(String id) {
        ProfessorsNames professorsNames = new ProfessorsNames();
        this.id = id;
        for (String[] professorName : professorsNames.getProfessorsNames()) {
            if (professorName[0].equals(id))
                this.name = professorName[1];
        }
        for (String[] professorName : professorsNames.getProfessorsNames()) {
            if (professorName[0].equals(id))
                this.discipline = professorName[2];
        }
    }

    @Override
    public String getName() {
        return name;
    }

    public String getDiscipline() {
        return discipline;
    }
}
