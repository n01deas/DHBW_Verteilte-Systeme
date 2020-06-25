package de.dhbwravensburg.vs.projektarbeit.ServiceTests;

import de.dhbwravensburg.vs.projektarbeit.entities.Busline;
import de.dhbwravensburg.vs.projektarbeit.entities.HoldingPoint;
import de.dhbwravensburg.vs.projektarbeit.entities.PlannedArrival;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BuslineExceptions.BuslineDoesNotExistsException;
import de.dhbwravensburg.vs.projektarbeit.exceptions.HoldingPointExceptions.HoldingPointNotExistsException;
import de.dhbwravensburg.vs.projektarbeit.exceptions.PlannedArrivalExceptions.PlannedArrivalNotExistsException;
import de.dhbwravensburg.vs.projektarbeit.repositories.PlannedArrivalRepository;
import de.dhbwravensburg.vs.projektarbeit.service.BuslineService;
import de.dhbwravensburg.vs.projektarbeit.service.HoldingPointService;
import de.dhbwravensburg.vs.projektarbeit.service.PlannedArrivalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;



@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PlannedArrivalServiceTest {

    @MockBean
    HoldingPointService holdingPointService;

    @MockBean
    BuslineService buslineService;

    @Autowired
    PlannedArrivalService plannedArrivalService;

    @MockBean
    PlannedArrivalRepository plannedArrivalRepository;

    PlannedArrival firstArrival;
    PlannedArrival secondArrival;
    List<PlannedArrival> arrivalList = new ArrayList<>();
    Busline busline;

    @BeforeEach
    void setUp() throws Exception {
        firstArrival = new PlannedArrival(1, new Date(), 1, 1);
        secondArrival = new PlannedArrival(2, new Date(), 2, 1);
        arrivalList.add(firstArrival);
        arrivalList.add(secondArrival);

        busline = new Busline(1, "Erste Linie");
        when(buslineService.getBuslineById(anyInt())).thenReturn(busline);
        when(holdingPointService.getHoldingPointById(anyInt())).thenReturn(new HoldingPoint(1, "Marienplatz"));
    }


    @Test
    void shouldGetAllPlannedArrivals(){
            when(plannedArrivalRepository.getAllPlannedArrivals()).thenReturn(arrivalList);
            assertThat(arrivalList.equals(plannedArrivalService.getAllPlannedArrivals()));
    }


    @Test
    void shouldGetPlannedArrivalById() throws PlannedArrivalNotExistsException {
        when(plannedArrivalRepository.getAllPlannedArrivals()).thenReturn(arrivalList);
        assertThat(plannedArrivalService.getPlannedArrivalById(1).equals(firstArrival));
    }

    @ParameterizedTest
    @CsvSource({"1, 1592571574, 1, 1"})
    void shouldAddPlannedArrival(int arrivalId, long timestamp, int holdingPointId, int buslineId) {
        when(plannedArrivalRepository.addPlannedArrival(anyInt(), any(), anyInt(), anyInt())).thenReturn(new PlannedArrival(arrivalId, new Date(timestamp), holdingPointId, buslineId));
        PlannedArrival plannedArrival = plannedArrivalService.addPlannedArrival(arrivalId, new Date(timestamp), holdingPointId, buslineId);
        assertThat(plannedArrival.getArrivalID() == arrivalId);
        assertThat(plannedArrival.getArrivalTime().equals(new Date(timestamp)));
        assertThat(plannedArrival.getHaltestellenID() == holdingPointId);
        assertThat(plannedArrival.getBuslineID() == buslineId);


    }

    @Test
    void shouldGetPlannedArrivalsByHoldingPointId() throws HoldingPointNotExistsException {
        when(plannedArrivalRepository.getPlannedArrivalsByHoldingPointId(Mockito.anyInt())).thenReturn(arrivalList);
        assertThat(plannedArrivalService.getPlannedArrivalsByHoldingPointId(1).equals(arrivalList));
    }

    @Test
    void shouldGetPlannedArrivalsByBuslineId() throws BuslineDoesNotExistsException {
        when(plannedArrivalRepository.getPlannedArrivalsByBuslineId(Mockito.anyInt())).thenReturn(arrivalList);
        assertThat(plannedArrivalService.getPlannedArrivalsByBuslineId(1).equals(arrivalList));
    }

    @Test
    void shouldGetPlannedArrivalsByHoldingPointIdAndBuslineId() throws HoldingPointNotExistsException, BuslineDoesNotExistsException {
        when(plannedArrivalRepository.getPlannedArrivalsByHoldingPointIdAndBuslineId(Mockito.anyInt(), Mockito.anyInt())).thenReturn(arrivalList);
        assertThat(plannedArrivalService.getPlannedArrivalsByHoldingPointIdAndBuslineId(1, 1).equals(arrivalList));
    }

    @Test
    void shouldRemovePlannedArrival() throws PlannedArrivalNotExistsException {
        when(plannedArrivalRepository.getAllPlannedArrivals()).thenReturn(arrivalList);
        plannedArrivalService.removePlannedArrival(1);
    }
}

