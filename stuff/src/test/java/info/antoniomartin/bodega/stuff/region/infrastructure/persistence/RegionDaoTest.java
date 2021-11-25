package info.antoniomartin.bodega.stuff.region.infrastructure.persistence;

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
class RegionDaoTest {
    @InjectMocks
    private RegionDao regionDao;

    @Mock
    private RegionRepository regionRepository;

    @Test
    void shouldCreateWhen() {
        //given
        @SuppressWarnings("Redundant")
        RegionEntity entity = REGION_ENTITY_1;
        when(regionRepository.save(REGION_ENTITY_1)).thenReturn(REGION_ENTITY_1);

        //when
        RegionEntity newEntity = regionDao.create(entity);

        //then
        assertThat(newEntity.getId()).isEqualTo(1L);
        assertThat(newEntity.getName()).isEqualTo("La Rioja");
        assertThat(newEntity.getLocation()).isEqualTo("Rioja");
        assertThat(newEntity.getCountry()).isEqualTo("España");
    }

    @Test
    void should_return_all_region() {
        //given
        when(regionRepository.findAll()).thenReturn(List.of(REGION_ENTITY_1, REGION_ENTITY_2));

        //when
        List<RegionEntity> regionEntities = regionDao.getAll();

        //then
        assertThat(regionEntities).hasSize(2);
        assertThat(regionEntities)
            .first()
            .extracting("name", "location", "country")
            .doesNotContainNull()
            .containsExactly("La Rioja", "Rioja", "España");
    }
} 
