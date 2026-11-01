package src.shippingstrategy;

public class StandardShipping implements ShippingStrategy {
    @Override
    public int calculatePrice(double weightKg) {
        return 990 + (int) Math.ceil(weightKg) * 350;
    }

    @Override
    public String getName() {
        return "Normál";
    }
}
