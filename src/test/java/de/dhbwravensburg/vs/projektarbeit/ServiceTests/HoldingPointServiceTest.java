package de.dhbwravensburg.vs.projektarbeit.ServiceTests;


import de.dhbwravensburg.vs.projektarbeit.entities.HoldingPoint;
import de.dhbwravensburg.vs.projektarbeit.exceptions.HaltestellenExceptions.HaltestellenDoNotExistException;
import de.dhbwravensburg.vs.projektarbeit.repositories.HoldingPointRepository;
import de.dhbwravensburg.vs.projektarbeit.service.HoldingPointService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class HoldingPointServiceTest {

    @Autowired
    HoldingPointService holdingPointService;

    @MockBean

    HoldingPointRepository holdingPointRepository;

    List<HoldingPoint> holdingPointList = new ArrayList<>();

    @BeforeEach
    public void init(){
        HoldingPoint holdingPoint = new HoldingPoint(1, "Biberach");
        this.holdingPointList.add(holdingPoint);
    }

    @Test
    public void shouldGetAllHoldingPoints(){
        Mockito.when(holdingPointRepository.getAllHoldingPoints()).thenReturn(holdingPointList);

        List<HoldingPoint> holdingPointListe = holdingPointService.getAllHoldingPoints();
        assertThat(holdingPointListe).isEqualTo(holdingPointList);
    }

    @Test
    public void shouldGetAllHoldingPointsById() throws Exception {
        Mockito.when(holdingPointRepository.getHoldingPointById(Mockito.anyInt())).thenReturn(holdingPointList.get(0));

        HoldingPoint holdingPoint = holdingPointService.getHoldingPointById(1);

        assertThat(holdingPoint).isNotNull();
        assertThat(holdingPoint).isEqualTo(holdingPointList.get(0));
    }

    @Test
    public void shouldAddHoldingPoint() throws Exception {
        Mockito.when(holdingPointRepository.addHoldingPoint(Mockito.anyInt(), Mockito.anyString())).thenReturn(new HoldingPoint(1,"test"));

        HoldingPoint holdingPoint = holdingPointService.addHoldingPoint(1, "test");
        assertThat(holdingPoint.getHaltestelleId()).isEqualTo(1);
        assertThat(holdingPoint.getOrt()).isEqualTo("test");
    }

    @Test
    public void shouldRemoveHoldingPoint(){
        this.holdingPointRepository.removeHoldingPoint(Mockito.anyInt());
        assertThat(this.holdingPointRepository.getAllHoldingPoints().isEmpty());
    }
}
