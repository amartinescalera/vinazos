package info.antoniomartin.bodega.stuff.region.infrastructure.rest.get;

import info.antoniomartin.bodega.stuff.region.application.RegionResponse;
import info.antoniomartin.bodega.stuff.region.application.get.GetRegion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static info.antoniomartin.bodega.stuff.region.util.RegionUtils.REGION_RESPONSE_1;
import static info.antoniomartin.bodega.stuff.region.util.RegionUtils.REGION_RESPONSE_2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetRegionControllerTest {

    @Mock
    private GetRegion getRegion;

    @InjectMocks
    private GetRegionController getRegionController;

    @Test
    void shouldGetAllRegionWhenGetAll() {
        //given
        when(getRegion.getAll()).thenReturn(List.of(REGION_RESPONSE_1, REGION_RESPONSE_2));

        //when
        ResponseEntity<List<RegionResponse>> response = getRegionController.getAllRegion();

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody()).hasSize(2);

    }
}
