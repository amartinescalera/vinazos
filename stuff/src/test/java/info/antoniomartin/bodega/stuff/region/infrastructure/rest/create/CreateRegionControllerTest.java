package info.antoniomartin.bodega.stuff.region.infrastructure.rest.create;

import info.antoniomartin.bodega.stuff.region.application.RegionRequest;
import info.antoniomartin.bodega.stuff.region.application.RegionResponse;
import info.antoniomartin.bodega.stuff.region.application.create.CreateRegion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static info.antoniomartin.bodega.stuff.region.util.RegionUtils.REGION_REQUEST_1;
import static info.antoniomartin.bodega.stuff.region.util.RegionUtils.REGION_RESPONSE_1;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateRegionControllerTest {

    @Mock
    private CreateRegion createRegion;

    @InjectMocks
    private CreateRegionController createRegionController;

    @Test
    void shouldReturnANewRegionWhenARegionRequestIsReceived() {
        //given
        @SuppressWarnings("Redundant")
        RegionRequest request = REGION_REQUEST_1;
        when(createRegion.Create(request)).thenReturn(REGION_RESPONSE_1);

        //when
        ResponseEntity<RegionResponse> response = createRegionController.createRegion(request);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();

        RegionResponse regionResponse = response.getBody();
        assertThat(regionResponse.getId()).isEqualTo(1L);
        assertThat(regionResponse.getName()).isEqualTo("La Rioja");
        assertThat(regionResponse.getLocation()).isEqualTo("Rioja");
        assertThat(regionResponse.getCountry()).isEqualTo("España");
    }
}
