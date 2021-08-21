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
    // CONSTANSES
    // PROPERTIES
    // CONSTRUCTOR


    // METHODS
    public static void main(String[] args) {
        // try to run some methods
        //System.out.println(upgradeUserEmail("User1RegistrableActive.txt"));
        System.out.println(getFileToString("phoneNumbers.txt"));
        String[] rows = getFileToStringArray("phoneNumbers.txt");
        for (String row : rows) {
            System.out.println(row);
        }
    }


    // change the e-mail in the file
    // it does not work on the CI/CD because the file cannot be written back to the repo
    public static String upgradeUserEmail(String fileName, String newEmail) {
        String fullText = getFileToString(fileName);
        HashMap<String, String> user = new HashMap<String, String>();
        user = userData(fileName);

        String originalEmail = user.get("email");
        //String newEmail = modifyEmailAppendix(user.get("email"));
        System.out.println("User email has incremented in file: " + fileName);
        System.out.println("from: " + originalEmail);
        System.out.println("to  : " + newEmail);
        System.out.print("result: ");
        fullText = fullText.replace(originalEmail, newEmail);
        return saveStringToFile(fileName, fullText);
    }


    // modifying the e-mail address for a new registration

    // in local environment the numbering of an e-mail address is most better, because
    // at the tester can follow the registrations by the number rart of the e-mail
    // At the Github CI/CD running the file writeing not possible in tge repo, that's why
    // I changed the method which generating a random part in the e-mail address,
    // that is why this incremention method unused
    public static String modifyEmailAppendix(String email) {
        String newEmail = "";
        String[] part2 = email.split("@");
        String[] part1 = part2[0].split("\\+o");

        // newEmail = part1[0] + "+o" + incrementNumericString(part1[2] + "@" + part2[1];
        newEmail = part1[0] + "+o" + Methods.generateRandomString() + "@" + part2[1];
        return newEmail;
    }


    // Input - Output methods

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


    // get file rows to a String Array
    public static String[] getFileToStringArray(String fileName) {
        String[] text = getFileToString(fileName).split("\n");
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


    // get user datas from a file to a HashMap variable
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

    // append a string to a file , by 2 parameters
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


    // append a string to a file , by 3 parameters
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
}
