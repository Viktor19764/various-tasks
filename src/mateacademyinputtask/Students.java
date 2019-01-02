package mateacademyinputtask;

import mateacademyinputtask.arraysofvalues.PersonaDataOfStudents;

import java.util.HashMap;
import java.util.Map;

public class Students implements Person {
    //personal data
    private String id;
    private String name;
    private int age;
    private String sex;
    public String group;

    //personal qualities
    private int creativity;
    private int sociability;
    private int cooperateAbility;
    private int initiative;
    private int persistence;
    private int adaptability;
    private int leadership;
    private int culturalAwareness;
    private int rating;

    public Students(String id) {
        PersonaDataOfStudents personaDataOfStudents = new PersonaDataOfStudents();
        this.id = id;
        for (String[] personaDataOfStudent : personaDataOfStudents.getPersonalDataArray()) {
            if (personaDataOfStudent[0].equals(id))
                this.name = personaDataOfStudent[1];
        }
        this.age = age;
        this.sex = sex;
        for (String[] personaDataOfStudent : personaDataOfStudents.getPersonalDataArray()) {
            if (personaDataOfStudent[0].equals(id))
                this.group = personaDataOfStudent[4];
        }
        this.creativity = creativity;
        this.sociability = sociability;
        this.cooperateAbility = cooperateAbility;
        this.initiative = initiative;
        this.persistence = persistence;
        this.adaptability = adaptability;
        this.leadership = leadership;
        this.culturalAwareness = culturalAwareness;
        this.rating = rating;
    }

    public int getCreativity() {
        return creativity;
    }

    public void setCreativity(int creativity) {
        this.creativity += creativity;
    }

    public int getSociability() {
        return sociability;
    }

    public void setSociability(int sociability) {
        this.sociability += sociability;
    }

    public int getCooperateAbility() {
        return cooperateAbility;
    }

    public void setCooperateAbility(int cooperateAbility) {
        this.cooperateAbility += cooperateAbility;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative += initiative;
    }

    public int getPersistence() {
        return persistence;
    }

    public void setPersistence(int persistence) {
        this.persistence += persistence;
    }

    public int getAdaptability() {
        return adaptability;
    }

    public void setAdaptability(int adaptability) {
        this.adaptability += adaptability;
    }

    public int getLeadership() {
        return leadership;
    }

    public void setLeadership(int leadership) {
        this.leadership += leadership;
    }

    public int getCulturalAwareness() {
        return culturalAwareness;
    }

    public void setCulturalAwareness(int culturalAwareness) {
        this.culturalAwareness += culturalAwareness;
    }

    public int getRating() {
        StudentsMethods studentsMethods = new StudentsMethods();
        //StudentsMethods studentsMethods1 = new StudentsMethods();
        int rating = this.rating;
        Map<String, Integer> highScore = new HashMap(studentsMethods.readHighScore());
        if (highScore.size() == 0)
            return rating;
        for (Map.Entry currentId : highScore.entrySet()) {
            if (currentId.getKey().equals(id)) {
                rating = (int) currentId.getValue();
            }
        }
        return rating;
    }

    public void setRating() {
        //this.rating += rating;
        this.rating = creativity + sociability + cooperateAbility + initiative + persistence + adaptability + leadership + culturalAwareness;
    }

    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }
}
