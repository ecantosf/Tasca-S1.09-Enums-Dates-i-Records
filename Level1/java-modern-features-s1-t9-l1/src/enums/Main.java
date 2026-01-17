package enums;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nEXERCISE 1:");

        Day dayToCheck1 = Day.SUNDAY;
        Day dayToCheck2 = Day.TUESDAY;

        String message1 = dayToCheck1.isWeekend(dayToCheck1);
        String message2 = dayToCheck2.isWeekend(dayToCheck2);

        System.out.println("Is it Weekend?: " + message1);
        System.out.println("Is it Weekend?: " + message2);


        System.out.println("\nEXERCISE 2:");

        System.out.println("\nTask Management System");

        Task task1 = new Task("Update documentation", Level.LOW,
                "Update user manual for new features");

        Task task2 = new Task("Fix login bug", Level.MEDIUM,
                "Users cannot login with correct credentials");

        Task task3 = new Task("Server outage", Level.HIGH,
                "Production server is down, affecting all users");

        task1.processTask();
        task2.processTask();
        task3.processTask();

        System.out.println("\nEXERCISE 3:");

        LevelColor low = LevelColor.LOW;
        LevelColor medium = LevelColor.MEDIUM;
        LevelColor high = LevelColor.HIGH;

        System.out.println("Low level color: " + low.getColor());
        System.out.println("Medium level color: " + medium.getColor());
        System.out.println("High level color: " + high.getColor());


        System.out.println("\nEXERCISE 4:");

        String[] testInputs = {"monday", "TUESDAY", "INVALID", "saturday", "Funday"};

        for (String input : testInputs) {
            Day day = Day.fromString(input);
            System.out.println("   '" + input + "' -> " + day);
        }
    }
}
