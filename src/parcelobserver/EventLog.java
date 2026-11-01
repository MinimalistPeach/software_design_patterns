package src.parcelobserver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import src.parcel.Parcel;

public class EventLog implements ParcelObserver {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final List<String> events = new ArrayList<>();

    @Override
    public void onStatusChanged(Parcel parcel, String previous, String current) {
        events.add(LocalDateTime.now().format(DATE_FORMAT) + " | #" + parcel.getId()
                + " (" + parcel.getRecipient() + "): " + previous + " -> " + current);
    }

    public void printEntries() {
        if (events.isEmpty()) {
            System.out.println("Még nincs állapotváltozás a naplóban.");
            return;
        }
        System.out.println("=== Eseménynapló ===");
        for (String event : events) {
            System.out.println(event);
        }
    }
}
