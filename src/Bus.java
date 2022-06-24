package src;

public class Bus extends CarImpl {

    private Bus(){
        this.car_number = total_count;
        super.total_count += 1;
    }

    public static Bus build(int startFuelVolume, int price){
        Bus bus = new Bus();

        bus.setMaxPassenger(45);
        
        bus.setRunning(true);

        bus.setFuelVolume(startFuelVolume);

        bus.setPrice(price);

        bus.setCurrentSpeed(30);

        bus.setCurrentPassenger(0);

        return bus;
    }

    public void display() {
        System.out.println("=========버스 정보=========");
        System.out.println("버스 번호 : " + this.car_number);
        System.out.println("탑승 인원 : " + this.currentPassenger);
        System.out.println("현재 속도 : " + this.currentSpeed);
        if(this.isRunning){
            System.out.println("버스 상태 : 운행 중");
        }else{
            System.out.println("버스 상태 : 차고지행");
        }
        System.out.println("연료 상황 : " + this.fuelVolume);
        System.out.println("========================");
    }
}
