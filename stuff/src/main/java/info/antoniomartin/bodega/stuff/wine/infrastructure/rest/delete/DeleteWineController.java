package info.antoniomartin.bodega.stuff.wine.infrastructure.rest.delete;

import info.antoniomartin.bodega.stuff.wine.application.delete.DeleteWine;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
final class DeleteWineController {

    private final DeleteWine deleteWine;

    @DeleteMapping("/wine/{id}")
    ResponseEntity<Void> deleteWine(@PathVariable long id) {
        deleteWine.delete(id);
        return ResponseEntity.ok().build();
    }
}
