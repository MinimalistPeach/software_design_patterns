package src.parcelstate;

import src.parcel.Parcel;

public class CreatedState implements ParcelState {
    public String getName() {
        return "Felvéve";
    }

    public void advance(Parcel parcel) {
        parcel.setState(new PackedState());
    }

    public void cancel(Parcel parcel) {
        parcel.setState(new CancelledState());
    }
}
