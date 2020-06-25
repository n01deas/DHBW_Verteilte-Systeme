package de.dhbwravensburg.vs.projektarbeit.entities;


public class Busline {
    private Integer lineID;
    private String title;

    public Busline(Integer lineID, String title) {
        this.lineID = lineID;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLineID() {
        return lineID;
    }

    public void setLineID(Integer lineID) {
        this.lineID = lineID;
    }
//    @Getter @Setter (AccessLevel.PUBLIC) private Haltestelle[] locations;
  //  @Getter @Setter (AccessLevel.PUBLIC) private long[] ankunftzeiten;
}
