package entity;

import validator.Validator;

import java.io.Serializable;
import java.util.Objects;

public class Aircraft implements Serializable {
    Validator validator = new Validator();
    private static final long serialVersionUID = 1L;

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

    public boolean setCategory(String category) {
        if(validator.isNull(category)) {
            return false;
        }
        this.category = category;
        return true;
    }

    public boolean  setName(String name) {
        if(validator.isNull(name)) {
            return false;
        }
        this.name = name;
        return true;
    }

    public boolean setMaximumFlightRange(double maximumFlightRange) {
        if(validator.isNegative(maximumFlightRange)) {
            return false;
        }
        this.maximumFlightRange = maximumFlightRange;
        return true;
    }

    public boolean setCruisingSpeed(double cruisingSpeed) {
        if(validator.isNegative(cruisingSpeed)) {
            return false;
        }
        this.cruisingSpeed = cruisingSpeed;
        return true;
    }

    public boolean setFuelConsumption(double fuelConsumption) {
        if(validator.isNegative(fuelConsumption)) {
            return false;
        }
        this.fuelConsumption = fuelConsumption;
        return true;
    }

    public boolean setLiftingCapacity(double liftingCapacity) {
        if(validator.isNegative(liftingCapacity)) {
            return false;
        }
        this.liftingCapacity = liftingCapacity;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aircraft aircraft = (Aircraft) o;
        if(category == null) {
            if(aircraft.category != null) {
                return false;
            }
        } else if(!category.equals(aircraft.category)){
            return false;
        }
        if(name == null) {
            if(aircraft.name  != null) {
                return false;
            }
        } else if(!name .equals(aircraft.name )){
            return false;
        }
        if(maximumFlightRange != aircraft.maximumFlightRange) {
            return false;
        }
        if(cruisingSpeed != aircraft.cruisingSpeed) {
            return false;
        }
        if(fuelConsumption != aircraft.fuelConsumption) {
            return false;
        }
        if(liftingCapacity != aircraft.liftingCapacity) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (name == null? 0 : name.hashCode());
        result = prime * result + (category == null? 0 : category.hashCode());
        result = prime * result + Double.hashCode(maximumFlightRange);
        result = prime * result + Double.hashCode(cruisingSpeed);
        result = prime * result + Double.hashCode(fuelConsumption);
        result = prime * result + Double.hashCode(liftingCapacity);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[" +
                "category= '" + category + '\'' +
                ", name= '" + name + '\'' +
                ", maximumFlightRange= " + maximumFlightRange +
                ", cruisingSpeed= " + cruisingSpeed +
                ", liftingCapacity= " + liftingCapacity +
                ", fuelConsumption= " + fuelConsumption;
    }

}
