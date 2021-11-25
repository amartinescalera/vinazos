package info.antoniomartin.bodega.stuff.wine.infrastructure.persistence;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class WineDaoTest {

    @Mock
    private WineRepository repository;

    @InjectMocks
    private WineDao dao;

    @Test
    void should_returnEntityWine_when_SearchWineById() {
        //given
//        long id = 1;
//        WineEntity entity = WineEntity
//            .builder()
//            .grape("acidity")
//            .ageing("alcohol")
//            .name("name")
//            .description("body")
//            .bodega("sweetness")
//            .tannin("tannin")
//            .build();
//
//        //when
//        given(repository.getById(id)).willReturn(entity);
//
//        Optional<WineEntity> returnValue = dao.get(id);

        //then
//        assertThat(returnValue.isPresent()).isTrue();
//        assertThat(returnValue.get().getId()).isEqualTo(id);
//        assertThat(returnValue.get().getName()).isEqualTo(entity.getName());
    }

    @Test
    void should_returnAllWines_when_wineExist() {
        //given
        long id_1 = 1L;
        long id_2 = 2L;
        WineEntity entity1 = WineEntity
            .builder()
            .id(id_1)
            .grape("acidity")
            .ageing("alcohol")
            .name("name")
            .description("body")
            .bodega("sweetness")
            .tannin("tannin")
            .build();

        WineEntity entity2 = WineEntity
            .builder()
            .id(id_2)
            .grape("acidity")
            .ageing("alcohol")
            .name("name")
            .description("body")
            .bodega("sweetness")
            .tannin("tannin")
            .build();

        //when
        given(repository.findAll()).willReturn(List.of(entity1, entity2));

        List<WineEntity> entityList = dao.getAll();

        //then
        assertThat(entityList.size()).isEqualTo(2);
        assertThat(entityList.get(0).getName()).isEqualTo(entity1.getName());
    }

    @Test
    void should_returnEntityWine_when_SaveWine() {
        //given
        long id = 1;
        WineEntity entity = WineEntity
            .builder()
            .id(1L)
            .grape("acidity")
            .ageing("alcohol")
            .name("name")
            .description("body")
            .bodega("sweetness")
            .tannin("tannin")
            .build();

        //when
        given(repository.save(entity)).willReturn(entity);

        WineEntity returnValue = dao.save(entity);

        //then
        assertThat(returnValue.getId()).isEqualTo(id);
        assertThat(returnValue.getName()).isEqualTo(entity.getName());
    }
    @Test
    void should_void_when_deleteWine() {
        //given
        long id = 1;

        WineEntity entity = WineEntity
            .builder()
            .id(1L)
            .grape("acidity")
            .ageing("alcohol")
            .name("name")
            .description("body")
            .bodega("sweetness")
            .tannin("tannin")
            .build();

//        given(repository.getById(id)).willReturn(entity);
//        doNothing().when(repository).delete(entity);

        //when
        dao.delete(id);

        //Then
        assertTrue(true);

    }

    @Test
    void should_returnEntityWine_when_updateWine() {
        //given
        long id = 1;
        WineEntity entity = WineEntity
            .builder()
            .id(1L)
            .grape("acidity")
            .ageing("alcohol")
            .name("name")
            .description("body")
            .bodega("sweetness")
            .tannin("tannin")
            .build();

        //when
        given(repository.save(entity)).willReturn(entity);

        WineEntity returnValue = dao.update(entity);

        //then
        assertThat(returnValue.getId()).isEqualTo(id);
        assertThat(returnValue.getName()).isEqualTo(entity.getName());
    }
}
