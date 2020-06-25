package de.dhbwravensburg.vs.projektarbeit.controller;

import de.dhbwravensburg.vs.projektarbeit.entities.BusHistory;
import de.dhbwravensburg.vs.projektarbeit.service.BusHistoryService;
import de.dhbwravensburg.vs.projektarbeit.service.PlannedArrivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TestController {

    @Autowired
    PlannedArrivalService plannedArrivalService;

    @Autowired
    BusHistoryService busHistoryService;

    @GetMapping("/test")
    public Object test() throws Exception {
        return busHistoryService.getDelayOfBuslineAtHoldingPoint(1,2);
        //return plannedArrivalService.getAllPlannedArrivals();
    }
}
