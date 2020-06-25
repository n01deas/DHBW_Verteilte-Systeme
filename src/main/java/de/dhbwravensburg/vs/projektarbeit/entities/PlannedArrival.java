package de.dhbwravensburg.vs.projektarbeit.entities;

import java.util.Date;

/**
 * Diese Entity repräsentiert das Objekt der geplanten Ankunft.
 */
public class PlannedArrival {

    private Integer arrivalID;
    private Date arrivalTime;
    private  int haltestellenID;
    private   int buslineID;

    public PlannedArrival(Integer arrivalID, Date arrivalTime, int haltestellenID, int buslineID) {
        this.arrivalID = arrivalID;
        this.arrivalTime = arrivalTime;
        this.haltestellenID = haltestellenID;
        this.buslineID = buslineID;
    }

    public Integer getArrivalID() {
        return arrivalID;
    }

    public void setArrivalID(Integer arrivalID) {
        this.arrivalID = arrivalID;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getHaltestellenID() {
        return haltestellenID;
    }

    public void setHaltestellenID(int haltestellenID) {
        this.haltestellenID = haltestellenID;
    }

    public int getBuslineID() {
        return buslineID;
    }

    public void setBuslineID(int buslineID) {
        this.buslineID = buslineID;
    }






}
