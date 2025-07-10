import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;
import java.io.File;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Random;

class MorseCodeVisualTest {
    static int timeunit = 500;
    static long speed = 1;
    public static void main(String[] args) throws Exception
    {
        Random rand = new Random();
        boolean hardmode = false;

        String decode = "STEALFTH";
        Dictionary<String, String> dictionary = new Hashtable<>();
        File file = new File("MorseKey.txt");
        
        ArrayList<String> easywords = new ArrayList<>();
        ArrayList<String> hardwords = new ArrayList<>();

        File easy = new File("EasyWords.txt");
        File hard = new File("HardWords.txt");
        Scanner easyscanner = new Scanner(easy);
        Scanner hardscanner = new Scanner(hard);
        while(easyscanner.hasNext())
        {
            easywords.add(easyscanner.nextLine());
        }
        while(hardscanner.hasNext())
        {
            hardwords.add(hardscanner.nextLine());
        }

        Scanner keyScanner = new Scanner(file);
        while(keyScanner.hasNext())
        {
            String key = "";
            key = keyScanner.next();
            dictionary.put(key, keyScanner.next());
        }
        Scanner scanner = new Scanner(System.in);
        easyscanner.close();
        hardscanner.close();
        keyScanner.close();
        int repetitions = 0;
        int correct = 0;
        boolean a = true;

        System.out.println("Hard Mode? (Y/N)");
        if(scanner.nextLine().equals("Y"))
        {
            hardmode = true;
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();

        while(a)
        {

        repetitions++;
        if(!hardmode)
        {
            decode = easywords.get(rand.nextInt(easywords.size()));
        }
        else 
        {
            decode = hardwords.get(rand.nextInt(hardwords.size()));
        }
    
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
        
        System.out.println("What was the word communicated?");
        String answer = scanner.nextLine();
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        answer = answer.toLowerCase();
        if(answer.equals(decode))
        {
            System.out.println("Well done.");
            correct++;
        }
        else 
        {   
            System.out.println("You are stupid, it was " + decode + ", not " + answer + ".");
        }

        System.out.println("Score: " + correct + " for " + repetitions + ".");
        System.out.println("Try again? (Y/N)");
        if(scanner.nextLine().equals("N"))
        {
            a = false;
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    scanner.close();
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
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        delay(units);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        delay(1);
    }
}
