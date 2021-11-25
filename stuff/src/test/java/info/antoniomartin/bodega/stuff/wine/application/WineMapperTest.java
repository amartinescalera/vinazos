package info.antoniomartin.bodega.stuff.wine.application;

import info.antoniomartin.bodega.stuff.wine.domain.Wine;
import info.antoniomartin.bodega.stuff.wine.infrastructure.persistence.WineEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
class WineMapperTest {

    private WineMapper map;

    @BeforeEach
    public void setUp() {
        map = new WineMapper();
    }

    @Test
    void should_mapToModel_when_EntityIsReceived() {
        //given
        WineEntity entity = WineEntity
            .builder()
            .id(1L)
            .name("Tierra Blanca")
            .bodega("sweetness")
            .grape("acidity")
            .tannin("tannin")
            .ageing("alcohol")
            .description("body")
            .build();

        //when
        Wine wine = map.fromEntityToModel(entity);

        //then
        assertThat(wine.getGrape()).isEqualTo("acidity");
        assertThat(wine.getName()).isEqualTo("Tierra Blanca");
        assertThat(wine.getBodega()).isEqualTo("sweetness");
        assertThat(wine.getGrape()).isEqualTo("acidity");
        assertThat(wine.getTannin()).isEqualTo("tannin");
        assertThat(wine.getAgeing()).isEqualTo("alcohol");
        assertThat(wine.getDescription()).isEqualTo("body");
    }

    @Test
    void should_mapToResponse_when_ModelIsReceived() {
        //given
        Wine wine = Wine
            .builder()
            .id(1L)
            .name("Tierra Blanca")
            .bodega("sweetness")
            .grape("acidity")
            .tannin("tannin")
            .ageing("alcohol")
            .description("body")
            .build();

        //when
        WineResponse wineResponse = map.fromModelToResponse(wine);

        //then
        assertThat(wineResponse.getBodega()).isEqualTo("acidity");
        assertThat(wineResponse.getName()).isEqualTo("Tierra Blanca");
        assertThat(wineResponse.getGrape()).isEqualTo("sweetness");
        assertThat(wineResponse.getBodega()).isEqualTo("acidity");
        assertThat(wineResponse.getTannin()).isEqualTo("tannin");
        assertThat(wineResponse.getAgeing()).isEqualTo("alcohol");
        assertThat(wineResponse.getDescription()).isEqualTo("body");
    }

    @Test
    void should_mapToModel_when_RequestIsReceived() {
        //given
        WineRequest wineRequest = WineRequest
            .builder()
            .name("Tierra Blanca")
            .grape("sweetness")
            .bodega("acidity")
            .tannin("tannin")
            .ageing("alcohol")
            .description("body")
            .build();

        //when
        Wine wine = map.fromRequestToModel(wineRequest);

        //then
        assertThat(wine.getGrape()).isEqualTo("acidity");
        assertThat(wine.getName()).isEqualTo("Tierra Blanca");
        assertThat(wine.getBodega()).isEqualTo("sweetness");
        assertThat(wine.getGrape()).isEqualTo("acidity");
        assertThat(wine.getTannin()).isEqualTo("tannin");
        assertThat(wine.getAgeing()).isEqualTo("alcohol");
        assertThat(wine.getDescription()).isEqualTo("body");
    }

    @Test
    void should_mapToEntity_when_ModelIsReceived() {
        //given
        Wine wine = Wine
            .builder()
            .id(1L)
            .name("Tierra Blanca")
            .bodega("sweetness")
            .grape("acidity")
            .tannin("tannin")
            .ageing("alcohol")
            .description("body")
            .build();

        //when
        WineEntity entity = map.fromModelToEntity(wine);

        //then
        assertThat(entity.getGrape()).isEqualTo("acidity");
        assertThat(entity.getName()).isEqualTo("Tierra Blanca");
        assertThat(entity.getBodega()).isEqualTo("sweetness");
        assertThat(entity.getGrape()).isEqualTo("acidity");
        assertThat(entity.getTannin()).isEqualTo("tannin");
        assertThat(entity.getAgeing()).isEqualTo("alcohol");
        assertThat(entity.getDescription()).isEqualTo("body");
    }
}
