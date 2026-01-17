package dateshours.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MenuService {
    private final DateService dateService;
    private final AgendaService agendaService;
    private final Scanner scanner;

    public MenuService() {
        this.dateService = new DateService();
        this.agendaService = new AgendaService();
        this.scanner = new Scanner(System.in);
    }

    public void showMainMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== DATE AND TIME OPERATIONS ===");
            System.out.println("1. Show current date and time");
            System.out.println("2. Calculate time since moon landing");
            System.out.println("3. Calculate time until 2026");
            System.out.println("4. Show today in different formats");
            System.out.println("5. Check if dates are before/after today");
            System.out.println("6. Perform date arithmetic");
            System.out.println("7. Appointment Agenda");
            System.out.println("8. Exit");
            System.out.print("Select an option (1-8): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    showCurrentDateTime();
                    break;
                case 2:
                    calculateTimeSinceMoonLanding();
                    break;
                case 3:
                    showTimeUntil2026();
                    break;
                case 4:
                    showDateFormats();
                    break;
                case 5:
                    checkDateComparisons();
                    break;
                case 6:
                    performDateArithmetic();
                    break;
                case 7:  // <-- NOU (agenda)
                    agendaService.showAgendaMenu();
                    break;
                case 8:  // <-- NOU (exit)
                    exit = true;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private void showCurrentDateTime() {
        System.out.println("\n--- CURRENT DATE AND TIME ---");
        dateService.showCurrentDateTime();
    }

    private void calculateTimeSinceMoonLanding() {
        System.out.println("\n--- TIME SINCE MOON LANDING ---");
        dateService.calculateDifferences();
    }

    private void showTimeUntil2026() {
        System.out.println("\n--- TIME UNTIL 2026 ---");
        dateService.showAll2026Calculations();
    }

    private void showDateFormats() {
        System.out.println("\n--- DATE FORMATS ---");
        System.out.println("1. Show today's date in all formats");
        System.out.println("2. Format a custom date");
        System.out.print("Select option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            dateService.showFormatsToday();
        } else if (choice == 2) {
            System.out.print("Enter date (yyyy-MM-dd): ");
            String dateStr = scanner.nextLine();
            LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ISO_LOCAL_DATE);

            System.out.println("\nFormats for " + dateStr + ":");
            System.out.println("European (dd/MM/yyyy): " + dateService.formatDDMMYYYY(date));
            System.out.println("American (MM/dd/yyyy): " + dateService.formatMMDDYYYY(date));
            System.out.println("ISO (yyyy-MM-dd): " + dateService.formatYYYYMMDD(date));
            System.out.println("English format: " + dateService.formatEEEEMMMDYYYY(date));
            System.out.println("Catalan format: " + dateService.formatDMMMMYYYYCatalan(date));
        }
    }

    private void checkDateComparisons() {
        System.out.println("\n--- DATE COMPARISONS ---");
        dateService.isAfterToday();
        dateService.isBeforeToday();
    }

    private void performDateArithmetic() {
        System.out.println("\n--- DATE ARITHMETIC ---");
        System.out.println("1. Add days to today");
        System.out.println("2. Subtract days from today");
        System.out.println("3. Calculate days between two dates");
        System.out.print("Select option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter number of days to add: ");
                int daysToAdd = scanner.nextInt();
                LocalDate futureDate = LocalDate.now().plusDays(daysToAdd);
                System.out.println("Date after adding " + daysToAdd + " days: " + futureDate);
                break;
            case 2:
                System.out.print("Enter number of days to subtract: ");
                int daysToSubtract = scanner.nextInt();
                LocalDate pastDate = LocalDate.now().minusDays(daysToSubtract);
                System.out.println("Date after subtracting " + daysToSubtract + " days: " + pastDate);
                break;
            case 3:
                System.out.print("Enter first date (yyyy-MM-dd): ");
                String date1Str = scanner.nextLine();
                System.out.print("Enter second date (yyyy-MM-dd): ");
                String date2Str = scanner.nextLine();

                LocalDate date1 = LocalDate.parse(date1Str);
                LocalDate date2 = LocalDate.parse(date2Str);
                long daysBetween = Math.abs(java.time.temporal.ChronoUnit.DAYS.between(date1, date2));
                System.out.println("Days between " + date1Str + " and " + date2Str + ": " + daysBetween);
                break;
        }
    }
}
