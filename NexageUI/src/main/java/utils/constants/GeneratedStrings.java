package utils.constants;

public enum GeneratedStrings {

    UPPER_LAT_CHARS("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
    LOWER_LAT_CHARS("abcdefghijklmnopqrstuvwxyz"),
    NUMBERS ("0123456789");

    private final String generatedStrings;

    GeneratedStrings(String generatedStrings) {
        this.generatedStrings = generatedStrings;
    }

    public String getGeneratedStrings() {
        return generatedStrings;
    }
}
