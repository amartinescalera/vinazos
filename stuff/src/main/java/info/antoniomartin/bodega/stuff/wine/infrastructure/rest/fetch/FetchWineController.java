package info.antoniomartin.bodega.stuff.wine.infrastructure.rest.fetch;

import info.antoniomartin.bodega.stuff.wine.application.fetch.FetchWine;
import info.antoniomartin.bodega.stuff.wine.application.WineResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
final class FetchWineController {

    private final FetchWine fetchWine;

    @GetMapping(value = "/wine/{id}")
    ResponseEntity<WineResponse> fetchWine(@PathVariable long id) {
        return ResponseEntity.ok(fetchWine.getWine(id));
    }
}
