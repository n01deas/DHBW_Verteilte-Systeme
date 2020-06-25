package de.dhbwravensburg.vs.projektarbeit.EntityTests;

import de.dhbwravensburg.vs.projektarbeit.entities.HoldingPoint;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class HoldingPointTest {

    private int haltestelleId = 1;
    private String ort = "Biberach";

    private HoldingPoint holdingPoint = new HoldingPoint(haltestelleId, ort);

    @Test
    void shouldGetHaltestellenId(){
        assertThat(holdingPoint.getHaltestelleId() == haltestelleId);
    }

    @Test
    void shouldSetHaltestellenId(){
        int newId = 2;
        holdingPoint.setHaltestelleId(newId);

        assertThat(holdingPoint.getHaltestelleId() == newId);
    }

    @Test
    void shouldGetOrt(){
        assertThat(holdingPoint.getOrt() == ort);
    }

    @Test
    void shouldSetOrt(){
        String newLocation = "Ulm";

        holdingPoint.setOrt(newLocation);

        assertThat(holdingPoint.getOrt() == newLocation);

    }
}
