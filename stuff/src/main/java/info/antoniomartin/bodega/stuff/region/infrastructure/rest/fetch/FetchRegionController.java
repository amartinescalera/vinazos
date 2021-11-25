package info.antoniomartin.bodega.stuff.region.infrastructure.rest.fetch;

import info.antoniomartin.bodega.stuff.region.application.RegionResponse;
import info.antoniomartin.bodega.stuff.region.application.fetch.FetchRegion;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
final class FetchRegionController {

    private final FetchRegion fetchRegion;

    @GetMapping(value = "/region/{id}")
    ResponseEntity<RegionResponse> fetchRegion(@PathVariable long id) {
        return ResponseEntity.ok(fetchRegion.get(id));
    }
}
