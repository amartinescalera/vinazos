package info.antoniomartin.bodega.stuff.wine.infrastructure.rest.update;

import info.antoniomartin.bodega.stuff.wine.application.exception.WineNotFoundException;
import info.antoniomartin.bodega.stuff.wine.application.WineRequest;
import info.antoniomartin.bodega.stuff.wine.application.WineResponse;
import info.antoniomartin.bodega.stuff.wine.application.update.UpdateWine;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UpdateWineControllerTest {

    @InjectMocks
    private UpdateWineController updateWineController;

    @Mock
    private  UpdateWine updateWine;

    @Test
    void should_updateWine_when_wineExist() {
        //given
        long id = 1L;
        WineRequest request = WineRequest.builder()
            .name("name")
            .build();

        WineResponse response = WineResponse.builder()
            .id(id)
            .name("name")
            .build();

        given(updateWine.updateWine(id, request)).willReturn(response);

        //when
        ResponseEntity<WineResponse> responseEntity = updateWineController.updateWine(id, request);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isNotNull();
        assertThat(responseEntity.getBody().getId()).isEqualTo(1L);

    }

    @Test
    void should_trowException_when_wineNotExist() {
        //given
        long id = 1L;
        WineRequest request = WineRequest.builder()
            .name("name")
            .build();

        given(updateWine.updateWine(id, request)).willThrow(WineNotFoundException.class);

        //when
        final Throwable throwable = catchThrowable(() -> updateWineController.updateWine(id, request));

        //then
        assertThat(throwable).isInstanceOf(WineNotFoundException.class);

    }
}
