package main;

import model.*;
import exceptions.NoSuchClothingException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            // 1. СОЗДАНИЕ ОБЪЕКТОВ
            ArrayList<Picture> allPictures = new ArrayList<>();
            allPictures.add(new Picture("Portrait of Znayka", PictureStyle.PORTRAIT));
            allPictures.add(new Picture("Caricature of Vintik", PictureStyle.CARICATURE));
            allPictures.add(new Picture("Mountain Landscape", PictureStyle.LANDSCAPE));
            allPictures.add(new Picture("Abstract Composition", PictureStyle.CARICATURE));
            allPictures.add(new Picture("Comic Strip", PictureStyle.PORTRAIT));

            Dunno dunno = new Dunno("Незнайка");
            Pilulkin pilukha;

            try {
                // Вариант A: Нормальное создание очков
                Clothes glasses = Clothes.createClothes("glasses", "пенсне"); // ← МОЖЕТ выбросить исключение

                // Вариант B: Создание с проблемой (для демонстрации)
                // Clothes glasses = Clothes.createClothes("", "test"); // ← ВЫБРОСИТ исключение
                // Clothes glasses = Clothes.createClothes(null, "test"); // ← ВЫБРОСИТ исключение

                pilukha = new Pilulkin("Доктор Пилюлькин", glasses);
                System.out.println("✓ Dr. Pilulkin создан с очками.");

            } catch (NoSuchClothingException e) {
                // НАШЕ исключение сработало!
                System.out.println("✗ " + e.getMessage()); // Только сообщение из исключения

                // Создаём без очков
                pilukha = new Pilulkin("Доктор Пилюлькин", null);
                System.out.println("Dr. Pilulkin будет без очков.");
            }

            // 2. СОЗДАНИЕ ВЫСТАВКИ
            dunno.isSleeping();
            List<Picture> exhibition = dunno.hangPicture(allPictures);

            // 3. ПРОСМОТР
            pilukha.wakeUp();
            System.out.println("\nУвидел на стене картины:");
            for (Picture picture : exhibition) {
                System.out.println("\nСмотрит на: " + picture.getName());
                pilukha.watchPicture(picture);
            }
          // Случай 2: Пустая строка (ВЫБРОСИТ NoSuchClothingException)
            System.out.println("\n2. Создание с пустым типом:");
            try {
                Clothes empty = Clothes.createClothes("", "test");
                System.out.println("   Создано: " + empty.type());
            } catch (NoSuchClothingException e) {
                System.out.println("   Наше исключение: " + e.getMessage());
            }

            // Случай 3: Null (ВЫБРОСИТ NoSuchClothingException)
            System.out.println("\n3. Создание с null типом:");
            try {
                Clothes nullClothes = Clothes.createClothes(null, "test");
                System.out.println("   Создано: " + nullClothes.type());
            } catch (NoSuchClothingException e) {
                System.out.println("   Наше исключение: " + e.getMessage());
            }

            // Случай 4: IllegalArgumentException из record (другое исключение)
            System.out.println("\n4. Прямое создание record с ошибкой:");
            try {
                Clothes direct = new Clothes("", "test");
                System.out.println("   Создано: " + direct.type());
            } catch (IllegalArgumentException e) {
                System.out.println("   IllegalArgumentException: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}