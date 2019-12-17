import java.util.*;

public class RideRepository {
    Map<String,List<Ride>> userRidesHistory;

    public RideRepository() {
        this.userRidesHistory = new HashMap<>();
    }

    public void addToUserRideHistory(String userId,Ride ride) {
        List<Ride> newList = new ArrayList<>();
        newList.add(ride);
        List<Ride> previousRides = this.userRidesHistory.get(userId);
        if(previousRides != null) {
            newList.addAll(previousRides);
        }
        this.userRidesHistory.put(userId,newList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RideRepository that = (RideRepository) o;
        return Objects.equals(userRidesHistory, that.userRidesHistory);
    }

}
