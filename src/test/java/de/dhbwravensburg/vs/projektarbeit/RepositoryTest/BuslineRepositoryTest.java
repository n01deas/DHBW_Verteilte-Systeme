package de.dhbwravensburg.vs.projektarbeit.RepositoryTest;

import de.dhbwravensburg.vs.projektarbeit.entities.Busline;
import de.dhbwravensburg.vs.projektarbeit.repositories.BuslineRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BuslineRepositoryTest {

    @Autowired
    BuslineRepository buslineRepository;

    private int buslineId = 1;
    private String buslineTitle = "Test";

    private Busline busline;

    @BeforeEach
    public void setUp(){
        this.busline = this.buslineRepository.addBusline(this.buslineId, this.buslineTitle);
    }


    @ParameterizedTest
    @CsvSource({"1, TestLinie"})
    void shouldAddBusline (int buslineId, String buslineTitle){
        Busline busline = buslineRepository.addBusline(buslineId, buslineTitle);

        assertThat(busline).isNotNull();
        assertThat(busline.getLineID().equals(buslineId));
        assertThat(busline.getTitle().equals(buslineTitle));
    }

    @Test
    void shouldReturnAllBuslines (){
        List<Busline> buslines = buslineRepository.getAllBuslines();

        assertThat(buslines.size() == 1);
        assertThat(buslines.get(0).equals(buslines));
    }

    @Test
    void shouldRemoveBusline (){
        this.buslineRepository.removeBusline(busline.getLineID());
        assertThat(this.buslineRepository.getAllBuslines().isEmpty());
    }

    @Test
    void shouldReturnSingleBusline (){
        Busline busline = this.buslineRepository.getBuslineById((this.busline.getLineID()));

        assertThat(busline).isNotNull();
        assertThat(busline.equals(this.busline));
    }



}
