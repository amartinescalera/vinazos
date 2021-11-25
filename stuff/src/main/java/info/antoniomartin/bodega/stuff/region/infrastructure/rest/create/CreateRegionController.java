package info.antoniomartin.bodega.stuff.region.infrastructure.rest.create;

import info.antoniomartin.bodega.stuff.region.application.RegionRequest;
import info.antoniomartin.bodega.stuff.region.application.RegionResponse;
import info.antoniomartin.bodega.stuff.region.application.create.CreateRegion;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
final class CreateRegionController {

    private final CreateRegion createRegion;

    @PostMapping(value = "/region")
    ResponseEntity<RegionResponse> createRegion(final @RequestBody RegionRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createRegion.Create(request));
    }
}
