package info.antoniomartin.bodega.stuff.wine.infrastructure.rest.create;

import info.antoniomartin.bodega.stuff.wine.application.create.CreateWine;
import info.antoniomartin.bodega.stuff.wine.application.WineRequest;
import info.antoniomartin.bodega.stuff.wine.application.WineResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
final class CreateWineController {

    private final CreateWine createWine;

    @PostMapping(value = "/wine")
    ResponseEntity<WineResponse> createWine(@RequestBody WineRequest request) {
        WineResponse response = createWine.createWine(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
