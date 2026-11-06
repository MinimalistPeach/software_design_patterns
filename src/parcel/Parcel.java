package src.parcel;

import java.util.ArrayList;
import java.util.List;

import src.parcelobserver.ParcelObserver;
import src.parcelstate.CreatedState;
import src.parcelstate.ParcelState;
import src.shippingstrategy.ShippingStrategy;

public class Parcel {
    private final int id;
    private final String recipient;
    private final double weightKg;
    private final ShippingStrategy shipping;
    private final List<ParcelObserver> observers = new ArrayList<>();
    private ParcelState state = new CreatedState();

    public Parcel(int id, String recipient, double weightKg, ShippingStrategy shipping) {
        this.id = id;
        this.recipient = recipient;
        this.weightKg = weightKg;
        this.shipping = shipping;
    }

    public void addObserver(ParcelObserver observer) {
        observers.add(observer);
    }

    public void advance() {
        state.advance(this);
    }

    public void cancel() {
        state.cancel(this);
    }

    public void setState(ParcelState nextState) {
        String previous = state.getName();
        state = nextState;
        for (ParcelObserver observer : observers) {
            observer.onStatusChanged(this, previous, state.getName());
        }
    }

    public int getId() {
        return id;
    }

    public String getRecipient() {
        return recipient;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public String getShippingName() {
        return shipping.getName();
    }

    public int getShippingPrice() {
        return shipping.calculatePrice(weightKg);
    }

    public String getStatus() {
        return state.getName();
    }
}
