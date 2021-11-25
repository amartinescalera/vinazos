package info.antoniomartin.bodega.stuff.region.application;

import info.antoniomartin.bodega.stuff.region.infrastructure.persistence.RegionEntity;
import info.antoniomartin.bodega.stuff.region.infrastructure.persistence.create.CreateRegionDao;
import info.antoniomartin.bodega.stuff.region.infrastructure.persistence.get.GetAllRegionDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static info.antoniomartin.bodega.stuff.region.util.RegionUtils.REGION_ENTITY_1;
import static info.antoniomartin.bodega.stuff.region.util.RegionUtils.REGION_ENTITY_2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegionFacadeDaoTest {

    @Mock
    private CreateRegionDao createRegionDao;

    @Mock
    private GetAllRegionDao getAllRegionDao;

    @InjectMocks
    private RegionFacadeDao regionFacadeDao;

    @Test
    void shouldCreateRegionWhen() {
        //given
        @SuppressWarnings("Redundant")
        RegionEntity entity = REGION_ENTITY_1;
        when(createRegionDao.create(REGION_ENTITY_1)).thenReturn(REGION_ENTITY_1);

        //when
        RegionEntity regionEntity = regionFacadeDao.createRegion(entity);

        //then
        assertThat(regionEntity.getId()).isEqualTo(1L);
        assertThat(regionEntity.getName()).isEqualTo("La Rioja");
        assertThat(regionEntity.getLocation()).isEqualTo("Rioja");
        assertThat(regionEntity.getCountry()).isEqualTo("España");
    }

    @Test
    void should_return_all_region() {
        //given
        when(getAllRegionDao.getAll()).thenReturn(List.of(REGION_ENTITY_1, REGION_ENTITY_2));

        //when
        List<RegionEntity> regionEntities = getAllRegionDao.getAll();

        //then
        assertThat(regionEntities).hasSize(2);
        assertThat(regionEntities)
            .first()
            .extracting("name", "location", "country")
            .doesNotContainNull()
            .containsExactly("La Rioja", "Rioja", "España");
    }
} 
