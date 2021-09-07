import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalcInformer {
    CalcManager calcManager;
    int informPeriod;

    public CalcInformer(CalcManager calcManager, int informPeriod) {
        this.calcManager = calcManager;
        this.informPeriod = informPeriod;
    }

    public void startInform() throws InterruptedException{
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss:SS");
        while (calcManager.isAlive()){
            System.out.print(dateFormat.format(calendar.getTime()));
            System.out.print(": Последнее обработаное число: "+calcManager.getCurrentDigit());
            System.out.println("; Найдено простых чисел: "+calcManager.getSimpleDigits().size());

            Thread.sleep(informPeriod);
        }
    }
}
