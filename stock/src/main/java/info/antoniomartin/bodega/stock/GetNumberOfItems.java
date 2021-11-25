package info.antoniomartin.bodega.stock;

import info.antoniomartin.bodega.stock.config.ItemsProperties;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class GetNumberOfItems {

    private final ItemsProperties itemsProperties;

    @GetMapping(value = "/items")
    public ResponseEntity<Integer> getAllWines() {
        return ResponseEntity.ok(itemsProperties.getWines());
    }
}
