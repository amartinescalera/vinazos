package info.antoniomartin.bodega.stuff.wine.infrastructure.rest.fetch;

import info.antoniomartin.bodega.stuff.wine.application.WineResponse;
import info.antoniomartin.bodega.stuff.wine.application.fetch.FetchWine;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class FetchWineControllerTest {

    @InjectMocks
    private FetchWineController controller;

    @Mock
    private FetchWine fetchWine;

    @Test
    void should_getOneWine_when_wineExists() {
        //given
        WineResponse wine = WineResponse.builder()
            .bodega("acidity")
            .ageing("alcohol")
            .name("name")
            .description("body")
            .grape("sweetness")
            .tannin("tannin")
            .build();
        given(fetchWine.getWine(1L)).willReturn(wine);

        //when
        ResponseEntity<WineResponse> res = controller.fetchWine(1L);

        //then
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(res.getBody()).isNotNull();
        assertThat(res.getBody().getName()).isEqualTo("name");
    }

    @Test
    void should_getEmptyWine_when_wineNotExists() {
        //given
        WineResponse wine = WineResponse.builder()
            .build();
        given(fetchWine.getWine(1L)).willReturn(wine);

        //when
        ResponseEntity<WineResponse> res = controller.fetchWine(1L);

        //then
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(res.getBody()).isNotNull();
        assertThat(res.getBody().getId()).isNull();
    }
}
