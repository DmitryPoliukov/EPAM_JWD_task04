package entity;

public class Aircraft {

    private String category;
    private String name;
    private double maximumFlightRange;
    private double cruisingSpeed;
    private double fuelConsumption;
    private double liftingCapacity;

    public Aircraft(String category, String name, double maximumFlightRange, double cruisingSpeed,
                    double fuelConsumption, double liftingCapacity) {
        this.category = category;
        this.name = name;
        this.maximumFlightRange = maximumFlightRange;
        this.cruisingSpeed = cruisingSpeed;
        this.fuelConsumption = fuelConsumption;
        this.liftingCapacity = liftingCapacity;
    }

    public Aircraft() {
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public double getMaximumFlightRange() {
        return maximumFlightRange;
    }

    public double getCruisingSpeed() {
        return cruisingSpeed;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getLiftingCapacity() {
        return liftingCapacity;
    }

    public int getAmountPassengers() {
        return 0;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", maximumFlightRange=" + maximumFlightRange +
                ", cruisingSpeed=" + cruisingSpeed +
                ", liftingCapacity= " + liftingCapacity +
                ", fuelConsumption=" + fuelConsumption;
    }

}
