public class Indications {
    private float pressure;
    private int steamTemperature;
    private int rotationSpeed;

    public Indications(float p,int t,int r){
        this.pressure=p;
        this.steamTemperature =t;
        this.rotationSpeed =r;
    }

    public float GetPressure(){
        return pressure;
    }
    public int GetSteamTemperature(){
        return steamTemperature;
    }
    public int GetRotationSpeed(){
        return rotationSpeed;
    }
}
