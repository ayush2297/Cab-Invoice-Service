
public class PremiumCabServiceAdapter extends CabServiceAdapter {

    public static final double FARE_PER_KM = 25;
    private static final double MIN_FARE = 15;
    private static final int COST_PER_MIN = 2;

    @Override
    public double calculateFare(Ride ride) {
        return super.calculateFare(FARE_PER_KM,COST_PER_MIN,MIN_FARE,ride.distance,ride.time);
    }
}
