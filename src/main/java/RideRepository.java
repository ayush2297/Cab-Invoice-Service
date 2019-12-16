import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideRepository {
    Map<String,List<Ride>> userRidesHistory;

    public RideRepository() {
        this.userRidesHistory = new HashMap<>();
    }

    public void addToList(String userId, List<Ride> rides) {
        List<Ride> previousRides = this.userRidesHistory.get(userId);
        if(previousRides != null) {
            rides.addAll(previousRides);
        }
        this.userRidesHistory.put(userId,rides);
    }
}
