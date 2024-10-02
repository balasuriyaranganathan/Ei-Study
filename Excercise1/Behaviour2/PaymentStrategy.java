interface PaymentStrategy {
    void pay(int amount);
}

class PayPalStrategy implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

class CreditCardStrategy implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

class ShoppingCart {
    private PaymentStrategy strategy;
    private int totalAmount = 0;

    public ShoppingCart(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void addItem(int price) {
        totalAmount += price;
    }

    public void checkout() {
        strategy.pay(totalAmount);
    }
}
