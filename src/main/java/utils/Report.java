package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static java.lang.Integer.parseInt;

// Reporting Methods
public class Report {

    // generate the Bug report string uses a new ID and other informations from getted parameters
    public static String generateReport(String tcID, String logText) {
        String reportID = "";
        String logId = generateNewID();
        String logDateTime = getLocalDateTime();
        String logNumber;

        logNumber = logDateTime + " " + logId + " " + tcID;
        FileUtils.appendToFile("logIndex.txt", logNumber);
        FileUtils.appendToFile("logRecords.txt", logId, logText);

        return reportID;
    }

    // generate and formatting a new ID by read the last ID and increase it by 1
    private static String generateNewID() {
        String newLogID;
        int newIdNumber;

        String lastLogID = FileUtils.getLastRecord("logIndex.txt").split(" ")[2];
        lastLogID = lastLogID.replace("BUG", "");
        newIdNumber = parseInt(lastLogID) + 1;
        newLogID = "BUG" + String.format("%04d", newIdNumber);

        return newLogID;
    }

    // gives the actual date and time in a formatted string
    public static String getLocalDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy.MM.dd. HH:mm:ss");
        return now.format(format);

    }
}
