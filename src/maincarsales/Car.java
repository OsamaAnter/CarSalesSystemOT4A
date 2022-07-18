package maincarsales;

//import jdk.jfr.Unsigned;
public class Car {

    private String name, model, color;
    private int year, counter, id;
    private double cost;

    public Car() {
    }

    public Car(String name, String model, int year, String color, int counter, double cost, int id) {
        this.name = name;
        this.model = model;
        this.year = year;
        this.color = color;
        this.counter = counter;
        this.cost = cost;
        this.id = id;
    }

    // copy constructor
    public Car(Car c) {
        this.name = c.getName();
        this.model = c.getModel();
        this.year = c.getYear();
        this.color = c.getColor();
        this.counter = c.getCounter();
        this.cost = c.getCost();
        this.id=c.getId();

    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public double getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" + "name='" + name + '\'' + ", model='" + model + '\'' + ", color='" + color + '\'' + ", year="
                + year + ", counter=" + counter + ", cost=" + cost + '}';
    }
}
