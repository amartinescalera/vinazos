package info.antoniomartin.bodega.stuff.region.infrastructure.rest.wine;

import info.antoniomartin.bodega.stuff.wine.application.WineResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
final class FetchWineRegionController {

    @GetMapping(value = "/region/wine/{name}")
    public ResponseEntity<WineResponse> fetchRegion(@PathVariable long name) {
        return ResponseEntity.ok(WineResponse.builder().name("Tierra Blanca").build());
    }
}
