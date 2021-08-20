package utils;

import org.junit.runner.Description;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

import static java.lang.Integer.parseInt;

public class FileUtils extends Hash {

    public static void main(String[] args) {
        // try to run some methods
        //System.out.println(upgradeUserEmail("User1RegistrableActive.txt"));

    }


    // change the e-mail in the file
    public static String upgradeUserEmail(String fileName){
        String fullText = getFileToString(fileName);
        HashMap<String, String> user = new HashMap<String, String>();
        user = userData(fileName);

        String originalEmail = user.get("email");
        String newEmail = modifyEmailAppendix(user.get("email"));
        System.out.println("User email has incremented in file: " + fileName);
        System.out.println("from: "+ originalEmail);
        System.out.println("to  : "+ newEmail);
        System.out.print("result: ");
        fullText = fullText.replace(originalEmail, newEmail );
        return saveStringToFile(fileName, fullText);
    }


    // modifying the e-mail address for a new registration
    public static String modifyEmailAppendix(String email) {
        String newEmail = "";
        String[] part2 = email.split("@");
        String[] part1 = part2[0].split("\\+o");

        // newEmail = part1[0] + "+o" + incrementNumericString(part1[2] + "@" + part2[1];
        newEmail = part1[0] + "+o" + generateRandomString() + "@" + part2[1];
        return newEmail;
    }

    // in local environment the numbering of an e-mail address is most better, because
    // at the tester can follow the registrations by the number rart of the e-mail
    // At the Github CI/CD running the file writeing not possible in tge repo, that's why
    // I changed the method which generating a random part in the e-mail address,
    // that is why this incremention method unused
    private static String incrementNumericString(String originalNumber) {
        int num = Integer.parseInt(originalNumber);
        num++;
        return String.format("%04d", num);
    }
private static String generateRandomString() {
    UUID uuid = UUID.randomUUID();

        return uuid.toString().substring(19,23);
    }


    // get user datas to a HashMap variable
    public static HashMap<String, String> userData(String fileName) {
        HashMap<String, String> userData = new HashMap<String, String>();
        try {
            File myUser = new File(fileName);
            Scanner scanner = new Scanner(myUser);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] temp = data.split(" = ");
                userData.put(temp[0], temp[1]);
            }
            scanner.close();
        } catch (
                FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return userData;
    }

    // Input - Output methods

    // Save - Append string to a file
    public static String saveStringToFile(String fileName, String text) {
        try {
            FileWriter textFile = new FileWriter(fileName);
            textFile.append(text);
            textFile.close();
            return "OK";
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    // append to a file method, 2 parameters
    public static String appendToFile(String fileName, String text) {
        try {
            FileWriter textFile = new FileWriter(fileName, true);
            textFile.append(text + "\n");
            textFile.close();
            return "OK";
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    // append to a file method, 3 parameters
    public static String appendToFile(String fileName, String title, String text) {
        try {
            FileWriter textFile = new FileWriter(fileName, true);
            textFile.append(title + " : \n  " + text + "\n");
            textFile.close();
            return "OK";
        } catch (IOException e) {
            return e.getMessage();
        }

    }

    // import whole file to a string
    private static String getFileToString(String fileName) {
        String text = "";
        try {
            File myUser = new File(fileName);
            Scanner scanner = new Scanner(myUser);
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                text += row + "\n";
            }
            scanner.close();
        } catch (
                FileNotFoundException e) {
            System.out.println(e.getMessage());
            text = e.getMessage();
        }
        return text;
    }


    // get the last line from a file
    public static String getLastRecord(String fileName) {
        String result = "";
        try {
            File myUser = new File(fileName);
            Scanner scanner = new Scanner(myUser);
            while (scanner.hasNextLine()) {
                result = scanner.nextLine();
            }
            scanner.close();
        } catch (
                FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    // Reporting Methods

    // generate the Bug report string uses a new ID and other informations from getted parameters
 public static String generateReport(String tcID, String logText) {
        String reportID = "";
        String logId = generateNewID();
        String logDateTime = getLocalDateTime();
        String logNumber;

        logNumber = logDateTime + " " + logId + " " + tcID;
        appendToFile("logIndex.txt", logNumber);
        appendToFile("logRecords.txt", logId, logText);

        return reportID;
    }

    // generate and formatting a new ID by read the last ID and increase it by 1
    private static String generateNewID() {
        String newLogID;
        int newIdNumber;

        String lastLogID = getLastRecord("logIndex.txt").split(" ")[2];
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
