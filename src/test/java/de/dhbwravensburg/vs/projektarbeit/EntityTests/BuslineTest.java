package de.dhbwravensburg.vs.projektarbeit.EntityTests;

import de.dhbwravensburg.vs.projektarbeit.entities.Busline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest

public class BuslineTest {

    private final int buslineID = 1;
    private final String buslineTitle = "Test";

    private final Busline busline = new Busline(buslineID, buslineTitle);

    @Test
    void shouldGetData(){
        assertThat(this.busline.getLineID() == this.buslineID);
        assertThat(this.busline.getTitle() == this.buslineTitle);
    }

    @Test
    void shouldSetData(){
        int buslineID_new = 2;
        String buslineTitle_new = "Test2";

        this.busline.setTitle(buslineTitle_new);
        this.busline.setLineID(buslineID_new);

        assertThat(this.busline.getLineID() == buslineID_new);
        assertThat(this.busline.getTitle() == buslineTitle_new);
    }
}
