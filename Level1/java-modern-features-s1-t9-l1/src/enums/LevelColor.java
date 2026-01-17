package enums;

public enum LevelColor {
    LOW ("Red"),
    MEDIUM ("Yellow"),
    HIGH ("Green");

    private final String color;

    LevelColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }
}
