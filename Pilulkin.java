package model;

import exceptions.NoSuchClothingException;

public class Pilulkin extends Person implements Watch{

    private boolean glassesOn;
    private int amusementLevel;
    private final Clothes clothes;

    public static final int AMUSEMENT_THRESHOLD_FOR_GLASSES = 2;
    private static final double GLASSES_CHANCE = 0.6;

    public Pilulkin(String name, Clothes clothes) throws NoSuchClothingException {
        super(name);
        this.clothes = clothes;
        this.glassesOn = false;
        this.amusementLevel = 0;
    }

    public boolean isSleeping() {
        return isSleep;
    }

    @Override
    public void wakeUp() {
        if(isSleeping()) {
            isSleep = false;
            this.setCurrentMood(Mood.AWAKE);
            System.out.println(getName() + " проснулся");
        }
    }
    @Override
    public void watchPicture(Picture picture) {
        if(!isSleeping()) {
            if (picture.isFunny()) {
                amusementLevel += 1;
                setCurrentMood(Mood.LAUGH);
                System.out.println(Mood.LAUGH);
            }
            if (!glassesOn && clothes!=null && amusementLevel>= AMUSEMENT_THRESHOLD_FOR_GLASSES) {
                tryPutOnGlassesRandomly();
            }
        }
        else {System.out.println("не может смотреть картины во сне");}
    }
    private void tryPutOnGlassesRandomly(){
        if (isSleeping()) {
            return; // Не может надеть очки во сне
        }
        // Проверяем, есть ли очки и не надеты ли они уже
        if (clothes == null) {
            return;
        }

        if (glassesOn) {
            return; // Очки уже надеты
        }

        // Рандом: решаем, надевать ли очки
        if (Math.random() < GLASSES_CHANCE) {
            putOnGlasses();
        }
    }


        public void putOnGlasses() {
            if (isSleeping()) {
                System.out.println("НЕ может ничего надеть пока спит.");
                glassesOn = false;
            }
            else {
                if (clothes != null) {
                    putOn(clothes);
                    glassesOn = true;
                }
            }
        }

        public void takeOffGlasses() {
            if (glassesOn) {
                glassesOn = false;
                System.out.println(getName() + " снял очки.");
            }
        }
        public int getAmusementLevel() {
            return amusementLevel;
        }

        public boolean hasGlassesOn() {
            return glassesOn;
        }

        public boolean isHighlyAmused() {
            return amusementLevel >= AMUSEMENT_THRESHOLD_FOR_GLASSES;
        }
    }

