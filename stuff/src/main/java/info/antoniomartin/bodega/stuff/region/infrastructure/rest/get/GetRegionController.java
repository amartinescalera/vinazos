package info.antoniomartin.bodega.stuff.region.infrastructure.rest.get;

import info.antoniomartin.bodega.stuff.region.application.RegionResponse;
import info.antoniomartin.bodega.stuff.region.application.get.GetRegion;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
final class GetRegionController {

    private final GetRegion getRegion;

    @GetMapping(value = "/region")
    ResponseEntity<List<RegionResponse>> getAllRegion() {
        return ResponseEntity.ok(getRegion.getAll());
    }


}
