package src.parcelstate;

import src.parcel.Parcel;

public class PackedState implements ParcelState {
    public String getName() {
        return "Csomagolva";
    }

    public void advance(Parcel parcel) {
        parcel.setState(new InTransitState());
    }

    public void cancel(Parcel parcel) {
        parcel.setState(new CancelledState());
    }
}
