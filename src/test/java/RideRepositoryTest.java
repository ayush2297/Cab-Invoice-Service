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
        listOfRides.add(new Ride(2,5));
        listOfRides.add(new Ride(0.1,1));
        rideRepository.addToUserRideHistory(userId,listOfRides);
        RideRepository expectedRideRepository = new RideRepository();
        expectedRideRepository.userRidesHistory.put(userId,listOfRides);
        Assert.assertEquals(expectedRideRepository,rideRepository);
    }

    @Test
    public void givenAList_ShouldGetAppendedToRepository() {
        RideRepository rideRepository = new RideRepository();
        List<Ride> listOfRides = new ArrayList<>();
        listOfRides.add(new Ride(2,5));
        listOfRides.add(new Ride(0.1,1));
        rideRepository.addToUserRideHistory(userId,listOfRides);
        List<Ride> updatedListOfRides = new ArrayList<>();
        updatedListOfRides.add(new Ride(2,5));
        updatedListOfRides.add(new Ride(0.1,1));
        rideRepository.addToUserRideHistory(userId,updatedListOfRides);
        Assert.assertEquals(4,(rideRepository.userRidesHistory.get(userId)).size());
    }
}
