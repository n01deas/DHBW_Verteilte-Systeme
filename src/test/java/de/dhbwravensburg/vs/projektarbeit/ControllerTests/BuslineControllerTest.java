package de.dhbwravensburg.vs.projektarbeit.ControllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.dhbwravensburg.vs.projektarbeit.controller.BuslineController;
import de.dhbwravensburg.vs.projektarbeit.controller.HoldingPointController;
import de.dhbwravensburg.vs.projektarbeit.entities.Busline;
import de.dhbwravensburg.vs.projektarbeit.entities.HoldingPoint;
import de.dhbwravensburg.vs.projektarbeit.entities.PlannedArrival;
import de.dhbwravensburg.vs.projektarbeit.service.PlannedArrivalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BuslineControllerTest.class)
public class BuslineControllerTest {

    @Autowired
    ObjectMapper mapper;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private BuslineController buslineController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @ParameterizedTest
    @CsvSource({"1, Testline"})
    void shouldGetSingleBusline(int lineId, String title) throws Exception {

        //Initialisierung Testobjekt
        Busline busline = new Busline(lineId, title);

        when(buslineController.getSingleBusline(eq(lineId))).thenReturn(busline);

        this.mockMvc.perform(
                get("/api/v1/buslines/" + lineId)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(this.mapper.writeValueAsBytes(busline)))
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.content().string(
                        this.mapper.writeValueAsString(busline)
                ));
    }

    @Test
    void shouldGetAllBuslines() throws Exception{

        //Initialisierung Testobjekt
        List<Busline> buslines = new ArrayList<Busline>();

        when(buslineController.getAllBuslines()).thenReturn(buslines);

        this.mockMvc.perform(
                get("/api/v1/buslines/")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(this.mapper.writeValueAsBytes(buslines)))
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.content().string(
                        this.mapper.writeValueAsString(buslines)
                ));
    }

    @CsvSource({ "1, Testline"})
    @ParameterizedTest
    void shouldAddBusline(int lineID, String title) throws Exception{

        //Initialisierung Testobjekt
        Busline busline = new Busline(lineID, title);
        when(buslineController.addBusline(any())).thenReturn(busline);

        this.mockMvc.perform(
                post("/api/v1/buslines")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(this.mapper.writeValueAsBytes(busline)))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(
                        this.mapper.writeValueAsString(busline)
                ));

    }

    /*
    @CsvSource({"1, Testline"})
    @ParameterizedTest
    void shouldDeleteBusline(int lineID, String title) throws Exception{

        //Initialisierung Testobjekt
        Busline busline = new Busline(lineID, title);
        when(buslineController.deleteBusline(anyInt())).thenReturn(busline);

        this.mockMvc.perform(
                delete("/api/v1/buslines" + lineID)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(this.mapper.writeValueAsBytes(busline)))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(
                        this.mapper.writeValueAsString(busline)
                ));
    }
    */

}
