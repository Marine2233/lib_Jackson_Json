package json.SystemSaveCars;

import java.util.List;

public class SaveCars {
    private List<Car> carList;

    public SaveCars() {
    }

    public SaveCars(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    @Override
    public String toString() {
        return "SaveCars{" +
                "carList=" + carList +
                '}';
    }
}
