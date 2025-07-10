import java.util.Scanner;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
        public static void main(String[] args) 
        {
            try
            {  
                File file1 = new File("input.txt");
                Scanner scanner = new Scanner(file1);
                File file = new File("HardWords.txt");
                BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

                while(scanner.hasNext())
                {
                    String[] words = scanner.next().split("\\d+");

                    for(String s : words)
                    {
                        writer.write(s);
                        writer.write("\n");
                    }
                }
               

                System.out.println("bruh");
                writer.close();
                scanner.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
}
