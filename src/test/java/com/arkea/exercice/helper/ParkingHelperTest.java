package com.arkea.exercice.helper;

import com.arkea.exercice.enums.Color;
import com.arkea.exercice.object.Vehicle;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class ParkingHelperTest {

    ParkingHelper parkingHelper = new ParkingHelper();

    @Before
    public void setUp() {

    }

    @Test
    public void findVehiculeByColor_shouldReturnNone() {
        // Arrange
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle v = new Vehicle();
        v.setColor(Color.BLUE);
        vehicles.add(v);
        v.setColor(Color.BLACK);
        vehicles.add(v);
        v.setColor(Color.WHITE);
        vehicles.add(v);
        // Act
        final int pinkVehicule = parkingHelper.findVehiculeByColor(vehicles, Color.PINK);
        // Assert
        assertThat(pinkVehicule).isEqualTo(0);
    }

    @Test
    public void findVehiculeByColor_shouldReturnTwo() {
        // Arrange
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle v1 = new Vehicle();
        Vehicle v2 = new Vehicle();
        Vehicle v3 = new Vehicle();
        Vehicle v4 = new Vehicle();
        v1.setColor(Color.BLUE);
        vehicles.add(v1);
        v2.setColor(Color.BLUE);
        vehicles.add(v2);
        v3.setColor(Color.WHITE);
        vehicles.add(v3);
        v4.setColor(Color.PINK);
        vehicles.add(v4);
        // Act
        final int blueVehicles = parkingHelper.findVehiculeByColor(vehicles, Color.BLUE);
        // Assert
        assertThat(blueVehicles).isEqualTo(2);
    }

    @Test
    public void findColorByValue_shouldReturnNull() {
        // Act
        final Color colorByValue = parkingHelper.findColorByValue("");
        // Assert
        assertThat(colorByValue).isEqualTo(null);
    }

    @Test
    public void findColorByValue_shouldReturnAColor() {
        // Act
        final Color colorByValue = parkingHelper.findColorByValue("blanche");
        // Assert
        assertThat(colorByValue).isEqualTo(Color.WHITE);
    }

    @Test
    public void isStringNumeric_shouldReturnTrue() {
        // Act
        final boolean stringNumeric = parkingHelper.isStringNumeric("15");
        // Assert
        assertTrue(stringNumeric);
    }

    @Test
    public void isStringNumeric_shouldReturnFalse_WhenNotNummeric() {
        // Act
        final boolean stringNumeric = parkingHelper.isStringNumeric("poulpe");
        // Assert
        assertFalse(stringNumeric);
    }

    @Test
    public void isStringNumeric_shouldReturnFalse_WhenNull() {
        // Act
        final boolean stringNumeric = parkingHelper.isStringNumeric(null);
        // Assert
        assertFalse(stringNumeric);
    }

}
