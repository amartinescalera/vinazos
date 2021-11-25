package info.antoniomartin.bodega.stuff.wine.infrastructure.rest.create;

import info.antoniomartin.bodega.stuff.wine.application.WineResponse;
import info.antoniomartin.bodega.stuff.wine.application.create.CreateWine;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static info.antoniomartin.bodega.stuff.wine.util.WineModels.GARUM_BODY;
import static info.antoniomartin.bodega.stuff.wine.util.WineModels.WINE_AFTER_SAVED;
import static info.antoniomartin.bodega.stuff.wine.util.WineModels.WINE_BEFORE_SAVED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CreateWineControllerTest {

    @InjectMocks
    private CreateWineController controller;

    @Mock
    private CreateWine createWine;

    @Test
    void should_create_a_wine_when_valid_wine_is_received() {
        //given
        given(createWine.createWine(WINE_BEFORE_SAVED)).willReturn(WINE_AFTER_SAVED);
        String hello = GARUM_BODY;
        //when
        ResponseEntity<WineResponse> res = controller.createWine(WINE_BEFORE_SAVED);

        //then
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(res.getBody()).isNotNull();
        assertThat(res.getBody().getId()).isEqualTo(1L);
        assertThat(res.getBody().getName()).isEqualTo("Garum");
    }
}
