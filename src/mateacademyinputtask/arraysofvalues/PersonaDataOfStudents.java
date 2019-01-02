package mateacademyinputtask.arraysofvalues;

public final class PersonaDataOfStudents {

//    public String[][] personalDataArray = {
//            {"1", "Anatoliy Melnyk", "20", Sex.MALE.toString(), Disciplines.ART.toString()},
//            {"2", "Ruslana Shevchenko", "17", Sex.FEMALE.toString(), Disciplines.ARCHITECTURE.toString()},
//            {"3", "Yaroslav Boiko", "21", Sex.MALE.toString(), Disciplines.ENGINEERING.toString()},
//            {"4", "Stepan Kovalenko", "20", Sex.MALE.toString(), Disciplines.ENGINEERING.toString()},
//            {"5", "Pylyp Bondarenko", "22", Sex.MALE.toString(), Disciplines.ARCHITECTURE.toString()},
//            {"6", "Oliana Melnyk", "19", Sex.FEMALE.toString(), Disciplines.ARCHITECTURE.toString()},
//            {"7", "Mykola Tkachenko", "18", Sex.MALE.toString(), Disciplines.CHEMISTRY.toString()},
//            {"8", "Hlib Kovalchuk", "23", Sex.MALE.toString(), Disciplines.CHEMISTRY.toString()},
//            {"9", "Denys Petrenko", "24", Sex.MALE.toString(), Disciplines.ENGINEERING.toString()},
//            {"10", "Davyd Havrylukk", "19", Sex.MALE.toString(), Disciplines.ENGINEERING.toString()},
//            {"11", "Fedir Kuzmenko", "21", Sex.MALE.toString(), Disciplines.CHEMISTRY.toString()},
//            {"12", "Bohdan Kharchenko", "22", Sex.MALE.toString(), Disciplines.ARCHITECTURE.toString()},
//            {"13", "Ivanna Ponomarenko", "20", Sex.FEMALE.toString(), Disciplines.ENGINEERING.toString()},
//            {"14", "Anton Melnychuk", "22", Sex.MALE.toString(), Disciplines.ENGINEERING.toString()},
//            {"15", "Matvii Levchenko", "21", Sex.MALE.toString(), Disciplines.ARCHITECTURE.toString()},
//            {"16", "Leonid Pavluk", "20", Sex.MALE.toString(), Disciplines.CHEMISTRY.toString()},
//            {"17", "Roman Panchenko", "20", Sex.MALE.toString(), Disciplines.ARCHITECTURE.toString()},
//            {"18", "Serhii Lytvynenko", "18", Sex.MALE.toString(), Disciplines.CHEMISTRY.toString()},
//            {"19", "Ostap Kostiuk", "20", Sex.MALE.toString(), Disciplines.ARCHITECTURE.toString()},
//            {"20", "Kateryna Prykhodko", "21", Sex.FEMALE.toString(), Disciplines.ARCHITECTURE.toString()},
//            {"21", "Pavlo Yakovenko", "20", Sex.MALE.toString(), Disciplines.ENGINEERING.toString()},
//            {"22", "Oleksii Honchar", "17", Sex.MALE.toString(), Disciplines.ARCHITECTURE.toString()},
//            {"23", "Danyloy Nazarenko", "20", Sex.MALE.toString(), Disciplines.CHEMISTRY.toString()},
//            {"24", "Alisa Tyshchenko", "22", Sex.FEMALE.toString(), Disciplines.ENGINEERING.toString()},
//            {"25", "Taras Zinchenko", "20", Sex.MALE.toString(), Disciplines.CHEMISTRY.toString()},
//            {"26", "Vira Fop", "18", Sex.FEMALE.toString(), Disciplines.ENGINEERING.toString()},
//            {"27", "Vasyl Shapoval", "22", Sex.MALE.toString(), Disciplines.CHEMISTRY.toString()},
//            {"28", "Anton Riabokuchma", "19", Sex.MALE.toString(), Disciplines.CHEMISTRY.toString()},
//            {"29", "Mykola Shulha", "20", Sex.MALE.toString(), Disciplines.ART.toString()},
//
//    };

    public String[][] personalDataArray = {
            {"1", "Anatoliy Melnyk", "20", Sex.MALE.toString(), Groups.ONE.toString()},
            {"2", "Ruslana Shevchenko", "17", Sex.FEMALE.toString(), Groups.ONE.toString()},
            {"3", "Yaroslav Boiko", "21", Sex.MALE.toString(), Groups.TWO.toString()},
            {"4", "Stepan Kovalenko", "20", Sex.MALE.toString(), Groups.TWO.toString()},
            {"5", "Pylyp Bondarenko", "22", Sex.MALE.toString(), Groups.ONE.toString()},
            {"6", "Oliana Melnyk", "19", Sex.FEMALE.toString(), Groups.TWO.toString()},
            {"7", "Mykola Tkachenko", "18", Sex.MALE.toString(), Groups.ONE.toString()},
            {"8", "Hlib Kovalchuk", "23", Sex.MALE.toString(), Groups.ONE.toString()},
            {"9", "Denys Petrenko", "24", Sex.MALE.toString(), Groups.TWO.toString()},
            {"10", "Davyd Havrylukk", "19", Sex.MALE.toString(), Groups.TWO.toString()},
            {"11", "Fedir Kuzmenko", "21", Sex.MALE.toString(), Groups.ONE.toString()},
            {"12", "Bohdan Kharchenko", "22", Sex.MALE.toString(), Groups.TWO.toString()},
            {"13", "Ivanna Ponomarenko", "20", Sex.FEMALE.toString(), Groups.TWO.toString()},
            {"14", "Anton Melnychuk", "22", Sex.MALE.toString(), Groups.TWO.toString()},
            {"15", "Matvii Levchenko", "21", Sex.MALE.toString(), Groups.ONE.toString()},
            {"16", "Leonid Pavluk", "20", Sex.MALE.toString(), Groups.TWO.toString()},
            {"17", "Roman Panchenko", "20", Sex.MALE.toString(), Groups.THREE.toString()},
            {"18", "Serhii Lytvynenko", "18", Sex.MALE.toString(), Groups.TWO.toString()},
            {"19", "Ostap Kostiuk", "20", Sex.MALE.toString(), Groups.THREE.toString()},
            {"20", "Kateryna Prykhodko", "21", Sex.FEMALE.toString(), Groups.ONE.toString()},
            {"21", "Pavlo Yakovenko", "20", Sex.MALE.toString(), Groups.THREE.toString()},
            {"22", "Oleksii Honchar", "17", Sex.MALE.toString(), Groups.TWO.toString()},
            {"23", "Danyloy Nazarenko", "20", Sex.MALE.toString(), Groups.ONE.toString()},
            {"24", "Alisa Tyshchenko", "22", Sex.FEMALE.toString(), Groups.THREE.toString()},
            {"25", "Taras Zinchenko", "20", Sex.MALE.toString(), Groups.THREE.toString()},
            {"26", "Vira Fop", "18", Sex.FEMALE.toString(), Groups.THREE.toString()},
            {"27", "Vasyl Shapoval", "22", Sex.MALE.toString(), Groups.THREE.toString()},
            {"28", "Anton Riabokuchma", "19", Sex.MALE.toString(), Groups.ONE.toString()},
            {"29", "Mykola Shulha", "20", Sex.MALE.toString(), Groups.THREE.toString()},

    };

    public String[][] disciplinesOfGroupsArray = {
            {Groups.ONE.toString(), Disciplines.ART.toString(), Disciplines.ARCHITECTURE.toString()},
            {Groups.TWO.toString(), Disciplines.MEDICINE.toString(), Disciplines.CHEMISTRY.toString(),},
            {Groups.THREE.toString(), Disciplines.MATHEMATIC.toString(), Disciplines.PHYSICS.toString(), Disciplines.ENGINEERING.toString()},

    };

    public String[][] getPersonalDataArray() {
        return personalDataArray;
    }

    public String[][] getDisciplinesOfGroupsArray() {
        return disciplinesOfGroupsArray;
    }
}
