import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InvoiceServiceTest {
    InvoiceService invoiceService;

    @Before
    public void setUp() {
        invoiceService = new InvoiceService();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double calculateFare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(25.0, calculateFare, 0.0);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double calculateFare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(5.0, calculateFare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {
                new Ride(0.1, 1),
                new Ride(2.0, 5)
        };
        List<Ride> ridesList = new ArrayList<Ride>(Arrays.asList(rides));
        InvoiceSummary summary = invoiceService.calculateFare(ridesList);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserIdAndRide_ShouldReturnInvoiceSummery() {
        String userId = "abc@.com";
        Ride[] rides = {
                new Ride(0.1, 1),
                new Ride(2.0, 5)
        };
        List<Ride> ridesList = new ArrayList<Ride>(Arrays.asList(rides));
        invoiceService.addRides(userId,ridesList);
        InvoiceSummary  invoiceSummary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary,invoiceSummary);
    }

    @Test
    public void givenUserIdAndMultipleRides_ShouldReturnUpdatedInvoiceSummary() {
        String userId = "abc@.com";
        Ride[] rides = {
                new Ride(0.1, 1),
                new Ride(2.0, 5)
        };
        List<Ride> ridesList = new ArrayList<Ride>(Arrays.asList(rides));
        invoiceService.addRides(userId,ridesList);
        Ride[] rides2 = {
                new Ride(0.1, 1),
                new Ride(2.0, 5)
        };
        List<Ride> ridesList2 = new ArrayList<Ride>(Arrays.asList(rides));
        invoiceService.addRides(userId,ridesList2);
        InvoiceSummary  invoiceSummary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(4, 60.0);
        Assert.assertEquals(expectedInvoiceSummary,invoiceSummary);
    }
}
