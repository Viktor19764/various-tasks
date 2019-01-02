package mateacademyinputtask;

import mateacademyinputtask.arraysofvalues.ProfessorsData;

public class Professor implements Person {
    //personal data
    private String id;
    private String name;
    private String discipline;

    public Professor(String id) {
        ProfessorsData professorsData = new ProfessorsData();
        this.id = id;
        for (String[] professorName : professorsData.getProfessorsData()) {
            if (professorName[0].equals(id))
                this.name = professorName[1];
        }
        for (String[] professorName : professorsData.getProfessorsData()) {
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

    public String getId() {
        return id;
    }
}
