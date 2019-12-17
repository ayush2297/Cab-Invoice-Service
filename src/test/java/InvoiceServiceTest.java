import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InvoiceServiceTest {
    InvoiceService invoiceService;
    String userId = "abc@.com";

    @Before
    public void setUp() {
        invoiceService = new InvoiceService();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        Ride ride = new Ride(2.0, 5, InvoiceService.TypeOfCab.NORMAL);
        double calculateFare = invoiceService.getFareOfThisRide(ride);
        Assert.assertEquals(25.0, calculateFare, 0.0);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinimumFare() {
        Ride ride = new Ride(0.1, 1, InvoiceService.TypeOfCab.NORMAL);
        double calculateFare = invoiceService.getFareOfThisRide(ride);
        Assert.assertEquals(5.0, calculateFare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {
                new Ride(0.1, 1, InvoiceService.TypeOfCab.NORMAL),
                new Ride(2.0, 5, InvoiceService.TypeOfCab.NORMAL)
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
                new Ride(0.1, 1, InvoiceService.TypeOfCab.NORMAL),
                new Ride(2.0, 5, InvoiceService.TypeOfCab.NORMAL)
        };
        List<Ride> ridesList = new ArrayList<Ride>(Arrays.asList(rides));
        invoiceService.addRides(userId,ridesList);
        InvoiceSummary  invoiceSummary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary,invoiceSummary);
    }

    @Test
    public void givenUserIdAndMultipleRides_ShouldReturnUpdatedInvoiceSummary() {
        Ride[] rides = {
                new Ride(0.1, 1, InvoiceService.TypeOfCab.PREMIUM),
                new Ride(2.0, 5, InvoiceService.TypeOfCab.PREMIUM)
        };
        List<Ride> ridesList = new ArrayList<Ride>(Arrays.asList(rides));
        invoiceService.addRides(userId,ridesList);
        Ride[] rides2 = {
                new Ride(0.1, 1, InvoiceService.TypeOfCab.NORMAL),
                new Ride(2.0, 5, InvoiceService.TypeOfCab.NORMAL)
        };
        List<Ride> ridesList2 = new ArrayList<Ride>(Arrays.asList(rides2));
        invoiceService.addRides(userId,ridesList2);
        InvoiceSummary  invoiceSummary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(4, 105.0);
        Assert.assertEquals(expectedInvoiceSummary,invoiceSummary);
    }

    @Test
    public void givenPremiumAsTypeOfCab_WhenChargedAccordingly_ShouldReturnTrue() {
        InvoiceService invoiceService = new InvoiceService();
        List<Ride> listOfRides = new ArrayList<>();
        listOfRides.add(new Ride(2,5, InvoiceService.TypeOfCab.PREMIUM));
        invoiceService.addRides(userId,listOfRides);
        InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(1, 60.0);
        Assert.assertEquals(expectedInvoiceSummary,invoiceSummary);

    }
}
