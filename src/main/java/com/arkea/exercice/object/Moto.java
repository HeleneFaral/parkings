package com.arkea.exercice.object;

import com.arkea.exercice.enums.TypeMoto;
import com.arkea.exercice.service.VehicleService;

public class Moto extends Vehicle {

    private static final VehicleService vehicleService = new VehicleService();

    private final static String GO_PARKING_MESSAGE_START = "Youpi ! ma couleur est ";
    private final static String GO_PARKING_MESSAGE_END = " et je peux rentrer dans le parking";
    private final static String NO_GO_PARKING_MESSAGE_START = "Hey ! je suis une ";
    private final static String NO_GO_PARKING_MESSAGE_END = " vous allez regretter de ne pas m’avoir laissé entrer";

    protected TypeMoto typeMoto;

    public Moto() {
        super();
        this.typeMoto = vehicleService.getRandomTypeMoto();
        this.goPakingMessage = GO_PARKING_MESSAGE_START + this.color.name + GO_PARKING_MESSAGE_END;
        this.noGoPakingMessage = NO_GO_PARKING_MESSAGE_START + this.typeMoto.type + NO_GO_PARKING_MESSAGE_END;
    }
}
