public class ScreenWait {
    public static void main(String[] args) {

    }

    public static void waitLoop(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
