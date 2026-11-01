package src.services;

import java.util.Locale;
import java.util.Map;

import src.helpers.InputHelper;
import src.parcel.Parcel;
import src.parcelobserver.ConsoleNotifier;
import src.parcelobserver.EventLog;
import src.shippingstrategy.ExpressShipping;
import src.shippingstrategy.ShippingStrategy;
import src.shippingstrategy.StandardShipping;

public class ParcelService {

    private final EventLog eventLog;

    public ParcelService(EventLog eventLog) {
        this.eventLog = eventLog;
    }

    private int nextId = 1;

    public void createParcel(Map<Integer, Parcel> parcels) {
        String recipient;
        do {
            System.out.print("Címzett neve: ");
            recipient = InputHelper.SCANNER.nextLine().trim();
            if (recipient.isEmpty()) {
                System.out.println("A címzett neve nem lehet üres.");
            }
        } while (recipient.isEmpty());

        double weight = InputHelper.readWeight();
        ShippingStrategy shipping = chooseShipping();

        Parcel parcel = new Parcel(nextId++, recipient, weight, shipping);
        parcel.addObserver(new ConsoleNotifier());
        parcel.addObserver(eventLog);
        parcels.put(parcel.getId(), parcel);

        System.out.printf(Locale.forLanguageTag("hu-HU"),
                "Csomag létrehozva! Azonosító: #%d, díj: %,d Ft%n",
                parcel.getId(), parcel.getShippingPrice());
    }

    public ShippingStrategy chooseShipping() {
        while (true) {
            System.out.println("Szállítás: 1 - Normál, 2 - Expressz");
            int choice = InputHelper.readInt("Választás: ");
            if (choice == 1) {
                return new StandardShipping();
            }
            if (choice == 2) {
                return new ExpressShipping();
            }
            System.out.println("1-et vagy 2-t adj meg!");
        }
    }

    public void updateParcel(boolean cancel, Map<Integer, Parcel> parcels) {
        if (parcels.isEmpty()) {
            System.out.println("Még nincs feladott csomag.");
            return;
        }

        int id = InputHelper.readInt("Csomag azonosítója: ");
        Parcel parcel = parcels.get(id);
        if (parcel == null) {
            System.out.println("Nincs ilyen azonosítójú csomag.");
            return;
        }

        try {
            if (cancel) {
                parcel.cancel();
            } else {
                parcel.advance();
            }
        } catch (IllegalStateException ex) {
            System.out.println("Nem hajtható végre: " + ex.getMessage());
        }
    }

    public void listParcels(Map<Integer, Parcel> parcels) {
        if (parcels.isEmpty()) {
            System.out.println("Még nincs feladott csomag.");
            return;
        }

        for (Parcel parcel : parcels.values()) {
            System.out.printf(Locale.forLanguageTag("hu-HU"),
                    "#%d | %s | %.1f kg | %s | %,d Ft | %s%n",
                    parcel.getId(), parcel.getRecipient(), parcel.getWeightKg(),
                    parcel.getShippingName(), parcel.getShippingPrice(), parcel.getStatus());
        }
    }
}
