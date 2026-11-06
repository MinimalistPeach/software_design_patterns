package src.parcelstate;

import src.parcel.Parcel;

public interface ParcelState {
    String getName();

    void advance(Parcel parcel);

    void cancel(Parcel parcel);
}
