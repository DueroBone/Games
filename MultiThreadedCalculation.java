import java.util.ArrayList;

class CalculationThread extends Thread {
    private int number;
    public double FinalResult = 0;

    public CalculationThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        // Perform the calculation (e.g., square the number)
        double result = 0;
        for (int j = 0; j < 1; j++) {
            for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
                result *= i;
            }
        }
        result = number;

        // Save the result in the shared data structure (ArrayList)
        // synchronized (results) {
        // results.add(result);
        // }

        System.out.println("Thread " + Thread.currentThread().getName() + ": Finished");
        FinalResult = result;
    }
}

public class MultiThreadedCalculation {
    public static void main(String[] args) {
        // Number of threads to create
        int numThreads = 15;

        // Shared data structure to store results
        ArrayList<Double> results = new ArrayList<>();
        ArrayList<Thread> threads = new ArrayList<>();

        // Create and start multiple threads
        for (int i = 1; i <= numThreads; i++) {
            CalculationThread thread = new CalculationThread(i);
            thread.setName("Thread #" + i);
            thread.start();
            threads.add(thread);
        }

        // Wait for all threads to finish
        try {
            for (Thread thread : threads) {
                if (thread != Thread.currentThread()) {
                    thread.join();
                    results.add(((CalculationThread) thread).FinalResult);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display the results
        System.out.println("Results: " + results);
    }
}
