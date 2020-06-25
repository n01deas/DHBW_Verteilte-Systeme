package de.dhbwravensburg.vs.projektarbeit.RepositoryTest;

import de.dhbwravensburg.vs.projektarbeit.repositories.BusHistoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BusHistoryRepositoryTest {

    @Autowired
    BusHistoryRepository busHistoryRepository;

    @BeforeEach
    public void init(){
        busHistoryRepository.addBusHistory(1,1,1,null);
    }

    @Test
    public void getAllBuses(){
        assertThat(busHistoryRepository.getAllBusHistories().get(0)).isEqualTo(busHistoryRepository.getBusHistoryByBusId(1).get(0));
    }

}
