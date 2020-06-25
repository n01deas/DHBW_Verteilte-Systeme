package de.dhbwravensburg.vs.projektarbeit.EntityTests;

import de.dhbwravensburg.vs.projektarbeit.entities.Bus;
import de.dhbwravensburg.vs.projektarbeit.entities.BusHistory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BusTest {

    Bus bus;

    @BeforeEach
    public void init(){
        bus=new Bus(1,1);
    }

    @Test
    public void shouldSetBusId(){
        bus.setBusID(2);
        assertThat(bus.getBusID()).isEqualTo(2);
    }
    @Test
    public void shouldSetLineId(){
        bus.setLineID(2);
        assertThat(bus.getLineID()).isEqualTo(2);
    }
    @Test
    public void shouldGetBusId(){
        assertThat(bus.getBusID()).isEqualTo(1);
    }
    @Test
    public void shouldGetBuslineId(){
        assertThat(bus.getLineID()).isEqualTo(1);
    }







}
