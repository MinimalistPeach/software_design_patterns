package src.parcelstate;

public class CancelledState implements ParcelState {
    public String getName() {
        return "Lemondva";
    }

    public ParcelState advance() {
        throw new IllegalStateException("A lemondott csomag nem továbbítható.");
    }

    public ParcelState cancel() {
        throw new IllegalStateException("A csomagot már lemondták.");
    }
}
