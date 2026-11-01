package src.ui;

import java.util.Map;

import src.helpers.InputHelper;
import src.parcel.Parcel;
import src.parcelobserver.EventLog;
import src.services.ParcelService;

public class ConsoleUI {

    private final EventLog eventLog;
    private final ParcelService parcelService;

    public ConsoleUI(EventLog eventLog, ParcelService parcelService) {
        this.eventLog = eventLog;
        this.parcelService = parcelService;
    }

    public void showOptions() {
        System.out.println("\n1 - Új csomag feladása");
        System.out.println("2 - Csomag továbbítása");
        System.out.println("3 - Csomag lemondása");
        System.out.println("4 - Csomagok listázása");
        System.out.println("5 - Eseménynapló megtekintése");
        System.out.println("0 - Kilépés");
    }

    public int getUserInput(Map<Integer, Parcel> parcels) {
        switch (InputHelper.readInt("Választás: ")) {
            case 1:
                parcelService.createParcel(parcels);
                break;
            case 2:
                parcelService.updateParcel(false, parcels);
                break;
            case 3:
                parcelService.updateParcel(true, parcels);
                break;
            case 4:
                parcelService.listParcels(parcels);
                break;
            case 5:
                eventLog.printEntries();
                break;
            case 0:
                System.out.println("Viszontlátásra!");
                return 0;
            default:
                System.out.println("Nincs ilyen menüpont.");
        }
        return 1;
    }
}
