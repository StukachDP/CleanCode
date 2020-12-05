import org.testng.Assert;
import org.testng.annotations.Test;
import models.*;
import planes.*;

import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static List<Plane> allPlanes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, LevelOfSecret.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, LevelOfSecret.TOP_SECRET)
    );

    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    @Test
    public void getTransportMilitaryPlanesTest() {
        Airport airport = new Airport(allPlanes);
        List<MilitaryPlane> expectedTransportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        boolean isAllRight = true;
        for (MilitaryPlane transportMilitaryPlane : expectedTransportMilitaryPlanes) {
            if ((transportMilitaryPlane.getMilitaryAircraftType() != MilitaryType.TRANSPORT)) {
                isAllRight = false;
                break;
            }
        }
        Assert.assertTrue(isAllRight);
    }

    @Test
    public void getBomberMilitaryPlanesTest() {
        Airport airport = new Airport(allPlanes);
        List<MilitaryPlane> expectedBomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        boolean isAllRight = true;
        for (MilitaryPlane bomberMilitaryPlane : expectedBomberMilitaryPlanes) {
            if ((bomberMilitaryPlane.getMilitaryAircraftType() != MilitaryType.BOMBER)) {
                isAllRight = false;
                break;
            }
        }
        Assert.assertTrue(isAllRight);
    }

    @Test
    public void getPassengerPlaneWithMaxCapacityTest() {
        Airport airport = new Airport(allPlanes);
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(planeWithMaxPassengerCapacity, expectedPlaneWithMaxPassengersCapacity);
    }

    @Test
    public void hasPlanesSortedByMaxLoadCapacityTest() {
        Airport airport = new Airport(allPlanes);
        List<? extends Plane> listOfPlanesSortedByMaxLoadCapacity = airport.sortByMaxLoadCapacity().getListOfPlanes();
        boolean isAllRightInSorting = true;
        for (int i = 0; i < listOfPlanesSortedByMaxLoadCapacity.size() - 1; i++) {
            if (listOfPlanesSortedByMaxLoadCapacity.get(i).getMaxLoadCapacity()
                    > listOfPlanesSortedByMaxLoadCapacity.get(i + 1).getMaxLoadCapacity()) {
                isAllRightInSorting = false;
                break;
            }
        }
        Assert.assertTrue(isAllRightInSorting);
    }

    @Test
    public void hasLevelOfSecretOnExperimentalPlanesHigherThanUnclassifiedTest(){
        Airport airport = new Airport(allPlanes);
        List<ExperimentalPlane> listOfExperimentalPlanes = airport.getExperimentalPlanes();
        boolean hasUnclassifiedPlanes = false;
        for(ExperimentalPlane experimentalPlane : listOfExperimentalPlanes){
            if(experimentalPlane.getClassificationLevel() == LevelOfSecret.UNCLASSIFIED){
                hasUnclassifiedPlanes = true;
                break;
            }
        }
        Assert.assertFalse(hasUnclassifiedPlanes);
    }
}
