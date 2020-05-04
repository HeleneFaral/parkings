package com.arkea.exercice;

import com.arkea.exercice.object.Parking;
import com.arkea.exercice.service.ParkingService;

/**
 * @author Hélène_Faral
 */
public class Main {

    private static final ParkingService parkingService = new ParkingService();

    public static void main(String[] args) {
        // Init the parking
        final Parking parking = parkingService.initParking();
        // Check access for random vehicle until bike's places are full
        while (parking.getBikes().size() < parking.getBikePlaces()) {
            parkingService.checkAccessParking(parking);
        }
        // Give the count of a given color vehicles
        parkingService.checkNumberVehicleByColor(parking);
    }

}
