package src.parcelstate;

public class DeliveredState implements ParcelState {
    public String getName() {
        return "Kézbesítve";
    }

    public ParcelState advance() {
        throw new IllegalStateException("A csomagot már kézbesítették.");
    }

    public ParcelState cancel() {
        throw new IllegalStateException("A kézbesített csomag nem mondható le.");
    }
}
