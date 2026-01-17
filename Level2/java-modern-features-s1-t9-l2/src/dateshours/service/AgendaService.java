package dateshours.service;

import dateshours.model.Appointment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AgendaService {
    private List<Appointment> appointments;
    private Scanner scanner;
    private DateTimeFormatter formatter;

    public AgendaService() {
        this.appointments = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        initializeSampleAppointments();
    }

    private void initializeSampleAppointments() {
        addAppointment(LocalDateTime.now().plusDays(1).withHour(10).withMinute(0), "Dentist appointment");
        addAppointment(LocalDateTime.now().plusHours(3), "Team meeting");
        addAppointment(LocalDateTime.now().plusDays(7).withHour(18).withMinute(30), "Birthday party");
        addAppointment(LocalDateTime.now().plusDays(3).withHour(14).withMinute(15), "Job interview");
        addAppointment(LocalDateTime.now().minusDays(2).withHour(9).withMinute(0), "Past meeting (example)");
    }

    public void showAgendaMenu() {
        boolean backToMain = false;

        while (!backToMain) {
            System.out.println("\n=== SIMPLE APPOINTMENT AGENDA ===");
            System.out.println("1. Show all appointments");
            System.out.println("2. Show upcoming appointments");
            System.out.println("3. Show next appointment");
            System.out.println("4. Add new appointment");
            System.out.println("5. Back to main menu");
            System.out.print("Select an option (1-5): ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    showAllAppointments();
                    break;
                case 2:
                    showUpcomingAppointments();
                    break;
                case 3:
                    showNextAppointment();
                    break;
                case 4:
                    addNewAppointment();
                    break;
                case 5:
                    backToMain = true;
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void showAllAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments in the agenda.");
            return;
        }

        System.out.println("\n--- ALL APPOINTMENTS (" + appointments.size() + ") ---");
        appointments.sort(Comparator.comparing(Appointment::getDateTime));

        for (int i = 0; i < appointments.size(); i++) {
            Appointment app = appointments.get(i);
            String status = app.isUpcoming() ? "[UPCOMING]" : "[PASSED]";
            System.out.println((i + 1) + ". " + status + " " + app);
        }
    }

    private void showUpcomingAppointments() {
        List<Appointment> upcoming = appointments.stream()
                .filter(Appointment::isUpcoming)
                .sorted(Comparator.comparing(Appointment::getDateTime))
                .collect(Collectors.toList());

        if (upcoming.isEmpty()) {
            System.out.println("No upcoming appointments.");
            return;
        }

        System.out.println("\n--- UPCOMING APPOINTMENTS (" + upcoming.size() + ") ---");
        for (int i = 0; i < upcoming.size(); i++) {
            System.out.println((i + 1) + ". " + upcoming.get(i));
        }
    }

    private void showNextAppointment() {
        List<Appointment> upcoming = appointments.stream()
                .filter(Appointment::isUpcoming)
                .sorted(Comparator.comparing(Appointment::getDateTime))
                .collect(Collectors.toList());

        if (upcoming.isEmpty()) {
            System.out.println("No upcoming appointments.");
            return;
        }

        System.out.println("\n--- NEXT APPOINTMENT ---");
        System.out.println(upcoming.get(0));

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextAppointment = upcoming.get(0).getDateTime();

        long days = java.time.temporal.ChronoUnit.DAYS.between(now, nextAppointment);
        long hours = java.time.temporal.ChronoUnit.HOURS.between(now, nextAppointment) % 24;

        System.out.printf("Time until appointment: %d days and %d hours%n", days, hours);
    }

    private void addNewAppointment() {
        try {
            System.out.print("\nEnter date and time (yyyy-MM-dd HH:mm): ");
            String dateTimeStr = scanner.nextLine();

            System.out.print("Enter appointment description: ");
            String description = scanner.nextLine();

            LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);
            addAppointment(dateTime, description);

            System.out.println("✓ Appointment added successfully!");

        } catch (DateTimeParseException e) {
            System.out.println("✗ Error: Invalid date/time format. Please use yyyy-MM-dd HH:mm");
            System.out.println("Example: 2024-12-25 14:30");
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    private void addAppointment(LocalDateTime dateTime, String description) {
        appointments.add(new Appointment(dateTime, description));
        appointments.sort(Comparator.comparing(Appointment::getDateTime));
    }

    private int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}