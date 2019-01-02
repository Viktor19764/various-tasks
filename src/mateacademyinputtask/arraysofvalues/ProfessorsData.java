package mateacademyinputtask.arraysofvalues;

public final class ProfessorsData {

    String[][] professorsData = {
            {"1","Abu Ali Sina", Groups.MEDICINE.toString()},
            {"2","Imhotep", Groups.ARCHITECTURE.toString()},
            {"3","Isaac Newton", Groups.PHYSICS.toString()},
            {"4","Pierre de Fermat", Groups.MATHEMATIC.toString()},
            {"5","Tapputi Belatekallim",Groups.CHEMISTRY.toString()},
            {"6","Elon Musk", Groups.ENGINEERING.toString()},
            {"7","Plato",Groups.ART.toString()}

    };

    public String[][] getProfessorsData() {
        return professorsData;
    }
}
