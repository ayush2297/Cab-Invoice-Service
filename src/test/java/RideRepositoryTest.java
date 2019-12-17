import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RideRepositoryTest {
    String userId = "abc@.com";
    @Test
    public void givenAList_ShouldGetAddedToRepository() {
        RideRepository rideRepository = new RideRepository();
        List<Ride> listOfRides = new ArrayList<>();
        listOfRides.add(new Ride(2,5, InvoiceService.TypeOfCab.NORMAL));
        listOfRides.add(new Ride(0.1,1, InvoiceService.TypeOfCab.NORMAL));
        for (Ride ride: listOfRides) {
            rideRepository.addToUserRideHistory(userId,ride);
        }
        RideRepository expectedRideRepository = new RideRepository();
        expectedRideRepository.userRidesHistory.put(userId,listOfRides);
        Assert.assertEquals(expectedRideRepository,rideRepository);
    }

    @Test
    public void givenAList_ShouldGetAppendedToRepository() {
        RideRepository rideRepository = new RideRepository();
        List<Ride> listOfRides = new ArrayList<>();
        listOfRides.add(new Ride(2,5, InvoiceService.TypeOfCab.NORMAL));
        listOfRides.add(new Ride(0.1,1, InvoiceService.TypeOfCab.NORMAL));
        for (Ride ride: listOfRides) {
            rideRepository.addToUserRideHistory(userId,ride);
        }
        List<Ride> updatedListOfRides = new ArrayList<>();
        updatedListOfRides.add(new Ride(2,5, InvoiceService.TypeOfCab.NORMAL));
        updatedListOfRides.add(new Ride(0.1,1, InvoiceService.TypeOfCab.NORMAL));
        for (Ride ride: listOfRides) {
            rideRepository.addToUserRideHistory(userId,ride);
        }
        Assert.assertEquals(4,(rideRepository.userRidesHistory.get(userId)).size());
    }
}
