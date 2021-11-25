package info.antoniomartin.bodega.stuff.region.infrastructure.rest.fetch;

import info.antoniomartin.bodega.stuff.region.application.RegionResponse;
import info.antoniomartin.bodega.stuff.region.application.fetch.FetchRegion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static info.antoniomartin.bodega.stuff.region.util.RegionUtils.REGION_RESPONSE_1;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FetchRegionControllerTest {

    @Mock
    private FetchRegion fetchRegion;

    @InjectMocks
    private FetchRegionController fetchRegionController;

    @Test
    void shouldFetchRegionWhen() {
        //given
        when(fetchRegion.get(1L)).thenReturn(REGION_RESPONSE_1);

        //when
        ResponseEntity<RegionResponse> response = fetchRegionController.fetchRegion(1L);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody())
            .extracting("name", "location", "country")
            .doesNotContainNull()
            .containsExactly("La Rioja", "Rioja", "España");
    }
} 
