package planes;

import models.LevelOfSecret;
import models.ExperimentalTypes;

import java.util.Objects;

public class ExperimentalPlane extends Plane{

    private ExperimentalTypes typeOfPlane;
    private LevelOfSecret levelOfSecretPlane;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalTypes typeOfPlane, LevelOfSecret levelOfSecretPlane) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.typeOfPlane = typeOfPlane;
        setClassificationLevel(levelOfSecretPlane);
    }

    public void setClassificationLevel(LevelOfSecret levelOfSecretPlane){
        this.levelOfSecretPlane = levelOfSecretPlane;
    }

    public LevelOfSecret getClassificationLevel(){
        return levelOfSecretPlane;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExperimentalPlane) || !super.equals(o)) return false;
        ExperimentalPlane that = (ExperimentalPlane) o;
        return typeOfPlane == that.typeOfPlane &&
                levelOfSecretPlane == that.getClassificationLevel();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfPlane, getClassificationLevel());
    }

    @Override
    public String toString() {
        return "ExperimentalPlane{ model='" + model + '\'' +
                "}";
    }
}
