import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

class ReadingFileDemo {

    public static void main(String[] args) {
        try {
            File myObj = new File("C:\\Users\\flori\\Downloads\\dataset_91065.txt");
            Scanner scanner = new Scanner(myObj);
            int count = 0;
          while (scanner.hasNextLine()){
              int number = scanner.nextInt();
              if (number == 0) {
                  break;
              }
              if (number % 2 == 0) {
                  count++;
              }
          }
            System.out.println(count);


        } catch (IOException e) {
            System.out.println("Cannot read file: " + e.getMessage());
        }
    }

}
