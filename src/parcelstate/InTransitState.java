package src.parcelstate;

public class InTransitState implements ParcelState {
    public String getName() {
        return "Szállítás alatt";
    }

    public ParcelState advance() {
        return new DeliveredState();
    }

    public ParcelState cancel() {
        throw new IllegalStateException("A szállítás alatt lévő csomag már nem mondható le.");
    }
}
