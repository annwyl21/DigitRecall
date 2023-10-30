public class ScreenWait {

    public static void waitLoop(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clearScreen(){
        // clear screen and \r to overwrite the previous print did not work
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
