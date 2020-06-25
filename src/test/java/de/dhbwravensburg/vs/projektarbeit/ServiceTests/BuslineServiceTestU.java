package de.dhbwravensburg.vs.projektarbeit.ServiceTests;

import de.dhbwravensburg.vs.projektarbeit.entities.Busline;
import de.dhbwravensburg.vs.projektarbeit.repositories.BuslineRepository;
import de.dhbwravensburg.vs.projektarbeit.service.BuslineService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BuslineServiceTestU {

    @Autowired
    BuslineService buslineService;

    @MockBean
    BuslineRepository buslineRepository;

    private Integer buslineID;
    private String buslineTitle;
    private Busline busline;

    @BeforeEach
    void setUp() throws Exception{
        this.buslineID = 1;
        this.buslineTitle = "Test";

        this.busline = new Busline(this.buslineID, this.buslineTitle);

        List<Busline> buslines = new ArrayList<>();
        buslines.add(this.busline);

        when(buslineRepository.getAllBuslines()).thenReturn(buslines);
        when(buslineRepository.getBuslineById(eq(this.buslineID))).thenReturn(this.busline);
        when(buslineRepository.addBusline(anyInt(), any())).thenAnswer(new Answer<Busline>(){
            @Override
            public Busline answer(InvocationOnMock invocationOnMock) throws Throwable {
                return new Busline(invocationOnMock.getArgument(0), invocationOnMock.getArgument(1));
            }
        });

    }

    @Test
    void shouldGetAllBuslines(){
        List<Busline> buslines = buslineService.getAllBuslines();
        assertThat(buslines.size() == 1);
        assertThat(this.busline.equals(buslines.get(0)));
    }

    @Test
    void shouldGetSingleBusline() throws Exception{
        Busline busline = buslineService.getBuslineById(this.buslineID);

        assertThat(busline).isNotNull();
        assertThat(busline.getLineID() == this.buslineID);
        assertThat(busline.getTitle() == this.buslineTitle);
    }

    @Test
    void shouldRemoveBusline() throws Exception {
        this.buslineService.removeBusline(this.buslineID);

        List<Busline> buslines = this.buslineService.getAllBuslines();
        assertThat(buslines.isEmpty());
    }
}
