public class Main {
    public static void main(String[] args) throws InterruptedException {
        CalcManager calcManager = new CalcManager(10,1000);
        calcManager.startCalculate();
        System.out.println(calcManager.getSimpleDigits());
    }
}
