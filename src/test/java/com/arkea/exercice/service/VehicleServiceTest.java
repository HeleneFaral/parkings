package com.arkea.exercice.service;

import com.arkea.exercice.enums.Color;
import com.arkea.exercice.enums.TypeMoto;
import com.arkea.exercice.enums.TypeVehicle;
import com.arkea.exercice.object.Vehicle;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class VehicleServiceTest {

    VehicleService vehicleService = new VehicleService();

    @Test
    public void initRandomVehicle_shouldNotReturnNull() {
        // Act
        final Vehicle vehicle = vehicleService.initRandomVehicle();
        // Assert
        assertThat(vehicle).isNotNull();
    }

    @Test
    public void getRandomColor_shouldReturnColorObject() {
        // Act
        final Color randomColor = vehicleService.getRandomColor();
        // Assert
        assertTrue(randomColor instanceof Color);
        assertNotNull(randomColor);
        assertNotNull(randomColor.name);
    }

    @Test
    public void getRandomTypeMoto_shouldReturnTypeMotoObject() {
        // Act
        final TypeMoto randomTypeMoto = vehicleService.getRandomTypeMoto();
        // Assert
        assertTrue(randomTypeMoto instanceof TypeMoto);
        assertNotNull(randomTypeMoto);
        assertNotNull(randomTypeMoto.type);
    }

    @Test
    public void getRandomVehicleType_shouldReturnTypeMotoObject() {
        // Act
        final TypeVehicle randomVehicleType = vehicleService.getRandomVehicleType();
        // Assert
        assertTrue(randomVehicleType instanceof TypeVehicle);
        assertNotNull(randomVehicleType);
        assertNotNull(randomVehicleType.type);
    }
}
