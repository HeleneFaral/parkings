package com.arkea.exercice.service;

import com.arkea.exercice.enums.TypeVehicle;
import com.arkea.exercice.helper.ParkingHelper;
import com.arkea.exercice.object.Bike;
import com.arkea.exercice.object.Parking;
import com.arkea.exercice.object.Vehicle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ParkingServiceTest {

    @Mock
    private ParkingHelper parkingHelper;

    @Mock
    private Parking parkings;

    ParkingService parkingService = new ParkingService();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    Parking parking;

    @Before
    public void setUpStreams() {
        parking = new Parking("Poulpe", 10, 10, 10);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void checkAccessParking_shouldBeFull() {
        //Arrange
        Bike bike = new Bike();
        List<Vehicle> bikes = new ArrayList<>();
        bikes.add(bike);
        parking.setBikePlaces(1);
        parking.setBikes(bikes);
        // Act
        parkingService.checkAccessParking(parking);
        // Assert
        verify(parkingHelper, never()).sendAccessInformations(any(Parking.class), any(Vehicle.class), any(TypeVehicle.class), anyBoolean(), anyInt());
    }
}
