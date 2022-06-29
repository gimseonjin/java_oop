package src;

public abstract class CarImpl implements Car{
    protected static int total_count = 0;
    protected int car_number;
    protected int price;
    protected int fuelVolume;
    protected int currentSpeed;
    protected boolean isRunning;
    protected int maxPassenger;
    protected int currentPassenger;

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

        int changed_speed = speed;

        if(changed_speed > 0){
            this.currentSpeed = changed_speed;
        }else{
            this.currentSpeed = 0;
        }

        return true;
    }
}
