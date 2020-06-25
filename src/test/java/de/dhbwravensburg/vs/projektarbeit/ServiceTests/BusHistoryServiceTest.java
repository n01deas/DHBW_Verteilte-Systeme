package de.dhbwravensburg.vs.projektarbeit.ServiceTests;

import de.dhbwravensburg.vs.projektarbeit.entities.BusHistory;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BusExceptions.BusDoesNotExistException;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BuslineExceptions.BuslineDoesNotExistsException;
import de.dhbwravensburg.vs.projektarbeit.exceptions.HoldingPointExceptions.HoldingPointNotExistsException;
import de.dhbwravensburg.vs.projektarbeit.repositories.BusHistoryRepository;
import de.dhbwravensburg.vs.projektarbeit.repositories.BusHistoryRepositoryImpl;
import de.dhbwravensburg.vs.projektarbeit.service.BusHistoryService;
import de.dhbwravensburg.vs.projektarbeit.service.BusHistoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BusHistoryServiceTest {

    @Autowired
    BusHistoryService busHistoryService;

    @MockBean
    BusHistoryRepository busHistoryRepository;

    List<BusHistory> busHistories = new ArrayList<>();

    @BeforeEach
    public void init() {
        BusHistory busHistory = new BusHistory(1, 1, 1, null);
        this.busHistories.add(busHistory);
    }

    @Test
    public void getAllBusHistories(){

        Mockito.when(busHistoryRepository.getAllBusHistories()).thenReturn(busHistories);

        List<BusHistory>busHistorylist = busHistoryService.getAllBusHistories();
        assertThat(busHistorylist).isEqualTo(busHistories);
    }

    @Test
    public void getBusHistoryByLineId(){

        Mockito.when(busHistoryRepository.getBusHistoryByLineId(Mockito.anyInt())).thenReturn(busHistories);
        List<BusHistory>busHistorylist = null;
        try {
            busHistorylist = busHistoryService.getBusHistoryByLineId(1);
        } catch (BuslineDoesNotExistsException e) {
            e.printStackTrace();
        }
        assertThat(busHistorylist).isEqualTo(busHistories);
    }

    @Test
    public void getBusHistoryByBusId(){

        Mockito.when(busHistoryRepository.getBusHistoryByBusId(Mockito.anyInt())).thenReturn(busHistories);

        List<BusHistory>busHistorylist = null;
        try {
            busHistorylist = busHistoryService.getBusHistoryByBusId(1);
        } catch (BusDoesNotExistException e) {
            e.printStackTrace();
        }
        assertThat(busHistorylist).isEqualTo(busHistories);

    }
    @Test
    public void getBusHistoryByHoldingPointId(){

        Mockito.when(busHistoryRepository.getBusHistoryByHoldingPointId(Mockito.anyInt())).thenReturn(busHistories);

        List<BusHistory>busHistorylist = null;
        try {
            busHistorylist = busHistoryService.getBusHistoryByHoldingPointId(1);
        } catch (HoldingPointNotExistsException e) {
            e.printStackTrace();
        }
        assertThat(busHistorylist).isEqualTo(busHistories);

    }

    @Test
    public void getBusHistoryByLineIdAndHoldingPoint(){

        Mockito.when(busHistoryRepository.getBusHistoryByLineIdAndHoldingPoint(Mockito.anyInt(), Mockito.anyInt())).thenReturn(busHistories);
        List<BusHistory>busHistoryList = null;
        try {
            busHistoryList = busHistoryService.getBusHistoryByLineIdAndHoldingPoint(1,1);
        } catch (BuslineDoesNotExistsException e) {
            e.printStackTrace();
        } catch (HoldingPointNotExistsException e) {
            e.printStackTrace();
        }
        assertThat(busHistoryList).isEqualTo(busHistories);
    }

    @Test
    public void addBusHistory(){
        Mockito.when(busHistoryRepository.addBusHistory(Mockito.anyInt(), Mockito.anyInt(),
                Mockito.anyInt(), Mockito.any())).thenReturn(new BusHistory(1,1,1,null));

        BusHistory busHistory = busHistoryService.addBusHistory(2,1,1,null);
        assertThat(busHistory.getBusId()).isEqualTo(1);


    }



}
