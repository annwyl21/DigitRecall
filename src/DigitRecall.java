import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;

public class DigitRecall {
    public static void main(String[] args){
        // instance of random class
        Random rand = new Random();
        // instance of input capture scanner class
        Scanner scan = new Scanner(System.in);

        // game counter
        int counter = 0;

        // HashMap with increased timings
        HashMap<Integer, Integer> timings = new HashMap<>();
        timings.put(1, 750);
        timings.put(2, 500);
        timings.put(3, 250);

        Boolean gameContinue = true;
        while (gameContinue == true && counter < 28) {

            counter++;
            int waitingtime = counter %3;

            //display and capture a random digit
            int multiplier = (counter/3)+1;
            int range = 10;
            int num = rand.nextInt(range*multiplier) +1;

            // print number to screen
            System.out.println(num);
            switch (waitingtime) {
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
            // convert into a string for comparison
            String stringOfRecalled = "";
            stringOfRecalled += recalled;


            ScreenWait.waitLoop(500);
            ScreenWait.clearScreen();

            // boolean output
            if (num == recalled){
                System.out.println(num == recalled);
            } else {
                gameContinue = false;
            }

        }

        System.out.println("Thank you for playing");
        System.exit(0);

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