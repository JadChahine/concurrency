package concurrency.executorServiceBasics;

// PrintTask class sleeps for a random time from 0 to 5 seconds
import java.security.SecureRandom;

public class PrintTask implements Runnable {
    private static final SecureRandom generator = new SecureRandom();
    private final int sleepTime; // random sleep time for thread
    private final String taskName;

    // constructor
    public PrintTask(String taskName) {
        this.taskName = taskName;

        System.out.println(taskName + " started");

        // pick random sleep time between 0 and 5 seconds
        sleepTime = generator.nextInt(5000); // milliseconds
    }

    // method run contains the code that a thread will execute
    @Override
    public void run() {
        try { // put thread to sleep for sleepTime amount of time
            System.out.printf("%s going to sleep for %d milliseconds.%n",
                    taskName, sleepTime);
            Thread.sleep(sleepTime); // put thread to sleep

            System.out.println(taskName + " slept done");
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

    }
}