import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;
import java.io.File;
import java.lang.Thread;

class MorseCodeVisualTest {
    static int timeunit = 500;
    static int speed = 1;
    public static void main(String[] args) throws Exception
    {
        String decode = "STEALFTH";
        Dictionary<String, String> dictionary = new Hashtable<>();
        File file = new File("MorseKey.txt");
        Scanner keyScanner = new Scanner(file);
        while(keyScanner.hasNext())
        {
            String key = "";
            key = keyScanner.next();
            dictionary.put(key, keyScanner.next());
        }
        Scanner scanner = new Scanner(System.in);
        

        System.out.println("hello world");
        
        System.out.println("Ready?");
        scanner.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        delay(5);
        
        String[] splitting = decode.split("");
        for(int i = 0; i < splitting.length; i++)
        {
            String[] letter = dictionary.get(splitting[i]).split("");
            for(int ii = 0; ii < letter.length; ii++)
            {
                if(letter[ii].equals("."))
                {
                    blink(1);
                }
                else
                {
                    blink(3);
                }
            }
            delay(2);
        }
    }

    public static void delay(int units)
    {
        try
        {
          Thread.sleep(units * timeunit / speed);
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }

    public static void blink(int units)
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX ");
        delay(units);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        delay(1);
    }
}
