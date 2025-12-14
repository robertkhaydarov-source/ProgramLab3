package model;
public enum Mood {
    SLEEPY("Спящий"),
    AWAKE("Проснувшийся"),
    SERIOUS("Серьезный"),
    NEUTRAL("Нейтральный"),
    LAUGH("Cмеется");
    private final String displayName;

    Mood(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
