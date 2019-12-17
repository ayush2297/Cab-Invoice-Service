
public abstract class CabServiceAdapter {

    public abstract double calculateFare(Ride ride);

    protected double calculateFare(double farePerKm, int costPerMin, double minFare,double distance, int time) {
        double totalFare = (distance * farePerKm) + (time * costPerMin);
        return Math.max(totalFare, minFare);
    }

}
