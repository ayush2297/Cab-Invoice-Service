import java.util.HashMap;
import java.util.Map;

public class CabServiceEssentials {
    CabServiceAdapter premiumCab;
    CabServiceAdapter normalCab;
    RideRepository repository;
    Map<InvoiceService.TypeOfCab,CabServiceAdapter> fareCalculator;

    public CabServiceEssentials() {
        this.premiumCab = new PremiumCabServiceAdapter();
        this.normalCab = new NormalCabServiceAdapter();
        this.repository = new RideRepository();
        fareCalculator = new HashMap<InvoiceService.TypeOfCab, CabServiceAdapter>() {{
            put(InvoiceService.TypeOfCab.PREMIUM, premiumCab );
            put(InvoiceService.TypeOfCab.NORMAL, normalCab);
        }};
    }
}
