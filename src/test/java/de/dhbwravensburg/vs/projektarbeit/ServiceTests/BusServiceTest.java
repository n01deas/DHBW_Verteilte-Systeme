package de.dhbwravensburg.vs.projektarbeit.ServiceTests;

import de.dhbwravensburg.vs.projektarbeit.entities.Bus;
import de.dhbwravensburg.vs.projektarbeit.entities.Busline;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BusExceptions.BusAlreadyExistException;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BusExceptions.BusDoesNotExistException;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BuslineExceptions.BuslineDoesNotExistsException;
import de.dhbwravensburg.vs.projektarbeit.repositories.BusRepository;
import de.dhbwravensburg.vs.projektarbeit.repositories.BuslineRepository;
import de.dhbwravensburg.vs.projektarbeit.service.BusService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BusServiceTest {

    @Autowired
    private BusService busService;

    @MockBean
    private BusRepository busRepository;

    @MockBean
    private BuslineRepository buslineRepository;

    @Test
    public void shouldGetAllBuses() {
        List<Bus> buses = new ArrayList<>();
        buses.add(new Bus(1, 1));

        Mockito.when(busRepository.getAllBuses()).thenReturn(buses);

        List<Bus> buslist = busService.getAllBuses();
        assertThat(buslist).isEqualTo(buses);
    }


    @Test
    public void shouldGetBusById() {
        Bus b = new Bus(1, 1);

        Mockito.when(busRepository.getBusById(Mockito.anyInt())).thenReturn(b);

        try {
            assertThat(busService.getBusById(1)).isEqualTo(b);
        } catch (BusDoesNotExistException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldAddBus() {
        Bus b = new Bus(1, 1);

        Mockito.when(busRepository.addBus(Mockito.anyInt(), Mockito.anyInt())).thenReturn(b);

        try {
            assertThat(busService.addBus(1, 1)).isEqualTo(b);
        } catch (BusAlreadyExistException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldGetBuslineOfBus() {
        Bus b = new Bus(1, 1);
        Busline busline = new Busline(1, "Linie 1");
        Mockito.when(buslineRepository.getBuslineById(Mockito.anyInt())).thenReturn(busline);
        Mockito.when(busRepository.getBusById(eq(1))).thenReturn(b);
        try {
            assertThat(busService.getBuslineOfBus(1).getLineID()).isEqualTo(busline.getLineID());
        } catch (BusDoesNotExistException e) {
            e.printStackTrace();
        } catch (BuslineDoesNotExistsException e) {
            e.printStackTrace();
        }
    }
}

