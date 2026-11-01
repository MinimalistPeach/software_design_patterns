package src.parcelstate;

public interface ParcelState {
    String getName();

    ParcelState advance();

    ParcelState cancel();
}
