package src.parcelstate;

import src.parcel.Parcel;

public class DeliveredState implements ParcelState {
    public String getName() {
        return "Kézbesítve";
    }

    public void advance(Parcel parcel) {
        throw new IllegalStateException("A csomagot már kézbesítették.");
    }

    public void cancel(Parcel parcel) {
        throw new IllegalStateException("A kézbesített csomag nem mondható le.");
    }
}
