package de.dhbwravensburg.vs.projektarbeit.repositories;

import de.dhbwravensburg.vs.projektarbeit.entities.Busline;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository, in der alle Buslinien gespeichert und über eine ID identifiziert werden können.
 */

@Repository
public class BuslineRepositoryImpl implements BuslineRepository {

    private List<Busline> buslines = new ArrayList<>();

    @Override
    public List<Busline> getAllBuslines() {
        return this.buslines;
    }

    @Override
    public Busline getBuslineById(int id) {
        Busline ret_busline = null;
        for(Busline busline : this.buslines) {
            if (busline.getLineID() == id) {
                ret_busline = busline;
            }
        }
        return ret_busline;
    }

    @Override
    public Boolean checkIfBuslineExists(int id) {
        Boolean buslinecheck = false;
        for(Busline busline : this.buslines){
            if(busline.getLineID()==id){
                buslinecheck=true;
            }else{
                ;
            }
        }
        return buslinecheck;
    }

    @Override
    public Busline addBusline(int lineId, String title) {
        Busline busline = new Busline(lineId, title);
        this.buslines.add(busline);
        return busline;
    }

    @Override
    public void removeBusline(int id) {
        Busline busline;
        for(int i=0; i<this.buslines.size(); i++){
            if(this.buslines.get(i).getLineID()==id){
                busline= this.buslines.get(i);
                this.buslines.remove(i);
            }
            else{
                //Do nothing
            }
        }
    }

}
