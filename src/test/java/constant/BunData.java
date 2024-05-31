package constant;

public enum BunData {

    BUN_1("White", 1.52f),
    BUN_2("Black", 2.05f),
    BUN_3("Corn", 3.2f);

    private final String name;
    private final float price;

    BunData(String name, float price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}
