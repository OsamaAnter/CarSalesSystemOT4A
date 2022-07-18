package maincarsales;

import java.util.LinkedList;
import java.util.List;

public class ApplicationList {

    //declare list to store my car data
    private  List<Car> carList = new LinkedList<>();

    public static ApplicationList applicationList = new ApplicationList();

    
    private ApplicationList() {
        
    }

    //get 3l list
    public List<Car> getCarList() {
        return carList;
    }

    //add to car list
    public void addCar(Car car) {
        carList.add(car);
    }

    //test print console
    public void print() {
        System.out.println(carList);
    }
}
