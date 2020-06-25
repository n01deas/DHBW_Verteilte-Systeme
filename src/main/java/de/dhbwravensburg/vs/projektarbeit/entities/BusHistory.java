package de.dhbwravensburg.vs.projektarbeit.entities;

import java.util.Date;
/*
* Die BusHistoryklasse stellt dar, welcher Bus, wann, wo, ankommt
* */
public class BusHistory {

    private Integer busID;
    private Integer lineID;
    private Integer haltestellenID;
    private Date ankunftszeit;

    public BusHistory(Integer busId, Integer buslinie, Integer haltestellenId, Date ankunftszeits) {
        busID = busId;
        lineID = buslinie;
        haltestellenID = haltestellenId;
        ankunftszeit = ankunftszeits;
    }
    public BusHistory() {
        super();
    }

    /**Gibt die BusID zurück
     *
     * @return busID
     */
    public Integer getBusId() {
        return busID;
    }

    /**setzt die BusId auf den Wert des Parameters
     *
     * @param busId
     */
    public void setBusId(Integer busId) {
        busID = busId;
    }

    /** gibt die LinienID zurück
     *
     * @return lineID
     */
    public Integer getBuslinie() {
        return lineID;
    }

    /** setzt die Buslinie
     *
     * @param buslinie
     */
    public void setBuslinie(Integer buslinie) {
        lineID = buslinie;
    }

    /** gibt die HatrestellenID zurück
     *
     * @return haltestellenID
     */
    public Integer getHaltestellenId() {
        return haltestellenID;
    }

    /**setzt die HaltestellenID
     *
     * @param haltestellenId
     */
    public void setHaltestellenId(Integer haltestellenId) {
        haltestellenID = haltestellenId;
    }

    /** gibt die Ankunftszeit
     *
     * @return ankunftszeit
     */
    public Date getAnkunftszeit() {
        return ankunftszeit;
    }

    /** setzt die Ankunftszeit
     *
     * @param ankunftszeit
     */
    public void setAnkunftszeit(Date ankunftszeit) {
        ankunftszeit = ankunftszeit;
    }
}
