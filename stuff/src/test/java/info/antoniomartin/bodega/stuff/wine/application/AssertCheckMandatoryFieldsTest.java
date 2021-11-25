package info.antoniomartin.bodega.stuff.wine.application;

import info.antoniomartin.bodega.stuff.wine.application.exception.WineMandatoryException;
import info.antoniomartin.bodega.stuff.wine.domain.Wine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.catchThrowable;

@ExtendWith(MockitoExtension.class)
class AssertCheckMandatoryFieldsTest {

    @InjectMocks
    private AssertCheckMandatoryWineFields assertCheck;

    @Test
    void should_doNothing_when_mandatoryFields() {
        //given
        Wine wine = Wine.builder()
            .name("name")
            .build();

        //when
        assertCheck.checksMandatoryFields(wine);

        //then

    }

    @Test
    void should_trowException_when_notMandatoryFields() {
        //given
        long id = 1L;
        Wine wine = Wine.builder().build();

        //when
        final Throwable throwable = catchThrowable(() -> assertCheck.checksMandatoryFields(wine));

        //then
        Assertions.assertThat(throwable).isInstanceOf(WineMandatoryException.class)
            .hasMessage("The wine must include name");

    }

} 
