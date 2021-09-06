import java.util.ArrayList;
import java.util.List;

public class CalcManager {
    private List<Integer> simpleDigits = new ArrayList<>();

    private List<Thread> runningThreads = new ArrayList<>();

    private int HighBorder;
    private int maxTheads;

    public CalcManager(int maxTheads, int highBorder) {
        this.maxTheads = maxTheads;
        HighBorder = highBorder;
    }

    public void startCalculate(){
        for (int i = 0; i < maxTheads; i++) {

        }
    }
}
