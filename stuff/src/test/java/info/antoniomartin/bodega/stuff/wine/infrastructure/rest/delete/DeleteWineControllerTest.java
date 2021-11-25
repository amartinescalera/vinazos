package info.antoniomartin.bodega.stuff.wine.infrastructure.rest.delete;

import info.antoniomartin.bodega.stuff.wine.application.delete.DeleteWine;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
class DeleteWineControllerTest {

    @InjectMocks
    private DeleteWineController deleteWineController;

    @Mock
    private DeleteWine deleteWine;

    @Test
    void should_deleteWine_when_delete() {
        //given
        doNothing().when(deleteWine).delete(1L);

        //when
        ResponseEntity<Void> response = deleteWineController.deleteWine(1L);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
