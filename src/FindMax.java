import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
/**
 * Created by Юрий on 30.12.2016.
 */

public class FindMax {

    public static void main(String[] args) throws IOException {

        int count = 0;
        int maxSequence = 0;

        String s = readFile("C:/input.txt");
        String[] arr = s.split("");
        int[] array = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            try {
                array[i] = Integer.parseInt(arr[i]);
            } catch (NumberFormatException nfe) {
                System.out.println(nfe.getMessage());
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                count++;
            } else {
                count = 0;
            }
            if (count > maxSequence) {
                maxSequence = count;
            }
        }
        writeFile(String.valueOf(maxSequence));
    }

    public static String readFile(String file) throws IOException {
        String inputString = "";
        Scanner in = new Scanner(new File(file));
        while (in.hasNext())
            inputString += in.nextLine();
        in.close();
        System.out.println(inputString);
        return inputString;
    }

    private static void writeFile(String maxSequence) {

        try(FileOutputStream fileOutputStream = new FileOutputStream("D:/result.txt"))
        {
            byte[] buffer = maxSequence.getBytes();
            fileOutputStream.write(buffer, 0, buffer.length);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Finished ");
    }
}