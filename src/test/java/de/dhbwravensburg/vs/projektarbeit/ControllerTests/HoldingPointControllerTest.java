package de.dhbwravensburg.vs.projektarbeit.ControllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.dhbwravensburg.vs.projektarbeit.controller.HoldingPointController;
import de.dhbwravensburg.vs.projektarbeit.entities.HoldingPoint;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(HoldingPointController.class)
public class HoldingPointControllerTest {

    @Autowired
    ObjectMapper mapper;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private HoldingPointController holdingPointController;

    @MockBean
    private PlannedArrivalService plannedArrivalService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @ParameterizedTest
    @CsvSource({"1"})
    void shouldGetArrivals(int holdingPointId) throws Exception {

        HoldingPoint holdingPoint = new HoldingPoint(holdingPointId, "Biberach");
        List<PlannedArrival> arrivalList = new ArrayList<PlannedArrival>();
        arrivalList.add(new PlannedArrival(1, new Date(), holdingPointId, 1));

        when(plannedArrivalService.getPlannedArrivalsByHoldingPointId(eq(holdingPointId))).thenReturn(arrivalList);

        this.mockMvc.perform(
                get("/api/v1/holdingpoints/" + holdingPointId + "/arrivals")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(this.mapper.writeValueAsBytes(holdingPoint)))
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.content().string(
                        this.mapper.writeValueAsString(arrivalList)
                ));
    }
}
