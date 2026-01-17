package enums;

public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    public String isWeekend(Day day) {
        return day + (day == SATURDAY || day == SUNDAY ? " is weekend." : " is not weekend.");
    }

    public static Day fromString(String dayName) {
        try {
            return  Day.valueOf(dayName.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: '" + dayName + "' is not a valid day. Using MONDAY as default.");
            return  MONDAY;
        }
    }
}
