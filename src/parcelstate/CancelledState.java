package src.parcelstate;

import src.parcel.Parcel;

public class CancelledState implements ParcelState {
    public String getName() {
        return "Lemondva";
    }

    public void advance(Parcel parcel) {
        throw new IllegalStateException("A lemondott csomag nem továbbítható.");
    }

    public void cancel(Parcel parcel) {
        throw new IllegalStateException("A csomagot már lemondták.");
    }
}
