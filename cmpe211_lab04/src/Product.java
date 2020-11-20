public class Product {
    public static int productNo;
    private String name, type;
    private int cost, id;

    public Product(String name, String type, int cost) {
        this.name = name;
        this.type = type;
        this.cost = cost;
        productNo++;
        id = productNo;

    }

    public String toString() {
        return "Product #" + id + ": " + name + " (" + type + ") " + cost + "$";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getProductNo() {
        return productNo;
    }

    public static void setProductNo(int productNo) {
        Product.productNo = productNo;
    }
}
