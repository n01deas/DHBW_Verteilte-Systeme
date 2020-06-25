package de.dhbwravensburg.vs.projektarbeit.controller;

import de.dhbwravensburg.vs.projektarbeit.entities.Busline;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BusExceptions.BusAlreadyExistException;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BusExceptions.BusDoesNotExistException;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BusExceptions.BusesDoNotExistException;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BuslineExceptions.BuslineAlreadyExistsException;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BuslineExceptions.BuslineDoesNotExistsException;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BuslineExceptions.BuslineMismatchException;
import de.dhbwravensburg.vs.projektarbeit.service.BuslineService;
import de.dhbwravensburg.vs.projektarbeit.service.BuslineServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BuslineControllerImpl implements BuslineController{

    @Autowired
    BuslineService buslineService;

    @GetMapping("/buslines")
    public List<Busline> getAllBuslines(){
            return buslineService.getAllBuslines();
    }

    @GetMapping("/buslines/{id}")
    public Busline getSingleBusline(@PathVariable("id") int id) {
        try {
            return buslineService.getBuslineById(id);
        } catch (BuslineDoesNotExistsException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Bus existiert nicht");
        }
    }


    @Override
    @PostMapping("/buslines")
    @Operation(summary = "Stores the given stock object", description = "This operation " +
            "stores the given object in the service.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The given object was successfully saved."),
            @ApiResponse(responseCode = "400", description = "The given stock already exists with the service."),
    })
    @ResponseStatus(HttpStatus.CREATED)
    public Busline addBusline(@Parameter(description = "The new share object") @Valid @RequestBody Busline busline) {
        try {
            return buslineService.addBusline(busline.getLineID(),busline.getTitle());
        } catch (BuslineAlreadyExistsException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Bus existiert nicht");
        }
    }

    @PutMapping (path = "/buslines/{id}", consumes = "application/json")
    public Busline updateBusline(@PathVariable("id") int id, Busline busline) {
        return null;
    }

    @DeleteMapping("/buslines/{id}")
    public void deleteBusline(@PathVariable("id") int id) {
        buslineService.removeBusline(id);
    }
}
