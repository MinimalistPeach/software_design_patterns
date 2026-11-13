package src.parcelstate;

import src.parcel.Parcel;

public class CreatedState implements ParcelState {
    private final Parcel parcel;

    public CreatedState(Parcel parcel) {
        this.parcel = parcel;
    }

    public String getName() {
        return "Felvéve";
    }

    public void advance() {
        parcel.setState(new PackedState(parcel));
    }

    public void cancel() {
        parcel.setState(new CancelledState(parcel));
    }
}
