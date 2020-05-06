package com.arkea.exercice.service;

import com.arkea.exercice.enums.Color;
import com.arkea.exercice.enums.TypeVehicle;
import com.arkea.exercice.helper.ParkingHelper;
import com.arkea.exercice.object.*;

import java.util.List;

public class ParkingService {
    static Color userChoiceColor;
    private static final VehicleService vehicleService = new VehicleService();
    private static final ParkingHelper parkingHelper = new ParkingHelper();

    /**
     * Init a parking Object with inputs from the user :
     * name of the parking
     * car place number
     * moto place number
     * bike place number
     * And save the color choose by the user
     *
     * @return Parking - the parking created by the user
     */
    public Parking initParking() {

        System.out.println("\nBienvenue, nous allons initaliser un parking :) \n");

        final String parkingName = parkingHelper.getParkingName();

        final int carPlaceNumber = parkingHelper.getCorrectPlaceNumber(TypeVehicle.CAR.type, 10, -1, -1);
        final int motoPlaceNumber = parkingHelper.getCorrectPlaceNumber(TypeVehicle.MOTO.type, 1, -1, 15);
        final int bikePlaceNumber = parkingHelper.getCorrectPlaceNumber(TypeVehicle.BIKE.type, 1, 10, -1);

        userChoiceColor = parkingHelper.getUserChoiceColor();

        return new Parking(parkingName, carPlaceNumber, motoPlaceNumber, bikePlaceNumber);
    }

    /**
     * Check parking access for random vehicles
     *
     * @param parking - the parking created by the user
     */
    public void checkAccessParking(final Parking parking) {
        while (parking.getBikes().size() < parking.getBikePlaces()) {
            final Vehicle vehicle = vehicleService.initRandomVehicle();
            boolean accessAllowed;
            if (vehicle instanceof Car) {
                accessAllowed = parking.getCars().size() < parking.getCarPlaces();
                if (accessAllowed) {
                    final List<Vehicle> cars = parking.getCars();
                    cars.add(vehicle);
                    parking.setCars(cars);
                }
                parkingHelper.sendAccessInformations(parking, vehicle, TypeVehicle.CAR, accessAllowed, (parking.getCarPlaces() - parking.getCars().size()));
            } else if (vehicle instanceof Moto) {
                accessAllowed = parking.getMotos().size() < parking.getMotoPlaces();
                if (accessAllowed) {
                    final List<Vehicle> motos = parking.getMotos();
                    motos.add(vehicle);
                    parking.setMotos(motos);
                }
                parkingHelper.sendAccessInformations(parking, vehicle, TypeVehicle.MOTO, accessAllowed, (parking.getMotoPlaces() - parking.getMotos().size()));
            } else if (vehicle instanceof Bike) {
                final List<Vehicle> bikes = parking.getBikes();
                bikes.add(vehicle);
                parking.setBikes(bikes);
                parkingHelper.sendAccessInformations(parking, vehicle, TypeVehicle.BIKE, true, (parking.getBikePlaces() - parking.getBikes().size()));
            } else {
                System.out.println("Ce type de véhicule ne peut pas rentrer dans le parking \n");
            }
        }
    }

    /**
     * Retrieve the number of vehicule present in the parking with a given color
     *
     * @param parking -  - the parking created by the user
     */
    public void checkNumberVehicleByColor(final Parking parking) {
        System.out.println("Le parking " + parking.getName() + " ne possède plus de places pour vélos, Le programme s'arrête là ! \n");
        final int totalVehicle = parkingHelper.findVehiculeByColor(parking.getCars(), userChoiceColor) + parkingHelper.findVehiculeByColor(parking.getBikes(), userChoiceColor) + parkingHelper.findVehiculeByColor(parking.getMotos(), userChoiceColor);
        System.out.println("Je suis le parking " + parking.getName() + " et j’ai " + totalVehicle + " véhicules de couleur " + userChoiceColor.name + " en mon antre");
    }
}
