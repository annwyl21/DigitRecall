import java.util.Random;
import java.util.Scanner;

public class DigitRecall {
    public static void main(String[] args){
        // instance of random class
        Random rand = new Random();
        // instance of input capture scanner class
        Scanner scan = new Scanner(System.in);

        //display and capture a random digit
        int num = rand.nextInt(10)+1;
        String listOfNums = "";
        listOfNums += num;

        // PLAN
// increase the length of time the sleep operate
// increase the numbers required to recall
        try {
            System.out.println(num);
            Thread.sleep(250); // see notes on SLEEP

            // remove number from screen using blank lines
            // clear screen and \r to overwrite the previous print did not work
            for (int i=0; i<50; i++){
                System.out.println();
            }

            // prompt user to type number
            System.out.println("Type number/s:");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // determine result
        int recalled = scan.nextInt();
        String listOfRecalled = "";
        listOfRecalled += recalled;
        // boolean output
        System.out.println(listOfRecalled.equals(listOfNums));

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