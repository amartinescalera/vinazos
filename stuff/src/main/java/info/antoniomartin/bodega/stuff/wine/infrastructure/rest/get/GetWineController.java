package info.antoniomartin.bodega.stuff.wine.infrastructure.rest.get;

import info.antoniomartin.bodega.stuff.wine.application.get.GetAllWine;
import info.antoniomartin.bodega.stuff.wine.application.WineResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
final class GetWineController {

    private final GetAllWine getAllWine;

    @GetMapping(value = "/wines")
    public ResponseEntity<List<WineResponse>> getAllWines() {
        return ResponseEntity.ok(getAllWine.getAllWines());
    }
}
