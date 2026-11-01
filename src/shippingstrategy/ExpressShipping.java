package src.shippingstrategy;

public class ExpressShipping implements ShippingStrategy {
    @Override
    public int calculatePrice(double weightKg) {
        return 1990 + (int) Math.ceil(weightKg) * 650;
    }

    @Override
    public String getName() {
        return "Expressz";
    }
}
