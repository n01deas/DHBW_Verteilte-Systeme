package de.dhbwravensburg.vs.projektarbeit.service;

import de.dhbwravensburg.vs.projektarbeit.entities.PlannedArrival;
import de.dhbwravensburg.vs.projektarbeit.entities.Busline;
import de.dhbwravensburg.vs.projektarbeit.entities.HoldingPoint;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BuslineExceptions.BuslineDoesNotExistsException;
import de.dhbwravensburg.vs.projektarbeit.exceptions.PlannedArrivalExceptions.PlannedArrivalNotExistsException;
import de.dhbwravensburg.vs.projektarbeit.exceptions.HoldingPointExceptions.HoldingPointNotExistsException;
import de.dhbwravensburg.vs.projektarbeit.repositories.PlannedArrivalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class PlannedArrivalServiceImpl implements PlannedArrivalService{

    @Autowired
    HoldingPointService holdingPointService;

    @Autowired
    BuslineService buslineService;

    @Autowired
    PlannedArrivalRepository plannedArrivalRepository;


    public List<PlannedArrival> plannedArrivals = new ArrayList<>();

    /**
     * Diese Methode gibt alle geplanten Ankünfte zurück.
     * @return Liste mit den geplanten Ankünften aus dem Repository.
     */
    @Override
    public List<PlannedArrival> getAllPlannedArrivals() {
        return plannedArrivalRepository.getAllPlannedArrivals();
    }

    /**
     * Diese Methode gibt eine geplante Ankunft nach angefragter ID zurück.
     * @param ArrivalID der einzelnen Ankünfte.
     * @return Gibt die geplante Ankunft als Objekt zurück.
     * @throws PlannedArrivalNotExistsException wenn die Ankunft mit der ausgewählten ID nicht vorhanden ist.
     */
    @Override
    public PlannedArrival getPlannedArrivalById(int id) throws PlannedArrivalNotExistsException {
        for (PlannedArrival plannedArrival : plannedArrivalRepository.getAllPlannedArrivals()) {
            if (plannedArrival.getArrivalID().equals(id)) {
                return plannedArrival;
            }
        }

        throw new PlannedArrivalNotExistsException();
    }

    /**
     * Diese Methode dient zum Erstellen einer neuen geplanten Ankunft.
     * @param arrivalId ID für die eindeutige Identifikation einer Ankunft
     * @param arrivalTime Zeit für die geplante Ankunft.
     * @param holdingPointId Haltestellen ID für die Zielhaltestelle
     * @param buslineId Linie des Busses, welche zur Ankunft gehört
     * @return
     */
    @Override
    public PlannedArrival addPlannedArrival(int arrivalId, Date arrivalTime, int holdingPointId, int buslineId) {
        return plannedArrivalRepository.addPlannedArrival(arrivalId, arrivalTime, holdingPointId, buslineId);
    }

    /**
     * Diese Methode gibt geplante Ankünfte auf Basis einer Haltestelle aus.
     * @param holdingPointId Haltestellen ID für das Selektieren der geplanten Ankünfte
     * @return Liste mit den geplanten Ankünften im Bezug auf die spezifische Haltestelle
     * @throws HoldingPointNotExistsException wenn die Haltestelle nicht vorhanden ist.
     */
    @Override
    public List<PlannedArrival> getPlannedArrivalsByHoldingPointId(int holdingPointId) throws HoldingPointNotExistsException {
        HoldingPoint holdingPoint = holdingPointService.getHoldingPointById(holdingPointId);
        return plannedArrivalRepository.getPlannedArrivalsByHoldingPointId(holdingPoint.getHaltestelleId());
    }

    /**
     * Diese Methode gibt die geplanten Ankünfte anhand der eingegebenen Buslinie zurück.
     * @param buslineId Buslinien ID für das Selektieren der geplanten Ankünfte.
     * @return Liste mit den geplanten Ankünften im Bezug auf die spezifische Buslinie.
     * @throws BuslineDoesNotExistsException wenn die ausgewählte Buslinie nicht vorhanden ist.
     */
    @Override
    public List<PlannedArrival> getPlannedArrivalsByBuslineId(int buslineId) throws BuslineDoesNotExistsException {
        Busline busline = buslineService.getBuslineById(buslineId);
        return plannedArrivalRepository.getPlannedArrivalsByBuslineId(busline.getLineID());
    }

    /**
     * Diese Methode gibt die geplanten Ankfünte anhand der Haltestelle und Buslinie aus.
     * @param holdingPointId Haltestelle ID die ausgewählt werden soll
     * @param buslineId Buslinie die ausgewählt werden soll
     * @return Liste mit den geplanten Ankünften.
     * @throws HoldingPointNotExistsException wenn Haltestelle nicht vorhanden.
     * @throws BuslineDoesNotExistsException wenn Buslinie nicht vorhanden.
     */
    @Override
    public List<PlannedArrival> getPlannedArrivalsByHoldingPointIdAndBuslineId(int holdingPointId, int buslineId) throws HoldingPointNotExistsException, BuslineDoesNotExistsException {
        HoldingPoint holdingPoint = holdingPointService.getHoldingPointById(holdingPointId);
        Busline busline = buslineService.getBuslineById(buslineId);
        return plannedArrivalRepository.getPlannedArrivalsByHoldingPointIdAndBuslineId(holdingPointId, buslineId);
    }

    /**
     * Diese Methode entfernt eine geplante Ankunft.
     * @param id ArrivalID für bestimmte Ankunft die gelöscht werden soll.
     * @throws PlannedArrivalNotExistsException wenn die geplante Ankunft nicht vorhanden ist.
     */
    @Override
    public void removePlannedArrival(int id) throws PlannedArrivalNotExistsException {
        PlannedArrival plannedArrival = this.getPlannedArrivalById(id);
        plannedArrivalRepository.removePlannedArrival(plannedArrival.getArrivalID());
    }
}
