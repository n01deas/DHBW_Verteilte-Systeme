package de.dhbwravensburg.vs.projektarbeit.controller;

import de.dhbwravensburg.vs.projektarbeit.entities.PlannedArrival;
import de.dhbwravensburg.vs.projektarbeit.service.PlannedArrivalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PlannedArrivalControllerImpl implements PlannedArrivalController {

    @Autowired
    PlannedArrivalService plannedArrivalService;

    @Override
    @Operation(summary = "", description = "" +
    "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created."),
            @ApiResponse(responseCode = "400", description = "Arrival does not match."),
            @ApiResponse(responseCode = "404", description = "Arrival does not exist.")
    })
    @PostMapping("/plannedArrivals")
    @ResponseStatus(HttpStatus.CREATED)
    public PlannedArrival addPlannedArrival(@RequestBody PlannedArrival plannedArrival) {
        return this.plannedArrivalService.addPlannedArrival(
                plannedArrival.getArrivalID(),
                plannedArrival.getArrivalTime(),
                plannedArrival.getHaltestellenID(),
                plannedArrival.getBuslineID());
    }
}
