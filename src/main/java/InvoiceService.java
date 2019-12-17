import java.util.List;

public class InvoiceService {
    CabServiceEssentials cabService;

    public enum TypeOfCab{
        PREMIUM,NORMAL
    }

    public InvoiceService() {
        this.cabService = new CabServiceEssentials();
    }

    public InvoiceSummary calculateFare(List<Ride> rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.getFareOfThisRide(ride);
        }
        return new InvoiceSummary(rides.size(), totalFare);
    }

    public double getFareOfThisRide(Ride ride) {
        CabServiceAdapter cabServiceAdapter = cabService.fareCalculator.get(ride.cabType);
        return cabServiceAdapter.calculateFare(ride);
    }

    public void addRides(String userId, List<Ride> rides) {
        for (Ride ride: rides) {
            cabService.repository.addToUserRideHistory(userId,ride);
        }
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(cabService.repository.userRidesHistory.get(userId));
    }

}
