import java.util.List;

public class CalcSimpleDigit extends Thread {
    List<Integer> simpleDigits;
    int calcDigit;

    public CalcSimpleDigit(List<Integer> simpleDigits, int calcDigit) {
        this.simpleDigits = simpleDigits;
        this.calcDigit = calcDigit;
    }

    @Override
    public void run()  {
        boolean isSimple = true;
        for (int i = 2; i < calcDigit; i++) {
            if(isInterrupted()){
                isSimple = false;
                break;
            }
            if (calcDigit % i == 0) {
                isSimple = false;
                break;
            }
        }
        if(isSimple){
            simpleDigits.add(calcDigit);
        }
    }
}
