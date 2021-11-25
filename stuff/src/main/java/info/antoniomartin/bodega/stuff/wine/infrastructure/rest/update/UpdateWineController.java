package info.antoniomartin.bodega.stuff.wine.infrastructure.rest.update;

import info.antoniomartin.bodega.stuff.wine.application.update.UpdateWine;
import info.antoniomartin.bodega.stuff.wine.application.WineRequest;
import info.antoniomartin.bodega.stuff.wine.application.WineResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
final class UpdateWineController {

    private final UpdateWine updateWine;

    @PutMapping(value = "/wine/{id}")
    ResponseEntity<WineResponse> updateWine(@PathVariable Long id, @RequestBody WineRequest request) {
        return ResponseEntity.ok(updateWine.updateWine(id, request));
    }
}
