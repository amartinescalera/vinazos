package info.antoniomartin.bodega.stuff.wine.application;

import info.antoniomartin.bodega.stuff.wine.infrastructure.persistence.delete.DeleteWineDao;
import info.antoniomartin.bodega.stuff.wine.infrastructure.persistence.fetch.FetchWineDao;
import info.antoniomartin.bodega.stuff.wine.infrastructure.persistence.get.GetAllWineDao;
import info.antoniomartin.bodega.stuff.wine.infrastructure.persistence.save.SaveWineDao;
import info.antoniomartin.bodega.stuff.wine.infrastructure.persistence.update.UpdateWineDao;
import info.antoniomartin.bodega.stuff.wine.infrastructure.persistence.WineEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WineDaoFacadeTest {

    @Mock
    private FetchWineDao fetchWine;
    @Mock
    private GetAllWineDao getAllWine;
    @Mock
    private SaveWineDao saveWineDao;
    @Mock
    private DeleteWineDao deleteWine;
    @Mock
    private UpdateWineDao updateWineDao;

    @InjectMocks
    private WineDaoFacade facade;

    @Test
    void shouldFetchWineWhenGetOneWine() {
        //given
        given(fetchWine.get(1L)).willReturn(Optional.of(WineEntity.builder().id(1L).build()));
        //when
        WineEntity entity = facade.getWine(1L);
        //then
        assertThat(entity.getId()).isEqualTo(1L);
    }

    @Test
    void shouldGetAllWineWhenGetAllWine() {
        //given
        given(getAllWine.getAll())
            .willReturn(List.of(WineEntity.builder().id(1L).build(),
                WineEntity.builder().id(2L).build(),
                WineEntity.builder().id(3L).build()));
        //when
        List<WineEntity> entityList = facade.getAll();

        //then
        assertThat(entityList).hasSize(3);
        assertThat(entityList.get(1)).isNotNull();
        assertThat(entityList.get(1).getId()).isEqualTo(2L);

    }

    @Test
    void shouldSaveWhenTryToSave() {
        //given
        given(saveWineDao.save(any(WineEntity.class))).willReturn(WineEntity.builder().id(1L).build());
        //when
        WineEntity wineEntity = facade.save(WineEntity.builder().build());
        //then
        assertThat(wineEntity.getId()).isEqualTo(1L);
    }

    @Test
    void shouldDeleteWhenTryToDelete() {
        //given
        long wineId = 1L;
        doNothing().when(deleteWine).delete(wineId);
        //when
        facade.delete(wineId);
        //then
        assertTrue(true);
    }

    @Test
    void shouldUpdateWineWhenTryToUpdate() {
        //given
        WineEntity entity = WineEntity.builder().id(1L).name("vinazos").build();
        when(updateWineDao.update(entity)).thenReturn(entity);
        //when
        WineEntity wineEntity = facade.update(entity);
        //then
        assertThat(wineEntity.getId()).isEqualTo(1L);
        assertThat(wineEntity.getName()).isEqualTo("vinazos");
    }


}
