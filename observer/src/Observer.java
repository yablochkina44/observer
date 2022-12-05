import java.util.ArrayList;

public class Observer implements IObserver {
    private String ObserverID;

    public Observer(String id, Terminal tObservable) {
        this.ObserverID = id;
        tObservable.registerObserver(this);
    }
    @Override
    public void update(ArrayList<Indications> indications) {
        System.out.println("---------------------------------------");
        System.out.println("Обозреватель " + this.ObserverID + " заметил изменение данных с датчиков:");

        Indications item = (Indications) indications.get(indications.size()-1);
        System.out.println("Давление: " + item.GetPressure() + " МПа\n" +
                "Температура пара: " + item.GetSteamTemperature() + " С\n" +
                "Скорость вращения: " + item.GetRotationSpeed()+" об/мин");
        System.out.println("Проверка на критические значения...");
        checkWar(item);
        System.out.println("---------------------------------------");
        //System.out.println();
    }

    private void checkWar(Indications indication){
        if (indication.GetSteamTemperature()<360 || indication.GetSteamTemperature()>500){
            System.out.println("Критическое значение температуры пара!");
        }
        if (indication.GetPressure()<4.8f || indication.GetPressure()>5.5f){
            System.out.println("Критическое значение давления!");
        }
        if (indication.GetRotationSpeed()<2999 || indication.GetRotationSpeed()>3001){
            System.out.println("Критическое значение скорости вращения!");
        }
        if (indication.GetRotationSpeed()>2999 && indication.GetRotationSpeed()<3001 && indication.GetSteamTemperature()>360 && indication.GetSteamTemperature()<500 && indication.GetPressure()>4.8f && indication.GetPressure()<5.5f){
            System.out.println("Все показатели в норме!");
        }
    }
}