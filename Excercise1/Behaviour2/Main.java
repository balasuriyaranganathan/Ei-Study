public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(new PayPalStrategy());
        cart.addItem(100);
        cart.checkout();
    }
}