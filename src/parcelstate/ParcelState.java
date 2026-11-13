package src.parcelstate;

public interface ParcelState {
    String getName();

    void advance();

    void cancel();
}
