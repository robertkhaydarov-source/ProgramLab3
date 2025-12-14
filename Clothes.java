package model;

import exceptions.NoSuchClothingException;

public record Clothes(String type, String description) {
    public Clothes {
        // Валидация в компактном конструкторе record
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Clothing type is required");
        }
    }

    // Фабричный метод, который бросает НАШЕ исключение
    public static Clothes createClothes(String type, String description)
            throws NoSuchClothingException {

        // Проверяем на null/пустоту - если проблема, бросаем НАШЕ исключение
        if (type == null || type.trim().isEmpty()) {
            throw new NoSuchClothingException(type == null ? "null" : "empty");
        }

        // Если проверка прошла - создаём record
        return new Clothes(type, description);
    }
    // Проверка, действительна ли одежда
    public boolean isValid() {
        return type != null && !type.isEmpty();
    }

    @Override
    public String toString() {
        return type.isEmpty() ? "invalid clothing" : type;
    }
}

