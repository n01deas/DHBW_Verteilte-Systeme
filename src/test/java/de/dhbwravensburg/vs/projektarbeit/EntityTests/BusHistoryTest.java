package de.dhbwravensburg.vs.projektarbeit.EntityTests;

import de.dhbwravensburg.vs.projektarbeit.entities.BusHistory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BusHistoryTest {

    BusHistory busHistory;

    @BeforeEach
    public void init(){
        busHistory=new BusHistory(1,1,1,null);
    }

    @Test
    public void shouldSetBusId(){
        busHistory.setBusId(2);
        assertThat(busHistory.getBusId()).isEqualTo(2);
    }

    @Test
    public void shouldSetBusLineId(){
        busHistory.setBuslinie(2);
        assertThat(busHistory.getBuslinie()).isEqualTo(2);
    }
    @Test
    public void shouldSetHaltestellenId(){
        busHistory.setHaltestellenId(2);
        assertThat(busHistory.getHaltestellenId()).isEqualTo(2);
    }

    @Test
    public void shouldgetBusId(){
        assertThat(busHistory.getBusId()).isEqualTo(1);
    }
    @Test
    public void shouldgetBusLineId(){
        assertThat(busHistory.getBuslinie()).isEqualTo(1);
    }
    @Test
    public void shouldgetHaltestellenId(){
        assertThat(busHistory.getHaltestellenId()).isEqualTo(1);
    }


}
