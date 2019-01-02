package mateacademyinputtask.arraysofvalues;

public final class ProfessorsData {

    String[][] professorsData = {
            {"1","Abu Ali Sina", Disciplines.MEDICINE.toString()},
            {"2","Imhotep", Disciplines.ARCHITECTURE.toString()},
            {"3","Isaac Newton", Disciplines.PHYSICS.toString()},
            {"4","Pierre de Fermat", Disciplines.MATHEMATIC.toString()},
            {"5","Tapputi Belatekallim", Disciplines.CHEMISTRY.toString()},
            {"6","Elon Musk", Disciplines.ENGINEERING.toString()},
            {"7","Plato", Disciplines.ART.toString()}

    };

    public String[][] getProfessorsData() {
        return professorsData;
    }
}
