package planes;

import models.MilitaryType;

import java.util.Objects;

public class MilitaryPlane extends Plane {

    private MilitaryType militaryAircraftType;

    public MilitaryPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryType militaryAircraftType) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.militaryAircraftType = militaryAircraftType;
    }

    public MilitaryType getMilitaryAircraftType() {
        return militaryAircraftType;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", military Aircraft Type=" + militaryAircraftType +
                "}");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MilitaryPlane) || !super.equals(o)) return false;
        MilitaryPlane militaryPlane = (MilitaryPlane) o;
        return militaryAircraftType == militaryPlane.getMilitaryAircraftType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMilitaryAircraftType());
    }
}
