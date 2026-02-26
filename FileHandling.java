import java.io.*;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) {

        int lines = 0;
        int words = 0;

        try {
            File f = new File("input.txt");
            Scanner sc = new Scanner(f);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                lines++;

                String[] w = line.split(" ");
                words = words + w.length;
            }

            sc.close();

            FileWriter fw = new FileWriter("output.txt");
            fw.write("Line count: " + lines + "\n");
            fw.write("Word count: " + words);
            fw.close();

            System.out.println("Done");

        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
