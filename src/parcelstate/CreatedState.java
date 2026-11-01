package src.parcelstate;

public class CreatedState implements ParcelState {
    public String getName() {
        return "Felvéve";
    }

    public ParcelState advance() {
        return new PackedState();
    }

    public ParcelState cancel() {
        return new CancelledState();
    }
}
