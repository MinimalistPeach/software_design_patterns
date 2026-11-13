package src.parcelstate;

import src.parcel.Parcel;

public class CancelledState implements ParcelState {
    private final Parcel parcel;

    public CancelledState(Parcel parcel) {
        this.parcel = parcel;
    }

    public String getName() {
        return "Lemondva";
    }

    public void advance() {
        throw new IllegalStateException("A lemondott csomag nem továbbítható.");
    }

    public void cancel() {
        throw new IllegalStateException("A csomagot már lemondták.");
    }
}
