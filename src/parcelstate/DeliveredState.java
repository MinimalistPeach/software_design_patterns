package src.parcelstate;

import src.parcel.Parcel;

public class DeliveredState implements ParcelState {
    private final Parcel parcel;

    public DeliveredState(Parcel parcel) {
        this.parcel = parcel;
    }

    public String getName() {
        return "Kézbesítve";
    }

    public void advance() {
        throw new IllegalStateException("A csomagot már kézbesítették.");
    }

    public void cancel() {
        throw new IllegalStateException("A kézbesített csomag nem mondható le.");
    }
}
