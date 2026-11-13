package src.parcelstate;

import src.parcel.Parcel;

public class InTransitState implements ParcelState {
    private final Parcel parcel;

    public InTransitState(Parcel parcel) {
        this.parcel = parcel;
    }

    public String getName() {
        return "Szállítás alatt";
    }

    public void advance() {
        parcel.setState(new DeliveredState(parcel));
    }

    public void cancel() {
        throw new IllegalStateException("A szállítás alatt lévő csomag már nem mondható le.");
    }
}
