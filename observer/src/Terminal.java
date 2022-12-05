import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Timer;
import java.util.TimerTask;

public class Terminal implements ITerminal{
    private List<Observer> obList = new ArrayList();
    private ArrayList<Indications> indications = new ArrayList();
    private float pressure;
    private int steamTemperature;
    private int rotationSpeed;

    public Terminal() { }

    public void updateIndications() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new RepeatedTask(), 500, 5000);
    }
    public void generateIndication(){
        pressure = (float) ThreadLocalRandom.current().nextDouble(4.7, 5.6);
        steamTemperature = ThreadLocalRandom.current().nextInt(359, 502 + 1);
        rotationSpeed = ThreadLocalRandom.current().nextInt(2999, 3002 + 1);
        indications.add(new Indications(pressure, steamTemperature, rotationSpeed));
        this.alertObservers();
    }

    @Override
    public void registerObserver(Observer obj) {
        this.obList.add(obj);
    }

    @Override
    public void deleteObserver(Observer obj) {
        this.obList.remove(obj);
    }

    @Override
    public void alertObservers() {
        Iterator var1 = this.obList.iterator();

        while(var1.hasNext()) {
            Observer obj = (Observer)var1.next();
            obj.update(this.indications);
        }
    }

    class RepeatedTask extends TimerTask {
        public void run() {
            generateIndication();
        }
    }
}