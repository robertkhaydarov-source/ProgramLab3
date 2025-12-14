package exceptions;

public class NoSuchClothingException extends Exception {
    private final String clothingType;

    public NoSuchClothingException(String clothingType) {
        super("Clothing not found: " + clothingType);
        this.clothingType = clothingType;
    }

    @Override
    public String getMessage() {
        return "Cannot find clothing: " + clothingType;
    }

    public String getClothingType() {
        return clothingType;
    }
}