public class Grocery implements StockInterface {
    private Product product;
    private int price, amount;

    public Grocery(Product product, int price, int amount) {
        this.price = price;
        this.amount = amount;
        this.product = product;
        if (price < product.getCost()) {
            System.out.println("Warning, sale price is lower than product cost");
        }
    }

    public String toString() {
        return product.toString() + ", selling at " + price + "$ with " + amount + " left";
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public void setStockAmount(int newAmount) {
        this.amount = newAmount;
    }

    @Override
    public void setStockPrice(int newPrice) {
        this.price = newPrice;
    }

    @Override
    public int getStockAmount() {
        return this.amount;
    }

    @Override
    public int getStockPrice() {
        return this.price;
    }
}
