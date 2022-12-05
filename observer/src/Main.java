import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {

        Terminal terminalObservable = new Terminal();
        new Observer("01", terminalObservable);;
        terminalObservable.updateIndications();


    }
}
