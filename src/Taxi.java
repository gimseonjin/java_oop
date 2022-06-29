package src;

public class Taxi extends CarImpl {

    int defaultDistance;
    int pricePerDistance;
    int destination;

    private Taxi(){
        this.car_number = total_count;
        super.total_count += 1;
    }

    public static Taxi build(int startFuelVolume, int price, int pricePerDistance, int defaultDistance){
        Taxi taxi = new Taxi();

        taxi.isRunning = true;

        taxi.maxPassenger = 4;

        taxi.price = price;

        taxi.fuelVolume = startFuelVolume;

        taxi.currentSpeed = 60;

        taxi.pricePerDistance = pricePerDistance;

        taxi.defaultDistance = defaultDistance;

        return taxi;
    }

    @Override
    public boolean run(int destination) {

        this.destination = destination;

        if(this.fuelVolume < 10){
            System.out.println("연료가 부족합니다.");
            return false;
        }

        if(this.fuelVolume < this.destination){
            System.out.println("목적지까지 갈 수 있는 연료가 부족합니다.");
            return false;
        }

        super.run(this.destination);

        this.calculate();

        return true;
    }

    private int countPricePerDistance(int distance){
        int fee = distance * this.price;;
        int over_distance = distance - this.defaultDistance;

        if(over_distance > 0){
            fee += this.pricePerDistance * over_distance;
        }

        return fee;
    }

    public void calculate(){

        int fee = countPricePerDistance(this.defaultDistance);

        this.destination = 0;
        this.changeState();

        System.out.println("요금이 부과됐습니다.");
        System.out.println("부과된 요금 : " + fee);

    }


    @Override
    public void display() {
        System.out.println("=========택시 정보=========");
        System.out.println("택시 번호 : " + this.car_number);
        System.out.println("탑승 인원 : " + this.currentPassenger);
        System.out.println("현재 속도 : " + this.currentSpeed);
        if(this.isRunning){
            System.out.println("택시 상태 : 운행 중");
        }else{
            System.out.println("택시 상태 : 일반 상태");
        }
        System.out.println("연료 상황 : " + this.fuelVolume);
        System.out.println("========================");

    }
}
