package de.dhbwravensburg.vs.projektarbeit.RepositoryTest;

import de.dhbwravensburg.vs.projektarbeit.entities.HoldingPoint;
import de.dhbwravensburg.vs.projektarbeit.repositories.HoldingPointRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class HoldingPointRepositoryTest {

    @Autowired
    private HoldingPointRepository holdingPointRepository;

    private int holdingPointId = 1;
    private String location = "Biberach";

    @BeforeEach
    void setup() {
        holdingPointRepository.addHoldingPoint(holdingPointId, location);

    }

    @Test
    void shouldGetAllHoldingPoints(){
        List<HoldingPoint> holdingPointList = holdingPointRepository.getAllHoldingPoints();

        assertThat(holdingPointList.size() == 1);
        assertThat(holdingPointList.get(0).getHaltestelleId() == holdingPointId);
        assertThat(holdingPointList.get(0).getOrt() == location);

    }

    @ParameterizedTest
    @CsvSource({"1"})
    void shouldGetHoldingPointById(int id){
        HoldingPoint holdingPoint = holdingPointRepository.getHoldingPointById(id);

        assertThat(holdingPoint).isNotNull();
        assertThat(holdingPoint.equals(holdingPoint));
    }

    @ParameterizedTest
    @CsvSource({"1, Biberach"})
    void shouldAddHoldingPoint(int holdingPointId, String location){
        HoldingPoint holdingPoint = holdingPointRepository.addHoldingPoint(holdingPointId, location);

        assertThat(holdingPoint).isNotNull();
        assertThat(holdingPoint.getHaltestelleId() == holdingPointId);
        assertThat(holdingPoint.getOrt().equals(location));

    }

    @Test
    void shouldRemoveHoldingPoint(){
        holdingPointRepository.removeHoldingPoint(holdingPointId);
        assertThat(holdingPointRepository.getAllHoldingPoints().isEmpty());
    }
}
