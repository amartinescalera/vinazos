package info.antoniomartin.bodega.stuff.region.infrastructure.rest.update;

import info.antoniomartin.bodega.stuff.region.application.RegionRequest;
import info.antoniomartin.bodega.stuff.region.application.RegionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
final class UpdateRegionController {

    @PutMapping(value = "/region")
    public ResponseEntity<RegionResponse> createRegion(@RequestBody RegionRequest request) {
        return ResponseEntity.ok(RegionResponse.builder().name(request.getName()).build());
    }
}
