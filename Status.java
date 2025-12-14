package model;

public interface Status {
    Mood getCurrentMood(); // Текущее настроение
    // Методы для работы со сном
    boolean isSleeping(); // Спит ли сейчас?
    void wakeUp(); // Проснуться
    // Метод для вывода сообщения о состоянии сна
    default String getSleepStatusMessage() {
        return isSleeping() ? "is sleeping" : "is awake";
    }
}