package info.antoniomartin.bodega.stuff.wine.application;

import info.antoniomartin.bodega.stuff.wine.application.exception.WineNotFoundException;
import info.antoniomartin.bodega.stuff.wine.domain.Wine;
import info.antoniomartin.bodega.stuff.wine.infrastructure.persistence.WineEntity;
import info.antoniomartin.bodega.stuff.wine.infrastructure.persistence.fetch.FetchWineDao;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AssertIfWineExistTest {

    @Mock
    private FetchWineDao fetchWineDao;

    @InjectMocks
    private AssertIfWineExist assertIfWineExist;

    @Test
    void should_doNothing_when_wineExist() {
        //given
        final long id = 1L;
        final Wine wine = Wine.builder()
            .id(id)
            .name("name")
            .build();

        final WineEntity entity = WineEntity.builder()
            .id(id)
            .name("name")
            .build();

        given(fetchWineDao.get(id)).willReturn(Optional.of(entity));

        //when
        assertIfWineExist.checkIfExist(id);

        //then

    }

    @Test
    void should_trowException_when_notMandatoryFields() {
        //given
        long id = 1L;
        given(fetchWineDao.get(id)).willReturn(Optional.empty());

        //when
        final Throwable throwable = catchThrowable(() -> assertIfWineExist.checkIfExist(id));

        //then
        Assertions.assertThat(throwable).isInstanceOf(WineNotFoundException.class)
            .hasMessage("Wine not found");
    }

    @Test
    void should_trowException_when_null() {
        //given

        //when
        final Throwable throwable = catchThrowable(() -> assertIfWineExist.checkIfExist(null));

        //then
        Assertions.assertThat(throwable).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("The Wine Id cannot be null");
    }
} 
