public class InvoiceSummary {
    public double avgFare;
    public int numberOfRides;
    public double totalFare;

    public InvoiceSummary(int numberOfRides, double totalFare) {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.avgFare = totalFare / numberOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return Double.compare(that.avgFare, avgFare) == 0 &&
                numberOfRides == that.numberOfRides &&
                Double.compare(that.totalFare, totalFare) == 0;
    }

}
