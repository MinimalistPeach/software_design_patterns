package src.parcelstate;

import src.parcel.Parcel;

public class PackedState implements ParcelState {
    private final Parcel parcel;

    public PackedState(Parcel parcel) {
        this.parcel = parcel;
    }

    public String getName() {
        return "Csomagolva";
    }

    public void advance() {
        parcel.setState(new InTransitState(parcel));
    }

    public void cancel() {
        parcel.setState(new CancelledState(parcel));
    }
}
