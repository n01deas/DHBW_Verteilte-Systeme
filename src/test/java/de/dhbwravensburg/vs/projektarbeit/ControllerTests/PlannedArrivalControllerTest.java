package de.dhbwravensburg.vs.projektarbeit.ControllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.dhbwravensburg.vs.projektarbeit.controller.PlannedArrivalController;
import de.dhbwravensburg.vs.projektarbeit.entities.PlannedArrival;
import de.dhbwravensburg.vs.projektarbeit.service.PlannedArrivalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.Date;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PlannedArrivalController.class)
public class PlannedArrivalControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private PlannedArrivalService plannedArrivalService;

    @Autowired
    ObjectMapper mapper;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @CsvSource({ "1, 1592571574, 1, 1" })
    @ParameterizedTest
    public void shouldAddPlannedArrival (int arrivalId, long arrivalTime, int holdingPointId, int buslineId) throws Exception{

        //Test Objekt initialisieren
        PlannedArrival plannedArrival = new PlannedArrival(arrivalId, new Date(arrivalTime), holdingPointId, buslineId);
        when(plannedArrivalService.addPlannedArrival(anyInt(), any(), anyInt(), anyInt())).thenReturn(plannedArrival);

        this.mockMvc.perform(
                post("/api/v1/plannedArrivals")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(this.mapper.writeValueAsBytes(plannedArrival)))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(
                        this.mapper.writeValueAsString(plannedArrival)
                ));
    }
}
