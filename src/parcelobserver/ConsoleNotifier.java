package src.parcelobserver;

import src.parcel.Parcel;

public class ConsoleNotifier implements ParcelObserver {
    @Override
    public void onStatusChanged(Parcel parcel, String previous, String current) {
        System.out.printf("[ÉRTESÍTÉS] #%d: %s -> %s%n",
                parcel.getId(), previous, current);
    }
}
