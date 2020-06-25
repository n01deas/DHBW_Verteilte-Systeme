package de.dhbwravensburg.vs.projektarbeit.RepositoryTest;

import de.dhbwravensburg.vs.projektarbeit.entities.PlannedArrival;
import de.dhbwravensburg.vs.projektarbeit.exceptions.PlannedArrivalExceptions.PlannedArrivalNotExistsException;
import de.dhbwravensburg.vs.projektarbeit.repositories.PlannedArrivalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class PlannedArrivalRepositoryTest {

    @Autowired
    PlannedArrivalRepository plannedArrivalRepository;

    private int arrivalId = 1;
    private long timestamp = 1592571574;
    private int holdingPointId = 1;
    private int buslineId = 1;
    private PlannedArrival plannedArrival;

    @BeforeEach
    public void setUp() {
        plannedArrival = plannedArrivalRepository.addPlannedArrival(arrivalId, new Date(timestamp), holdingPointId, buslineId);
    }

    @Test
    void shouldGetAllPlannedArrivals() {
        List<PlannedArrival> arrivals = plannedArrivalRepository.getAllPlannedArrivals();

        assertThat(arrivals.size() == 1);
        assertThat(arrivals.get(0).equals((plannedArrival)));
    }

    @Test
    void shouldGetPlannedArrivalById() {
        PlannedArrival arrival = plannedArrivalRepository.getPlannedArrivalById(plannedArrival.getArrivalID());

        assertThat(arrival).isNotNull();
        assertThat(arrival.equals(plannedArrival));

    }

    @ParameterizedTest
    @CsvSource({"1, 1592571574, 1 , 1"})
    void shouldAddPlannedArrival(int arrivalId, long timestamp, int holdingPointId, int buslineId) {
        PlannedArrival plannedArrival = plannedArrivalRepository.addPlannedArrival(arrivalId, new Date(timestamp), holdingPointId, buslineId);

        assertThat(plannedArrival).isNotNull();
        assertThat(plannedArrival.getArrivalID() == arrivalId);
        assertThat(plannedArrival.getArrivalTime().equals(new Date(timestamp)));
        assertThat(plannedArrival.getHaltestellenID() == holdingPointId);
        assertThat(plannedArrival.getBuslineID() == buslineId);
    }

    @Test
    void shouldGetPlannedArrivalsByHoldingPointId() {
        List<PlannedArrival> arrivals = plannedArrivalRepository.getPlannedArrivalsByHoldingPointId(plannedArrival.getHaltestellenID());

        assertThat(arrivals.size() == 1);
        assertThat(arrivals.get(0).equals((plannedArrival)));
    }

    @Test
    void shouldGetPlannedArrivalsByBuslineId() {
        List<PlannedArrival> arrivals = plannedArrivalRepository.getPlannedArrivalsByBuslineId(plannedArrival.getBuslineID());

        assertThat(arrivals.size() == 1);
        assertThat(arrivals.get(0).equals((plannedArrival)));
    }

    @Test
    void shouldGetPlannedArrivalsByHoldingPointIdAndBuslineId() {
        List<PlannedArrival> arrivals = plannedArrivalRepository.getPlannedArrivalsByHoldingPointIdAndBuslineId(plannedArrival.getHaltestellenID(), plannedArrival.getBuslineID());

        assertThat(arrivals.size() == 1);
        assertThat(arrivals.get(0).equals((plannedArrival)));

    }

    @Test
    void shoudRemovePlannedArrival() {
        plannedArrivalRepository.removePlannedArrival(plannedArrival.getArrivalID());
        assertThat(plannedArrivalRepository.getAllPlannedArrivals().isEmpty());
    }
}
