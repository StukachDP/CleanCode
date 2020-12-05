import models.MilitaryType;
import planes.*;

import java.util.*;

public class Airport {

    private List<? extends Plane> listOfPlanes;

    public Airport(List<? extends Plane> listOfPlanes) {
        this.listOfPlanes = listOfPlanes;
    }

    public List<? extends Plane> getListOfPlanes() {
        return listOfPlanes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        List<PassengerPlane> listOfPassengerPlanes = new ArrayList<>();
        for (Plane elementOfListPlanes: getListOfPlanes()) {
            if (elementOfListPlanes instanceof PassengerPlane) {
                listOfPassengerPlanes.add((PassengerPlane) elementOfListPlanes);
            }
        }
        return listOfPassengerPlanes;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> listOfMilitaryPlanes = new ArrayList<>();
        for (Plane elementOfListPlanes: getListOfPlanes()) {
            if (elementOfListPlanes instanceof MilitaryPlane) {
                listOfMilitaryPlanes.add((MilitaryPlane) elementOfListPlanes);
            }
        }
        return listOfMilitaryPlanes;
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> listOfExperimentalPlanes = new ArrayList<>();
        for (Plane elementOfListPlanes: getListOfPlanes()) {
            if (elementOfListPlanes instanceof ExperimentalPlane) {
                listOfExperimentalPlanes.add((ExperimentalPlane) elementOfListPlanes);
            }
        }
        return listOfExperimentalPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (int i = 0; i < passengerPlanes.size(); i++) {
            if (passengerPlanes.get(i).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlanes.get(i);
            }
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> listOfTransportMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> listOfAllMilitaryPlanes = getMilitaryPlanes();
        for (int i = 0; i < listOfAllMilitaryPlanes.size(); i++) {
            if (listOfAllMilitaryPlanes.get(i).getMilitaryAircraftType() == MilitaryType.TRANSPORT) {
                listOfTransportMilitaryPlanes.add(listOfAllMilitaryPlanes.get(i));
            }
        }
        return listOfTransportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> listOfBomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> listOfAllMilitaryPlanes = getMilitaryPlanes();
        for (int i = 0; i < listOfAllMilitaryPlanes.size(); i++) {
            if (listOfAllMilitaryPlanes.get(i).getMilitaryAircraftType() == MilitaryType.BOMBER) {
                listOfBomberMilitaryPlanes.add(listOfAllMilitaryPlanes.get(i));
            }
        }
        return listOfBomberMilitaryPlanes;
    }

    public Airport sortByMaxDistance() {
        Collections.sort(listOfPlanes, new Comparator<Plane>() {
            public int compare(Plane firstPlane, Plane secondPlane) {
                return firstPlane.getMaxFlightDistance() - secondPlane.getMaxFlightDistance();
            }
        });
        return this;
    }

    public Airport sortByMaxSpeed() {
        Collections.sort(listOfPlanes, new Comparator<Plane>() {
            public int compare(Plane firstPlane, Plane secondPlane) {
                return firstPlane.getMaxSpeed() - secondPlane.getMaxSpeed();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(listOfPlanes, new Comparator<Plane>() {
            public int compare(Plane firstPlane, Plane secondPlane) {
                return firstPlane.getMaxLoadCapacity() - secondPlane.getMaxLoadCapacity();
            }
        });
        return this;
    }

    private void print(Collection<? extends Plane> collection) {
        Iterator<? extends Plane> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Plane planeForPrint = iterator.next();
            System.out.println(planeForPrint);
        }
    }

    @Override
    public String toString() {
        return "Airport{ Planes= " + listOfPlanes.toString() +
                "}";
    }
}
