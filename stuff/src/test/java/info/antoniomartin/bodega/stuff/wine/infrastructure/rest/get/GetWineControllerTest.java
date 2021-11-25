package info.antoniomartin.bodega.stuff.wine.infrastructure.rest.get;

import info.antoniomartin.bodega.stuff.wine.application.WineResponse;
import info.antoniomartin.bodega.stuff.wine.application.get.GetAllWine;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class GetWineControllerTest {

    @InjectMocks
    private GetWineController controller;

    @Mock
    private GetAllWine getAllWine;

    @Test
    void should_getAllWines_when_Exist() {
        //given
        WineResponse wine1 = WineResponse.builder()
            .id(1L)
            .bodega("acidity")
            .ageing("alcohol")
            .name("name")
            .description("body")
            .grape("sweetness")
            .tannin("tannin")
            .build();

        WineResponse wine2 = WineResponse.builder()
            .id(2L)
            .bodega("acidity")
            .ageing("alcohol")
            .name("name")
            .description("body")
            .grape("sweetness")
            .tannin("tannin")
            .build();

        given(getAllWine.getAllWines()).willReturn(List.of(wine1, wine2));

        //when
        ResponseEntity<List<WineResponse>> res = controller.getAllWines();

        //then
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(res.getBody()).isNotNull();
        assertThat(res.getBody().size()).isEqualTo(2);
        assertThat(res.getBody().get(0).getName()).isEqualTo("name");
    }

    @Test
    void should_getNotWines_when_NotExist() {
        //given
        given(getAllWine.getAllWines()).willReturn(List.of());

        //when
        ResponseEntity<List<WineResponse>> res = controller.getAllWines();

        //then
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(res.getBody()).isNotNull();
        assertThat(res.getBody().size()).isZero();
    }
}
