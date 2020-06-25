package de.dhbwravensburg.vs.projektarbeit.helpers;

import de.dhbwravensburg.vs.projektarbeit.service.BusHistoryService;
import de.dhbwravensburg.vs.projektarbeit.service.BusService;
import de.dhbwravensburg.vs.projektarbeit.service.BuslineService;
import de.dhbwravensburg.vs.projektarbeit.service.HoldingPointService;
import de.dhbwravensburg.vs.projektarbeit.service.PlannedArrivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;

@Component
public class Seeder {

    @Autowired
    BusService busService;

    @Autowired
    BuslineService buslineService;

    @Autowired
    HoldingPointService holdingPointService;

    @Autowired
    PlannedArrivalService plannedArrivalService;

    @Autowired
    BusHistoryService busHistoryService;

    private int busId = 1;
    private int buslineId = 1;
    private int holdingPointId = 1;
    private int holdingPointId_2 = 2;
    private int planedArrivalId = 1;
    private int planedArrivalId_2 = 2;

    @PostConstruct
    public void seed() throws Exception {
        buslineService.addBusline(buslineId, "Dies ist die erste Linie");
        busService.addBus(busId, buslineId);
        holdingPointService.addHoldingPoint(holdingPointId, "Ravensburg, Marienplatz");
        holdingPointService.addHoldingPoint(holdingPointId_2, "Ravensburg, Bahnhof");

        plannedArrivalService.addPlannedArrival(planedArrivalId, getDate(15, 30), holdingPointId, buslineId);
        plannedArrivalService.addPlannedArrival(planedArrivalId_2, getDate(15, 40), holdingPointId_2, buslineId);

        busHistoryService.addBusHistory(busId, buslineId, holdingPointId, getDate(15, 32));
    }

    private Date getDate(int hours, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, hours);
        calendar.set(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }
}
