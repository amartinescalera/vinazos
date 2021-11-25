package info.antoniomartin.bodega.stuff.wine.application;

import info.antoniomartin.bodega.stuff.wine.domain.Wine;
import info.antoniomartin.bodega.stuff.wine.infrastructure.persistence.WineEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class WineServiceTest {

    @Mock
    private WineMapper map;
    @Mock
    private WineDaoFacade facade;
    @Mock
    private AssertIfWineExist assertIfWineExist;
    @Mock
    private AssertCheckMandatoryWineFields mandatoryFields;

    @InjectMocks
    private WineService wineService;

    @BeforeEach
    void setUp() {
        given(map.fromEntityToModel(any()))
            .willReturn(Wine.builder().id(2L).description("body").build());
        given(map.fromModelToResponse(any()))
            .willReturn(WineResponse.builder().id(2L).build());
    }

    @Test
    void should_returnWine_when_wineExist() {
        //given
        long id = 2L;
        doNothing().when(assertIfWineExist).checkIfExist(id);
        given(facade.getWine(id)).willReturn(WineEntity.builder().id(id).build());

        //when
        WineResponse response = wineService.getWine(id);

        //then
        assertThat(response.getId()).isEqualTo(2L);

    }

    @Test
    void should_returnListOfWine_when_AllIsRequired() {
        //given
        List<WineEntity> entityList = List.of(WineEntity.builder().id(1L).build(), WineEntity.builder().id(2L).build());
        given(facade.getAll()).willReturn(entityList);

        //when
        List<WineResponse> response = wineService.getAllWines();

        //then
        assertThat(response).isNotNull();
        assertThat(response).hasSize(2);
        assertThat(response.get(0).getId()).isEqualTo(2L);
    }

    @Test
    void should_aNewWine_when_WineRequestIsReceived() {
        //given
        WineRequest wineBeforeSaved = WineRequest.builder()
            .bodega("acidity")
            .ageing("alcohol")
            .name("name")
            .description("body")
            .grape("sweetness")
            .tannin("tannin")
            .build();

        WineResponse wineAfterSaved = WineResponse.builder()
            .id(1L)
            .bodega("acidity")
            .ageing("alcohol")
            .name("name")
            .description("body")
            .grape("sweetness")
            .tannin("tannin")
            .build();

        Wine wine = Wine.builder()
            .grape("acidity")
            .ageing("alcohol")
            .name("name")
            .description("body")
            .bodega("sweetness")
            .tannin("tannin")
            .build();

        WineEntity wineEntity = WineEntity.builder()
            .grape("acidity")
            .ageing("alcohol")
            .name("name")
            .description("body")
            .bodega("sweetness")
            .tannin("tannin")
            .build();

        given(map.fromRequestToModel(wineBeforeSaved)).willReturn(wine);
        given(map.fromModelToEntity(wine)).willReturn(wineEntity);
        given(map.fromEntityToModel(wineEntity)).willReturn(wine);
        given(map.fromModelToResponse(wine)).willReturn(wineAfterSaved);
        given(facade.save(wineEntity)).willReturn(wineEntity);
        doNothing().when(mandatoryFields).checksMandatoryFields(wine);


        //when
        WineResponse response = wineService.createWine(wineBeforeSaved);

        //then
        assertThat(response).usingRecursiveComparison().isEqualTo(wineAfterSaved);
    }

    @Test
    void shouldDeleteAWineWhenTryToRemoveWine() {
        //given
        long wineId = 1L;
        doNothing().when(facade).delete(wineId);
        //when
        //then
        wineService.delete(wineId);
        assertTrue(true);
    }

    @Test
    void shouldUpdateWineWhenWineExist() {
        //given
        long id = 2L;

        WineRequest wineRequest = WineRequest.builder()
            .bodega("acidity")
            .ageing("alcohol")
            .name("name")
            .description("body")
            .grape("sweetness")
            .tannin("tannin")
            .build();

        Wine wine = Wine.builder()
            .grape("acidity")
            .ageing("alcohol")
            .name("name")
            .description("body")
            .bodega("sweetness")
            .tannin("tannin")
            .build();

        WineEntity wineEntity = WineEntity.builder()
            .grape("acidity")
            .ageing("alcohol")
            .name("name")
            .description("body")
            .bodega("sweetness")
            .tannin("tannin")
            .build();

        WineResponse wineResponse = WineResponse.builder()
            .bodega("acidity")
            .ageing("alcohol")
            .name("name")
            .description("body")
            .grape("sweetness")
            .tannin("tannin")
            .build();

        doNothing().when(assertIfWineExist).checkIfExist(id);
        doNothing().when(mandatoryFields).checksMandatoryFields(wine);
        when(map.fromRequestToModel(wineRequest)).thenReturn(wine);
        when(map.fromModelToEntity(wine)).thenReturn(wineEntity);
        when(map.fromEntityToModel(wineEntity)).thenReturn(wine);
        when(map.fromModelToResponse(wine)).thenReturn(wineResponse);
        when(facade.update(wineEntity)).thenReturn(wineEntity);

        //when
        WineResponse response = wineService.updateWine(id, wineRequest);

        //then
//        assertThat(response)
//            .extracting("acidity", "alcohol", "name","body","sweetness","tannin")
//            .doesNotContainNull()
//            .containsExactly("name", "grape", "bodega", "tannin", "ageing", "description");
    }
}
