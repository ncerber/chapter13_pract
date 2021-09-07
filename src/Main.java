public class Main {
    public static void main(String[] args) throws InterruptedException {
        CalcManager calcManager = new CalcManager(10,1_00_000);
        calcManager.start();
        CalcInformer calcInformer = new CalcInformer(calcManager,1000);
        calcInformer.startInform();
        System.out.println(calcManager.getSimpleDigits());
    }
}
