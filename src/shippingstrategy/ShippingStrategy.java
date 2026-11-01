package src.shippingstrategy;

public interface ShippingStrategy {
    int calculatePrice(double weightKg);

    String getName();
}
