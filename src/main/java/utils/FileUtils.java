package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class FileUtils extends Hash{
    public HashMap<String, String> userData(String filename) {
        HashMap<String, String> userData = new HashMap<String, String>();
        try {
            File myUser = new File(filename);
            Scanner scanner = new Scanner(myUser);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] temp = data.split(" = ");
                userData.put(temp[0], temp[1]);
            }
        } catch (
                FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return userData;
    }


    public String writeToFile(String fileName, String title, String paragraph) {
        try {
            FileWriter textFile = new FileWriter(fileName);

            textFile.append(title + " : \n  " + paragraph + "\n");

            textFile.close();
            return null;
        } catch (IOException e) {
            return e.getMessage();
        }

    }


}
