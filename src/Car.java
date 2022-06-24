package src;

public interface Car {
    boolean run(int distance);
    boolean changeState();
    boolean ridingPassenger(int passenger);
    boolean changeSpeed(int speed);
    void display();
}
