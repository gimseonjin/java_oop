import src.Bus;
import src.Taxi;

public class Main {
    public static void main(String[] args){

        Taxi taxi = Taxi.build(30,1000,500,10);

        Bus bus = Bus.build(10,1900);

        System.out.println("=================TAXI========================");
        taxi.changeSpeed(0);
        taxi.ridingPassenger(4);
        taxi.changeSpeed(60);
        taxi.run(5);

        System.out.println("=================BUS========================");
        taxi.changeSpeed(0);
        bus.ridingPassenger(5);
        bus.changeSpeed(30);
        bus.run(5);
    }
}
