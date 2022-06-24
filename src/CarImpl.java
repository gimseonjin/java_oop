package src;

public abstract class CarImpl implements Car{
    protected static int total_count = 0;
    protected int car_number;
    int price;
    int fuelVolume;
    int currentSpeed;
    boolean isRunning;
    int maxPassenger;
    int currentPassenger;

    public boolean run(int distance){
        for(int i = 0; i < distance; i++){
            if(this.isRunning == false){
                System.out.println("운행중인 상태가 아닙니다.");
                return false;
            }

            if(this.fuelVolume == 0){
                System.out.println("주유량이 0입니다.");
                System.out.println("운행을 종료합니다.");
                this.changeState();
                return false;
            }

            if(this.fuelVolume < 10){
                System.out.println("주유량을 확인해주세요.");
            }

            this.display();

            this.fuelVolume -= 1;
        }
        return true;
    }

    public boolean ridingPassenger(int passenger){
        int overRange = maxPassenger - (this.currentPassenger + passenger);

        if(overRange < 0){
            System.out.println("탑승 가능 인원을 초과했습니다.");
            System.out.println("탑승 초과 인원 : " + Integer.toString(overRange));
            this.currentPassenger = this.maxPassenger ;
            return false;
        }

        if(this.isRunning == false){
            System.out.println("운행중인 상태가 아닙니다.");
            return false;
        }

        this.currentPassenger = this.currentPassenger + passenger;
        return true;
    }

    public boolean changeState(){
        if(this.isRunning == false){
            System.out.println("운행을 시작합니다.");
            this.fuelVolume = 100;
            this.currentSpeed = 30;
        }else{
            if(this.currentPassenger != 0){
                System.out.println("운행을 종료합니다.");
                System.out.println("내린 승객 : " + this.currentPassenger);

                this.currentPassenger = 0;
            }

            System.out.println("운행을 종료합니다..");
            this.currentSpeed = 0;
        }
        this.isRunning = !this.isRunning;
        return true;
    }



    public boolean changeSpeed(int speed){

        if(this.isRunning == false){
            System.out.println("운행중이 아닙니다.");
            this.isRunning = false;
        }

        int changed_speed = this.currentSpeed + speed;
        if(changed_speed > 0){
            this.currentSpeed = changed_speed;
        }else{
            this.currentSpeed = 0;
        }
        return true;
    }

    public static int getTotal_count() {
        return total_count;
    }

    public static void setTotal_count(int total_count) {
        CarImpl.total_count = total_count;
    }

    public int getCar_number() {
        return car_number;
    }

    public void setCar_number(int car_number) {
        this.car_number = car_number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(int fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public int getMaxPassenger() {
        return maxPassenger;
    }

    public void setMaxPassenger(int maxPassenger) {
        this.maxPassenger = maxPassenger;
    }

    public int getCurrentPassenger() {
        return currentPassenger;
    }

    public void setCurrentPassenger(int currentPassenger) {
        this.currentPassenger = currentPassenger;
    }
}
