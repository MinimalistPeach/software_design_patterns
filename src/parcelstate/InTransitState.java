package src.parcelstate;

import src.parcel.Parcel;

public class InTransitState implements ParcelState {
    public String getName() {
        return "Szállítás alatt";
    }

    public void advance(Parcel parcel) {
        parcel.setState(new DeliveredState());
    }

    public void cancel(Parcel parcel) {
        throw new IllegalStateException("A szállítás alatt lévő csomag már nem mondható le.");
    }
}
