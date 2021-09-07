import java.util.ArrayList;
import java.util.List;

public class CalcManager {
    private List<Integer> simpleDigits = new ArrayList<>();

    private List<Thread> runningThreads = new ArrayList<>();
    ;

    private int HighBorder;
    private int maxTheads;

    public CalcManager(int maxTheads, int highBorder) {
        this.maxTheads = maxTheads;
        HighBorder = highBorder;
        for (int i = 0; i < maxTheads; i++) {
            runningThreads.add(null);
        }
    }

    public List<Integer> getSimpleDigits() {
        return simpleDigits;
    }

    public void startCalculate() {
        Thread thread;
        int i = 1;
        while (i < HighBorder) {
            for (int j = 0; j < maxTheads; j++) {
                thread = runningThreads.get(j);
                if (thread == null || !thread.isAlive()) {
                    thread = new CalcSimpleDigit(simpleDigits, i);
                    thread.start();
                    i++;
                    runningThreads.set(j, thread);
                }
            }
        }
        for (int j = 0; j < maxTheads; j++) {
            thread = runningThreads.get(j);
            if (thread != null || thread.isAlive()) {
                try {
                    thread.join();
                } catch (InterruptedException e) {

                }
            }
        }
    }

    public void stopAll() throws InterruptedException{
        Thread thread;
        for (int j = 0; j < maxTheads; j++) {
            thread = runningThreads.get(j);
            if (thread != null || thread.isAlive()) {
                thread.interrupt();
                thread.join();
            }
        }
    }
}
