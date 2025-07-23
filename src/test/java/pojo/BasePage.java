package pojo;

public class BasePage {

    public void waitFor(int seconds, String message) throws InterruptedException {
        Thread.sleep(seconds * 1000);
        System.out.println(message);
    }
}
