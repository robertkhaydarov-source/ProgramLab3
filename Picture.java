package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Picture {
    private PictureStyle style;
    private final String name;
    private boolean isHung;

    public Picture(String name, PictureStyle style) {
        this.style = style;
        this.name =name;
        this.isHung=false;
    }
    public void hang() {
        if (isHung) {
            System.out.println("Picture '" + name + "' is already hung.");
            return;
        }
        this.isHung = true;
    }
    public boolean isFunny(){
        return style == PictureStyle.CARICATURE || style == PictureStyle.PORTRAIT;
    }
    public String getName() {
        return name;
    }
    public PictureStyle getStyle() {
        return style;
    }
    public boolean isHung() {
        return isHung;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Picture)) return false;
        Picture picture = (Picture) o;
        return Objects.equals(name, picture.name) && style == picture.style;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, style);
    }
}
