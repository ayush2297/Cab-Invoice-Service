public class Ride {
    public double distance;
    public int time;
    public InvoiceService.TypeOfCab cabType;

    public Ride(double distance, int time, InvoiceService.TypeOfCab cabType) {
        this.distance = distance;
        this.time = time;
        this.cabType = cabType;
    }
}
