package model;

import java.awt.*;
import java.util.LinkedList;
import java.util.Objects;

public abstract class Person implements Status {
    private String name;
    private Mood currentMood;
    protected boolean isSleep;
    public Person(String name){
        this.name = name;
        this.currentMood = Mood.NEUTRAL;
        isSleep = true;
    }
    public String getName() {
        return name;
    }
    @Override
    public void wakeUp() {
        if (isSleeping()) {
            isSleep = false;
            this.currentMood = Mood.AWAKE;
            System.out.println(name + " проснулся");
        }
    }
    @Override
    public Mood getCurrentMood() {
        return currentMood;
    }

    public boolean isSleeping() {
        return isSleep;
    }
    public void putOn(Clothes clothes){
        System.out.println(name + " надел " + clothes.description());
    }
    public void setCurrentMood(Mood mood) {
        if (!isSleep) {
            this.currentMood = mood;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{name='" + name +
                "', sleeping=" + isSleeping() +
                ", mood=" + currentMood + "}";
    }
}


