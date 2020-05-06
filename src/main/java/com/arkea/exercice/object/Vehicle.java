package com.arkea.exercice.object;

import com.arkea.exercice.enums.Color;
import com.arkea.exercice.service.VehicleService;

public class Vehicle {
    private static final VehicleService vehicleService = new VehicleService();

    private final static String GO_PARKING_MESSAGE_START = "Chouette, ma couleur est ";
    private final static String GO_PARKING_MESSAGE_END = " et je peux rentrer dans le parking";
    private final static String NO_GO_PARKING_MESSAGE = "Zut je ne peux pas rentrer dans le parking";

    protected Color color;
    protected String goPakingMessage;
    protected String noGoPakingMessage;

    public Vehicle() {
        this.color = vehicleService.getRandomColor();
        this.goPakingMessage = GO_PARKING_MESSAGE_START + this.color.name + GO_PARKING_MESSAGE_END;
        this.noGoPakingMessage = NO_GO_PARKING_MESSAGE;
    }

    public Color getColor() { return color; }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getGoPakingMessage() {
        return goPakingMessage;
    }

    public void setGoPakingMessage(String goPakingMessage) {
        this.goPakingMessage = goPakingMessage;
    }

    public String getNoGoPakingMessage() {
        return noGoPakingMessage;
    }

    public void setNoGoPakingMessage(String noGoPakingMessage) {
        this.noGoPakingMessage = noGoPakingMessage;
    }
}
