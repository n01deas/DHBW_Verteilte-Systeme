package de.dhbwravensburg.vs.projektarbeit.EntityTests;


import de.dhbwravensburg.vs.projektarbeit.entities.PlannedArrival;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PlannedArrivalTest {

    private int arrivalId = 1;
    private long timestamp = 1592571574;
    private int holdingPointId = 1;
    private int buslineId = 1;

    private PlannedArrival plannedArrival = new PlannedArrival(arrivalId, new Date(timestamp), holdingPointId, buslineId);


    @Test
    void shouldGet() {
        assertThat(plannedArrival.getArrivalID() == arrivalId);
        assertThat(plannedArrival.getArrivalTime().equals(new Date(timestamp)));
        assertThat(plannedArrival.getHaltestellenID() == holdingPointId);
        assertThat(plannedArrival.getBuslineID() == buslineId);

    }

    @Test
    void shouldSet() {
        arrivalId = 2;
        timestamp = 1592571500;
        holdingPointId = 2;
        buslineId = 2;

        plannedArrival.setArrivalID(arrivalId);
        plannedArrival.setArrivalTime(new Date(timestamp));
        plannedArrival.setHaltestellenID(holdingPointId);
        plannedArrival.setBuslineID(buslineId);

        assertThat(plannedArrival.getArrivalID() == arrivalId);
        assertThat(plannedArrival.getArrivalTime().equals(new Date(timestamp)));
        assertThat(plannedArrival.getHaltestellenID() == holdingPointId);
        assertThat(plannedArrival.getBuslineID() == buslineId);
    }
}
