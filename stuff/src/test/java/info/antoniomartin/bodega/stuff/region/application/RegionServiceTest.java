package info.antoniomartin.bodega.stuff.region.application;

import info.antoniomartin.bodega.stuff.region.application.exception.RegionMandatoryException;
import info.antoniomartin.bodega.stuff.region.domain.AssertCheckMandatoryRegionFields;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static info.antoniomartin.bodega.stuff.region.util.RegionUtils.REGION_1;
import static info.antoniomartin.bodega.stuff.region.util.RegionUtils.REGION_2;
import static info.antoniomartin.bodega.stuff.region.util.RegionUtils.REGION_ENTITY_1;
import static info.antoniomartin.bodega.stuff.region.util.RegionUtils.REGION_ENTITY_2;
import static info.antoniomartin.bodega.stuff.region.util.RegionUtils.REGION_REQUEST_1;
import static info.antoniomartin.bodega.stuff.region.util.RegionUtils.REGION_REQUEST_2;
import static info.antoniomartin.bodega.stuff.region.util.RegionUtils.REGION_RESPONSE_1;
import static info.antoniomartin.bodega.stuff.region.util.RegionUtils.REGION_RESPONSE_2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegionServiceTest {

    @Mock
    private AssertCheckMandatoryRegionFields assertCheckMandatoryFields;

    @Mock
    private RegionMapper regionMapper;

    @Mock
    private RegionFacadeDao regionFacadeDao;

    @InjectMocks
    private RegionService regionService;

    @Test
    void shouldCreateRegionWhenValidRegionRequestIsReceived() {
        //given
        @SuppressWarnings("Redundant")
        RegionRequest request = REGION_REQUEST_1;
        when(regionMapper.fromRequestToModel(request)).thenReturn(REGION_1);
        when(regionMapper.fromModelToResponse(REGION_1)).thenReturn(REGION_RESPONSE_1);
        when(regionMapper.fromModelToEntity(REGION_1)).thenReturn(REGION_ENTITY_1);
        when(regionMapper.fromEntityToModel(REGION_ENTITY_1)).thenReturn(REGION_1);
        when(regionFacadeDao.createRegion(REGION_ENTITY_1)).thenReturn(REGION_ENTITY_1);
        doNothing().when(assertCheckMandatoryFields).checksMandatoryFields(REGION_1);

        //when
        RegionResponse response = regionService.Create(request);

        //then
        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(1L);
        assertThat(response.getName()).isEqualTo("La Rioja");
        assertThat(response.getLocation()).isEqualTo("Rioja");
        assertThat(response.getCountry()).isEqualTo("España");
    }

    @Test
    void shouldThrowsARegionExceptionWhenValidRegionRequestIsReceived() {
        //given
        @SuppressWarnings("Redundant")
        final RegionRequest request = REGION_REQUEST_1;
        when(regionMapper.fromRequestToModel(request)).thenReturn(REGION_1);
        doThrow(RegionMandatoryException.class).when(assertCheckMandatoryFields).checksMandatoryFields(REGION_1);

        //when
        final Throwable throwable = catchThrowable(() -> regionService.Create(request));

        //then
        assertThat(throwable).isInstanceOf(RegionMandatoryException.class);
    }

    @Test
    void should_Return_ALL_Region_When_There_Is_Region() {
        //given
        @SuppressWarnings("Redundant")
        final List<RegionRequest> responseList = List.of(REGION_REQUEST_1, REGION_REQUEST_2);
        when(regionFacadeDao.getAll()).thenReturn(List.of(REGION_ENTITY_1, REGION_ENTITY_2));
        when(regionMapper.fromEntityToModel(REGION_ENTITY_1)).thenReturn(REGION_1);
        when(regionMapper.fromEntityToModel(REGION_ENTITY_2)).thenReturn(REGION_2);
        when(regionMapper.fromModelToResponse(REGION_1)).thenReturn(REGION_RESPONSE_1);
        when(regionMapper.fromModelToResponse(REGION_2)).thenReturn(REGION_RESPONSE_2);

        //when
        final List<RegionResponse> regionResponse = regionService.getAll();

        //then
        assertThat(regionResponse).hasSize(2);
        assertThat(regionResponse)
            .first()
            .extracting("name", "location", "country")
            .doesNotContainNull()
            .containsExactly("La Rioja", "Rioja", "España");
    }
}
