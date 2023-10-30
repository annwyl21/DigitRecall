import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;

public class DigitRecall {
    private static final int MAX_ROUNDS = 28;
    /*
     * 'private' means this variable is accessible only within the class it is defined in.
     * 'static' means this variable belongs to the class, not to any specific instance of the class.
     * 'final' indicates that the value of this variable cannot be changed once assigned.
     * 'MAX_ROUNDS' is a constant representing the maximum number of rounds in the game, set to 28.
     */
    public static void main(String[] args){
        // instance of random class
        Random rand = new Random();
        // instance of input capture scanner class
        Scanner scan = new Scanner(System.in);

        // game counter
        int counter = 0;

        // HashMap with increased timings
        HashMap<Integer, Integer> timings = initialiseTimings();
        HashMap<Integer, Integer> range = initialiseRange();

        Boolean gameContinue = true;
        while (gameContinue == true && counter < MAX_ROUNDS) {

            counter++;
            int timingIndex = counter %3;

            //display and capture a random digit
            int digits = (counter/3)+1;
            int num = rand.nextInt(range.get(digits)) +1;

            // print number to screen
            System.out.println(num);
            switch (timingIndex) {
                case 0 -> ScreenWait.waitLoop(timings.get(1));
                case 1 -> ScreenWait.waitLoop(timings.get(2));
                case 2 -> ScreenWait.waitLoop(timings.get(3));
            }

            // remove number from screen using blank lines
            ScreenWait.clearScreen();

            // determine result
            System.out.println("Enter digit");
            // add result
            int recalled = scan.nextInt();

            ScreenWait.waitLoop(500);
            ScreenWait.clearScreen();

            // boolean output
            if (num != recalled){
                gameContinue = false;
            }

        }

        System.out.println("Thank you for playing");
        System.exit(0);

    }

    public static HashMap<Integer, Integer> initialiseTimings(){
        HashMap<Integer, Integer> timings = new HashMap<>();
        timings.put(1, 750);
        timings.put(2, 500);
        timings.put(3, 250);
        return timings;
    }

    public static HashMap<Integer, Integer> initialiseRange(){
        HashMap<Integer, Integer> range = new HashMap<>();
        range.put(1, 10);
        range.put(2, 100);
        range.put(3, 1000);
        range.put(4, 10000);
        range.put(5, 100000);
        range.put(6, 1000000);
        range.put(7, 10000000);
        range.put(8, 100000000);
        range.put(9, 1000000000);
        return range;
    }

}

// NOTES
/* SLEEP
Thread.sleep() can throw an InterruptedException,
which is a checked exception.
Therefore, you either need to catch it or declare your method to throw it.
Sleeping a thread does not guarantee precise timing
due to the nature of scheduling in operating systems.
It will sleep for at least the time specified, but it can be longer.
Using Thread.sleep() in certain contexts, especially in GUI applications,
can lead to undesirable behaviors like freezing the user interface.
Always be cautious and aware of the context in which you're introducing sleep.
 */