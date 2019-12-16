import java.util.List;

public class InvoiceService {

    public static final double FARE_PER_KM = 10;
    private static final double MIN_FARE = 5;
    private static final int COST_PER_MIN = 1;
    RideRepository repository;
    public InvoiceService() {
        this.repository = new RideRepository();
    }

    public double calculateFare(double distance, int time) {
        double totalFare = (distance * FARE_PER_KM) + (time * COST_PER_MIN);
        return Math.max(totalFare, MIN_FARE);
    }

    public InvoiceSummary calculateFare(List<Ride> rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.size(), totalFare);
    }

    public void addRides(String userId, List<Ride> rides) {
        repository.addToUserRideHistory(userId,rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(repository.userRidesHistory.get(userId));
    }

}
