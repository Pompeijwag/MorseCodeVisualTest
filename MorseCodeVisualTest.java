import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;
import java.io.File;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Random;

class MorseCodeVisualTest {
    static int timeunit = 500;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception
    {
        Random rand = new Random();
        boolean hardmode = false;

        String decode = "";
        Dictionary<String, String> dictionary = new Hashtable<>();
        ArrayList<String> easywords = new ArrayList<>();
        ArrayList<String> hardwords = new ArrayList<>();
        File file = new File("MorseKey.txt");
        File easy = new File("EasyWords.txt");
        File hard = new File("HardWords.txt");
        

        Scanner easyscanner = new Scanner(easy);
        Scanner hardscanner = new Scanner(hard);
        Scanner keyScanner = new Scanner(file);

        while(easyscanner.hasNext())
        {
            easywords.add(easyscanner.nextLine());
        }
        while(hardscanner.hasNext())
        {
            hardwords.add(hardscanner.nextLine());
        }
        while(keyScanner.hasNext())
        {
            String key = "";
            key = keyScanner.next();
            dictionary.put(key, keyScanner.next());
        }

        easyscanner.close();
        hardscanner.close();
        keyScanner.close();

        int repetitions = 0;
        int correct = 0;
        boolean cont = true;

        System.out.println("Hard Mode? (Y/N)");
        if(scanner.nextLine().toUpperCase().equals("Y"))
        {
            hardmode = true;
        }
        clear();

        changeSpeed();

        while(cont)
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
        clear();
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
            delay(3);
        }
        
        System.out.println("What was the word communicated?");
        String answer = scanner.nextLine();
        
        clear();
        
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
        System.out.println("Try again? (Y/N), Change speed (C)");
        String command = scanner.nextLine().toUpperCase();
        if(command.equals("N"))
        {
            cont = false;
        }
        else if(command.equals("C"))
        {
            changeSpeed();
        }
        clear();
    }

    scanner.close();
    }
    public static void delay(int units)
    {
        try
        {
          Thread.sleep(units * timeunit);
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }

    public static void blink(int units)
    {
        clear();
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        delay(units);
        clear();
        delay(1);
    }
    
    public static void changeSpeed()
    {
        clear();
        System.err.println("Set speed: (Default = 500ms)");
        timeunit = Integer.parseInt(scanner.nextLine());
    }

    public static void clear()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
