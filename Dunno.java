package model;

import java.util.ArrayList;
import java.util.List;

public class Dunno extends Person implements Watch{
    private final List<Picture> hungPictures;
    public Dunno(String name){
        super(name);
        wakeUp();
        this.hungPictures= new ArrayList<>();
    }
    public void wakeUp() {
        if (isSleeping()) {
            isSleep = false;
            this.setCurrentMood(Mood.AWAKE);
            System.out.println(getName() + " проснулся");
        }
    }
    public  boolean isSleeping() {
        return isSleep;
    }

    public List<Picture> hangPicture(List<Picture> pictures){
        if(isSleeping()){
            return new ArrayList<>();
        }
        hungPictures.clear();
        System.out.println(getName() + " начинает вешать на стену " + pictures.size() + " картин:");

        for (Picture picture : pictures) {
            picture.hang();
            hungPictures.add(picture);
            System.out.println("  ✓ " + picture.getName());
        }

        System.out.println(getName() + " развесил все картины");
        return new ArrayList<>(hungPictures);
    }
    @Override
    public void watchPicture(Picture picture) {}
}
