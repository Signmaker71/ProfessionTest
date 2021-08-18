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

import static java.lang.Integer.parseInt;

public class FileUtils extends Hash {

    public static void main(String[] args) {
        // try to run some methods
        //System.out.println(upgradeUserEmail("User1RegistrableActive.txt"));

    }


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


    public static String upgradeUserEmail(String fileName){
        String fullText = getFileToString(fileName);
        HashMap<String, String> user = new HashMap<String, String>();
        user = userData(fileName);
        String originalText = user.get("email");
        String newText = incrementEmailAppendix(user.get("email"));
        System.out.println("User email has incremented in file: " + fileName);
        System.out.println("from: "+ originalText);
        System.out.println("to  : "+ newText);
        System.out.print("result: ");
        fullText = fullText.replace(originalText, newText );
        return saveStringToFile(fileName, fullText);
    }

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

    private static String incrementEmailAppendix(String originalEmail) {
        String newEmail = "";
        String[] part2 = originalEmail.split("@");
        String[] part1 = part2[0].split("\\+o");
        int num = Integer.parseInt(part1[1]);
        num++;
        newEmail = part1[0] + "+o" + String.format("%04d", num) + "@" + part2[1];
        return newEmail;
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
