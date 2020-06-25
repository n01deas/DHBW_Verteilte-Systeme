package de.dhbwravensburg.vs.projektarbeit.controller;

import de.dhbwravensburg.vs.projektarbeit.entities.PlannedArrival;
import de.dhbwravensburg.vs.projektarbeit.exceptions.HoldingPointExceptions.HoldingPointNotExistsException;
import de.dhbwravensburg.vs.projektarbeit.service.BusHistoryService;
import de.dhbwravensburg.vs.projektarbeit.service.PlannedArrivalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Implementierung des Haltestellen Controller Interfaces.
 */
@RestController
@RequestMapping("/api/v1")
public class HoldingPointControllerImpl implements HoldingPointController {

    @Autowired
    PlannedArrivalService planedArrivalService;

    @Autowired
    BusHistoryService busHistoryService;

    /**
     * getArrivals
     * Methode die Ankünfte zurück gibt.
     *
     * @param holdingPointId
     * @return Liste mit geplanten Ankünften.
     */
    @Override
    @Operation(summary = "Returns all existing Arrivals", description = "This operation returns all Arrivals " +
            "which are stored in the service.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation was successfull.")
    })
    @GetMapping("/holdingpoints/{id}/arrivals")
    public List<PlannedArrival> getArrivals(@PathVariable("id") int holdingPointId) {
        try {
            return this.planedArrivalService.getPlannedArrivalsByHoldingPointId(holdingPointId);
        } catch (HoldingPointNotExistsException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Operation(summary = "Returns the delay", description = "This operation returns all Arrivals " +
            "which are stored in the service.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation was successfull.")
    })
    @GetMapping("/holdingpoints/{id}/delay/{buslineId}")
    public double getDelay(@PathVariable("id") int holdingPointId, @PathVariable("buslineId") int buslineId) {
        try {
            return this.busHistoryService.getDelayOfBuslineAtHoldingPoint(buslineId, holdingPointId);
        } catch (Exception e) {
            return 0;
        }
    }
}
