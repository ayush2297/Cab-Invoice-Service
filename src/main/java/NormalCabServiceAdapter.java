public class NormalCabServiceAdapter extends CabServiceAdapter {

    public static final double FARE_PER_KM = 10;
    private static final double MIN_FARE = 5;
    private static final int COST_PER_MIN = 1;

    @Override
    public double calculateFare(Ride ride) {
        return super.calculateFare(FARE_PER_KM,COST_PER_MIN,MIN_FARE,ride.distance,ride.time);
    }
}
