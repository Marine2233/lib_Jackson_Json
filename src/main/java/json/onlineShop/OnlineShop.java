package json.onlineShop;

public class OnlineShop {

    private long id;
    private String name;
    private double price;
    private int count;
    private String manufacturer;

    public OnlineShop() {
    }

    public OnlineShop(int count, long id, String manufacturer, String name, double price) {
        this.count = count;
        this.id = id;
        this.manufacturer = manufacturer;
        this.name = name;
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OnlineShop{" +
                "count=" + count +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
