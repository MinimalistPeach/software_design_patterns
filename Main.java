import java.util.LinkedHashMap;
import java.util.Map;

import src.parcel.Parcel;
import src.parcelobserver.EventLog;
import src.services.ParcelService;
import src.ui.ConsoleUI;

public class Main {

    private static EventLog eventLog = new EventLog();
    private static ParcelService parcelService = new ParcelService(eventLog);
    private static ConsoleUI consoleUI = new ConsoleUI(eventLog, parcelService);
    private static Map<Integer, Parcel> parcels = new LinkedHashMap<>();

    public static void main(String[] args) {
        System.out.println("=== Csomagküldő rendszer ===");
        boolean running = true;

        while (running) {
            consoleUI.showOptions();
            if (consoleUI.getUserInput(parcels) == 0) {
                running = false;
            }
        }
    }

}
