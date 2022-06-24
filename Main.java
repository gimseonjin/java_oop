import src.Bus;
import src.Car;
import src.Taxi;

public class Main {
    public static void main(String[] args){
        Taxi taxi = Taxi.build(30,1000,500,10);

        taxi.ridingPassenger(3);
        taxi.run(3);
        taxi.ridingPassenger(0);
        taxi.calculate();

        taxi.display();
    }
}
