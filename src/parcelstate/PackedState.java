package src.parcelstate;

public class PackedState implements ParcelState {
    public String getName() {
        return "Csomagolva";
    }

    public ParcelState advance() {
        return new InTransitState();
    }

    public ParcelState cancel() {
        return new CancelledState();
    }
}
