package de.dhbwravensburg.vs.projektarbeit.entities;

public class HoldingPoint {

    private int haltestelleId;
    private String ort;

    /**
     * HoldingPoint
     * Konstruktor der Haltepunkt Klasse .
     *
     * @param haltestelleId HaltestellenID
     * @param ort Ort der Haltetelle.
     */
    public HoldingPoint(int haltestelleId, String ort) {
        this.haltestelleId = haltestelleId;
        this.ort = ort;
    }

    /**
     * getHaltestelleId
     * Gibt die Haltestellen ID zurück.
     *
     * @return haltestellenId
     */
    public int getHaltestelleId() {
        return haltestelleId;
    }

    /**
     * setHaltestelleId
     * Setzt die Haltestellen ID.
     *
     * @param haltestelleId
     */
    public void setHaltestelleId(int haltestelleId) {
        this.haltestelleId = haltestelleId;
    }

    /**
     * getOrt
     * Gibt den Ort der Haltestelle zurück.
     *
     * @return ort
     */
    public String getOrt() {
        return ort;
    }

    /**
     * setOrt
     * Setzt den Ort einer Haltestelle.
     *
     * @param ort
     */
    public void setOrt(String ort) {
        this.ort = ort;
    }
}
