package src.parcelobserver;

import src.parcel.Parcel;

public interface ParcelObserver {
    void onStatusChanged(Parcel parcel, String previous, String current);
}
