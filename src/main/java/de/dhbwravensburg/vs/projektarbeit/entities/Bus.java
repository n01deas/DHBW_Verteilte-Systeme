package de.dhbwravensburg.vs.projektarbeit.entities;

//Hier wird ein Bus dargestellt. Er hat eine ID und eine LinienID
public class Bus {

    private Integer busID;
    private int lineID;

    public Bus(Integer busID, int lineID) {
        this.busID = busID;
        this.lineID = lineID;
    }

    public Integer getBusID() {
        return busID;
    }

    public void setBusID(Integer busID) {
        this.busID = busID;
    }

    public int getLineID() {
        return lineID;
    }

    public void setLineID(int lineID) {
        this.lineID = lineID;
    }
    // @Getter  (AccessLevel.PUBLIC)private Date abfahrtszeit;
    //@Getter (AccessLevel.PUBLIC)private  Date ankunftszeit;
    //@Getter @Setter (AccessLevel.PUBLIC) private Haltestelle currentHaltestelle; //evtl auch int index



}
