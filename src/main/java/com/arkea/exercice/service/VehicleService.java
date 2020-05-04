package com.arkea.exercice.service;

import com.arkea.exercice.enums.Color;
import com.arkea.exercice.enums.TypeMoto;
import com.arkea.exercice.enums.TypeVehicle;
import com.arkea.exercice.object.Bike;
import com.arkea.exercice.object.Car;
import com.arkea.exercice.object.Moto;
import com.arkea.exercice.object.Vehicle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class VehicleService {
    private final Random random = new Random();
    // Color
    private final List<Color> colorList = Collections.unmodifiableList(Arrays.asList(Color.values()));
    private final int listColorSize = colorList.size();
    // MotoType
    private final List<TypeMoto> typeMotoList = Collections.unmodifiableList(Arrays.asList(TypeMoto.values()));
    private final int listMotoTypeSize = typeMotoList.size();
    // Vehicle
    private final List<TypeVehicle> typeVehicleList = Collections.unmodifiableList(Arrays.asList(TypeVehicle.values()));
    private final int listVehicleTypeSize = typeVehicleList.size();


    /**
     * Init a random color defined in enum Color
     *
     * @return Color - a random color
     */
    public Color getRandomColor() {
        return colorList.get(random.nextInt(listColorSize));
    }

    /**
     * Init a random type of moto defined in enum TypeMoto
     *
     * @return TypeMoto - a random typeMoto
     */
    public TypeMoto getRandomTypeMoto() {
        return typeMotoList.get(random.nextInt(listMotoTypeSize));
    }

    /**
     * Init a random type of moto defined in enum TypeMoto
     *
     * @return TypeMoto - a random typeMoto
     */
    public TypeVehicle getRandomVehicleType() {
        return typeVehicleList.get(random.nextInt(listVehicleTypeSize));
    }

    /**
     * Init a random type of vehicle defined in enum TypeVehicle
     *
     * @return Vehicle - a random vehicule
     */
    public Vehicle initRandomVehicle() {
        final TypeVehicle vehicleType = getRandomVehicleType();
        switch (vehicleType) {
            case CAR:
                return new Car();
            case BIKE:
                return new Bike();
            case MOTO:
                return new Moto();
            default:
                return null;
        }
    }
}
