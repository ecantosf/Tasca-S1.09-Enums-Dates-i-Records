package dateshours.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateService {

    private static final LocalDateTime BEGINNING_2026 =
            LocalDateTime.of(2026, 1, 1, 0, 0, 0);
    private static final LocalDateTime END_2026 =
            LocalDateTime.of(2026, 12, 31, 23, 59, 59);
    private static final LocalDate BEGINNING_DATE_2026 = BEGINNING_2026.toLocalDate();
    private static final LocalDate END_DATE_2026 = END_2026.toLocalDate();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final LocalDate manOnTheMoon = LocalDate.parse("1969-07-20", formatter);
    private static final LocalDate OLD_DATE = LocalDate.of(2012, 12, 12);
    private static final LocalDate FUTURE_DATE = LocalDate.of(2030, 5, 15);


    public void showCurrentDateTime() {
        LocalDate todayDay = LocalDate.now();
        System.out.println("Today is day: " + todayDay);

        LocalTime todayTime = LocalTime.now();
        System.out.println("Now is time: " + todayTime);

        LocalDateTime todayNow = LocalDateTime.now();
        System.out.println("Today and now is: " + todayNow);
    }

    public void calculateDifferences() {

        System.out.println("Man on the moon for first time: " + this.manOnTheMoon);

        Period period = Period.between(manOnTheMoon,LocalDate.now());
        System.out.printf("%d years, %d months, and %d days ago, ",
                period.getYears(), period.getMonths(), period.getDays());
        System.out.println("Neil Armstrong said «That's one small step for man, one giant leap for mankind.»");
    }

    public long daysFromBeginning2026ToToday() {
        return ChronoUnit.DAYS.between(BEGINNING_DATE_2026, LocalDate.now());
    }

    public long monthsFromBeginning2026ToToday() {
        return ChronoUnit.MONTHS.between(BEGINNING_DATE_2026, LocalDate.now());
    }

    public long hoursFromBeginning2026ToNow() {
        return ChronoUnit.HOURS.between(BEGINNING_2026, LocalDateTime.now());
    }

    public long daysFromTodayToEnd2026() {
        return ChronoUnit.DAYS.between(LocalDate.now(), END_DATE_2026);
    }

    public long monthsFromTodayToEnd2026() {
        return ChronoUnit.MONTHS.between(LocalDate.now(), END_DATE_2026);
    }

    public long hoursFromNowToEnd2026() {
        return ChronoUnit.HOURS.between(LocalDateTime.now(), END_2026);
    }

    public void showAll2026Calculations() {
        System.out.println("From beginning of 2026 to today:");
        System.out.println("  Days: " + daysFromBeginning2026ToToday());
        System.out.println("  Months: " + monthsFromBeginning2026ToToday());
        System.out.println("  Hours: " + hoursFromBeginning2026ToNow());

        System.out.println("\nFrom today to end of 2026:");
        System.out.println("  Days: " + daysFromTodayToEnd2026());
        System.out.println("  Months: " + monthsFromTodayToEnd2026());
        System.out.println("  Hours: " + hoursFromNowToEnd2026());
    }

    private static final DateTimeFormatter DD_MM_YYYY =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static final DateTimeFormatter MM_DD_YYYY =
            DateTimeFormatter.ofPattern("MM/dd/yyyy");

    private static final DateTimeFormatter YYYY_MM_DD =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private static final DateTimeFormatter DD_MM_YYYY_HH_MM_SS =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    private static final DateTimeFormatter EEE_MMM_D_YYYY =
            DateTimeFormatter.ofPattern("EEE, MMM d, yyyy", Locale.ENGLISH);

    private static final DateTimeFormatter D_MMMM_YYYY_CA =
            DateTimeFormatter.ofPattern("d MMMM yyyy", new Locale("ca", "ES"));


    public String formatDDMMYYYY(LocalDate date) {
        return date.format(DD_MM_YYYY);
    }

    public String formatDDMMYYYY(LocalDateTime dateTime) {
        return dateTime.format(DD_MM_YYYY);
    }

    public String formatMMDDYYYY(LocalDate date) {
        return date.format(MM_DD_YYYY);
    }

    public String formatYYYYMMDD(LocalDate date) {
        return date.format(YYYY_MM_DD);
    }

    public String formatDDMMYYYYHHMMSS(LocalDateTime dateTime) {
        return dateTime.format(DD_MM_YYYY_HH_MM_SS);
    }

    public String formatEEEEMMMDYYYY(LocalDate date) {
        return date.format(EEE_MMM_D_YYYY);
    }

    public String formatDMMMMYYYYCatalan(LocalDate date) {
        return date.format(D_MMMM_YYYY_CA);
    }

    public void showAllFormats(LocalDate date) {
        System.out.println("\nShow different formats Date (today):");
        System.out.println("dd/MM/yyyy: " + formatDDMMYYYY(date));
        System.out.println("MM/dd/yyyy: " + formatMMDDYYYY(date));
        System.out.println("yyyy-MM-dd: " + formatYYYYMMDD(date));
    }

    public void showAllFormats(LocalDateTime dateTime) {
        LocalDate datePart = dateTime.toLocalDate();

        System.out.println("dd-MM-yyyy HH:mm:ss: " + formatDDMMYYYYHHMMSS(dateTime));
    }

    public void showFormatsToday() {
        showAllFormats(LocalDate.now());
        showAllFormats(LocalDateTime.now());
    }

    public void isAfterToday() {
        if (OLD_DATE.isAfter(LocalDate.now())) {
            System.out.println(OLD_DATE + " is after " + LocalDate.now());
        } else {
            System.out.println(OLD_DATE + " is before " + LocalDate.now());
        }
    }

    public void isBeforeToday() {
        if (FUTURE_DATE.isBefore(LocalDate.now())) {
            System.out.println(FUTURE_DATE + " is before " + LocalDate.now());
        } else {
            System.out.println(FUTURE_DATE + " is after " + LocalDate.now());
        }
    }



}
