import java.util.Objects;

public class Car implements Comparable<Car> {
    private final String brand;
    private final long serialNumber;

    public Car(String brand, long serialNumber) {
        this.brand = brand;
        this.serialNumber = serialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return serialNumber == car.serialNumber &&
                brand.equals(car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber);
    }

    @Override
    public String toString() {
        return brand;
    }

    @Override
    public int compareTo(Car o) {
        return brand.compareTo(o.brand);
    }
}