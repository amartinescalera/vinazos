package info.antoniomartin.bodega.stuff.region.application;

import info.antoniomartin.bodega.stuff.region.domain.Region;
import info.antoniomartin.bodega.stuff.region.infrastructure.persistence.RegionEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static info.antoniomartin.bodega.stuff.region.util.RegionUtils.REGION_ENTITY_1;
import static info.antoniomartin.bodega.stuff.region.util.RegionUtils.REGION_1;
import static info.antoniomartin.bodega.stuff.region.util.RegionUtils.REGION_REQUEST_1;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class RegionMapperTest {

    private RegionMapper regionMapper;

    @BeforeEach
    public void setUp() {
        regionMapper = new RegionMapper();
    }

    @Test
    void shouldFromRequestToModelWhen() {
        //given
        @SuppressWarnings("Redundant")
        RegionRequest request = REGION_REQUEST_1;
        //when
        Region region = regionMapper.fromRequestToModel(request);
        //then
        assertThat(region.getId()).isEqualTo(1L);
        assertThat(region.getName()).isEqualTo("La Rioja");
        assertThat(region.getLocation()).isEqualTo("Rioja");
        assertThat(region.getCountry()).isEqualTo("España");
    }

    @Test
    void shouldFromModelToEntityWhen() {
        //given
        @SuppressWarnings("Redundant")
        Region region = REGION_1;
        //when
        RegionEntity entity = regionMapper.fromModelToEntity(region);
        //then
        assertThat(entity.getId()).isEqualTo(1L);
        assertThat(entity.getName()).isEqualTo("La Rioja");
        assertThat(entity.getLocation()).isEqualTo("Rioja");
        assertThat(entity.getCountry()).isEqualTo("España");
    }

    @Test
    void shouldFromEntityToModelWhen() {
        //given
        @SuppressWarnings("Redundant")
        RegionEntity entity = REGION_ENTITY_1;
        //when
        Region region = regionMapper.fromEntityToModel(entity);
        //then
        assertThat(region.getId()).isEqualTo(1L);
        assertThat(region.getName()).isEqualTo("La Rioja");
        assertThat(region.getLocation()).isEqualTo("Rioja");
        assertThat(region.getCountry()).isEqualTo("España");
    }

    @Test
    void shouldFromModelToResponseWhen() {
        //given
        @SuppressWarnings("Redundant")
        Region region = REGION_1;
        //when
        RegionResponse response = regionMapper.fromModelToResponse(region);
        //then
        assertThat(response.getId()).isEqualTo(1L);
        assertThat(response.getName()).isEqualTo("La Rioja");
        assertThat(response.getLocation()).isEqualTo("Rioja");
        assertThat(response.getCountry()).isEqualTo("España");
    }
} 
