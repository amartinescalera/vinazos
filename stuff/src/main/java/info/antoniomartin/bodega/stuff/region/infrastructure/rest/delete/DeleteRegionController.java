package info.antoniomartin.bodega.stuff.region.infrastructure.rest.delete;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
final class DeleteRegionController {

    @DeleteMapping("/region/{id}")
    ResponseEntity<Void> deleteRegion(@PathVariable long id) {
        return ResponseEntity.ok().build();
    }
}
