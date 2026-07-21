package json.SystemSaveCars;

public class Car {
    private String model;
    private String brand;
    private String year;
    private double price;
    private String engineVol;
    private boolean electric;

    public Car() {
    }

    public Car(String brand, boolean electric, String engineVol, String model, double price, String year) {
        this.brand = brand;
        this.electric = electric;
        this.engineVol = engineVol;
        this.model = model;
        this.price = price;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isElectric() {
        return electric;
    }

    public void setElectric(boolean electric) {
        this.electric = electric;
    }

    public String getEngineVol() {
        return engineVol;
    }

    public void setEngineVol(String engineVol) {
        this.engineVol = engineVol;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", price=" + price +
                ", engineVol='" + engineVol + '\'' +
                ", electric=" + electric +
                '}';
    }
}
