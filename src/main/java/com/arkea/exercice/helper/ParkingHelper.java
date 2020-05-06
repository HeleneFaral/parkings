package com.arkea.exercice.helper;

import com.arkea.exercice.enums.Color;
import com.arkea.exercice.enums.TypeVehicle;
import com.arkea.exercice.object.Parking;
import com.arkea.exercice.object.Vehicle;

import java.util.List;
import java.util.Scanner;

public class ParkingHelper {

    private final String PARKING_MESSAGE_START = "Je suis le parking ";
    private final String GO_PARKING_MESSAGE_END = " et je viens d'accepter un(e) ";
    private final String GO_PARKING_MESSAGE_COUNT_START = "Il me reste maintenant ";
    private final String GO_PARKING_MESSAGE_COUNT_END = " places pour ";
    private final String NO_GO_PARKING_MESSAGE_END = " et je viens de refuser un(e) ";

    final Scanner scanner = new Scanner(System.in);

    /**
     * Retrieve the parking name from the user
     * Must contains at least one carater
     *
     * @return String - a correct parking name
     */
    public String getParkingName() {
        System.out.println("Comment voulez-vous nommer le parking ?");
        String name = scanner.nextLine();
        boolean isNotEmpty = true;
        while (isNotEmpty) {
            if (name == null || name.isEmpty()) {
                System.out.println("Merci de saisir au moins un caractère : ");
                name = scanner.nextLine();
            } else {
                isNotEmpty = false;
            }
        }
        return name;
    }

    /**
     * Retrieve the number of places of a given type of vehicle from the user
     * Must respect a maximum and minimum number of place if required
     * If the input is wrong a default value is applied if required
     * If value is -1 it's not required
     *
     * @param typeVehicule - given type of vehicle
     * @param nbMinPlace   - the minimum number of places allowed
     * @param nbMaxPlace   - the maximum number of places allowed
     * @param defalutValue - Infos de la CB
     * @return placeNumber - the number of places
     */
    public int getCorrectPlaceNumber(final String typeVehicule, final int nbMinPlace, final int nbMaxPlace, final int defalutValue) {
        boolean isNotCorrect = true;
        int placeNumber = defalutValue;

        String userEntry = getUserEntry(typeVehicule, nbMinPlace, nbMaxPlace, true);

        while (isNotCorrect) {
            if (isStringNumeric(userEntry) && (Integer.parseInt(userEntry) >= nbMinPlace && (nbMaxPlace == -1 || Integer.parseInt(userEntry) <= nbMaxPlace))) {
                isNotCorrect = false;
                placeNumber = Integer.parseInt(userEntry);
            } else {
                if (defalutValue == -1) {
                    userEntry = getUserEntry(typeVehicule, nbMinPlace, nbMaxPlace, false);
                } else {
                    isNotCorrect = false;
                }
            }
        }
        return placeNumber;
    }

    /**
     * Retrieve the vehicle color from the user
     * Must match an existing vehicle number
     *
     * @return String - a correct parking name
     */
    public Color getUserChoiceColor() {
        System.out.println("Choisissez une couleur parmi les suivantes  : bleue, blanche, noire, rose");
        String userColor = scanner.nextLine();
        Color colorByValue = null;
        boolean isNotEmpty = true;
        while (isNotEmpty) {
            colorByValue = findColorByValue(userColor);
            if (colorByValue == null) {
                System.out.println("La saisie n'est pas bonne");
                System.out.println("Merci de choisir une couleur parmi les suivantes  : bleue, blanche, noire, rose");
                userColor = scanner.nextLine();
            } else {
                isNotEmpty = false;
            }
        }
        return colorByValue;
    }

    /**
     * Retrieve the number of vehicule of a type present in the parking with a given color
     *
     * @param vehicles - the color choosen by user
     * @param color    - the color choosen by user
     * @return the number of given type vehicule
     */
    public int findVehiculeByColor(final List<Vehicle> vehicles, final Color color) {
        return Math.toIntExact(vehicles.stream().filter(v -> v.getColor().equals(color)).count());
    }

    /**
     * Retrieve the Color matching a given value
     * return null if none
     *
     * @param userColor - the color choosen by user
     * @return Color - matching color
     */
    public Color findColorByValue(final String userColor) {
        if (userColor != null && !userColor.isEmpty()) {
            for (Color color : Color.values()) {
                if (color.name.equals(userColor.toLowerCase())) {
                    return color;
                }
            }
        }
        return null;
    }

    /**
     * Display for the user the informations about the vehicle access attempt to the parking
     *
     * @param parking     - the parking created by the user
     * @param vehicle     - the vehicle demanding access
     * @param type        - the type of vehicle
     * @param isAllowed   - the parking allowance
     * @param emptyPlaces - the empty places left
     */
    public void sendAccessInformations(final Parking parking, final Vehicle vehicle, final TypeVehicle type, final boolean isAllowed, final int emptyPlaces) {
        if (isAllowed) {
            System.out.println(PARKING_MESSAGE_START + parking.getName() + GO_PARKING_MESSAGE_END + type.type + "\n");
            System.out.println(GO_PARKING_MESSAGE_COUNT_START + emptyPlaces + GO_PARKING_MESSAGE_COUNT_END + type.type + "\n");
            System.out.println(vehicle.getGoPakingMessage() + "\n");
        } else {
            System.out.println(PARKING_MESSAGE_START + parking.getName() + NO_GO_PARKING_MESSAGE_END + type.type + "\n");
            System.out.println(vehicle.getNoGoPakingMessage() + "\n");
        }
    }

    /**
     * Check if String is elligible to int cast
     *
     * @param userEntry - input from the user
     * @return boolean - if elligible
     */
    public boolean isStringNumeric(final String userEntry) {
        if (userEntry == null || userEntry.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(userEntry);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * Retrieve the user entry about vehicle from given type place number
     *
     * @param typeVehicule - type of vehicle
     * @param nbMinPlace   - min niumber of place, input from the user
     * @param nbMaxPlace   - max number of place
     * @param firstEntry   - if first attempt of the user
     * @return boolean - if elligible
     */
    public String getUserEntry(final String typeVehicule, final int nbMinPlace, final int nbMaxPlace, final boolean firstEntry) {
        if (firstEntry) {
            System.out.println("Combien de places pour " + typeVehicule + " voulez vous ?");
        } else {
            System.out.println("La donnée n'est pas correcte, merci de la saisir à nouveau");
        }
        System.out.println("Le nombre doit être supérieur ou égal à " + nbMinPlace);
        if (nbMaxPlace != -1) {
            System.out.println("Le nombre de place doit être inférieur ou égal à " + nbMaxPlace);
        }
        return scanner.nextLine();
    }

}
