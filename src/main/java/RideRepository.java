import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class RideRepository {
    Map<String,List<Ride>> userRidesHistory;

    public RideRepository() {
        this.userRidesHistory = new HashMap<>();
    }

    public void addToUserRideHistory(String userId, List<Ride> rides) {
        List<Ride> previousRides = this.userRidesHistory.get(userId);
        if(previousRides != null) {
            rides.addAll(previousRides);
        }
        this.userRidesHistory.put(userId,rides);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RideRepository that = (RideRepository) o;
        return Objects.equals(userRidesHistory, that.userRidesHistory);
    }

}
