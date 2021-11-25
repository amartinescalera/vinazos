package info.antoniomartin.bodega.basket.controller;

import info.antoniomartin.bodega.basket.model.Basket;
import info.antoniomartin.bodega.basket.model.Items;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class GetBasketController {

    @GetMapping("/basket")
    ResponseEntity<Basket> getBasket() {
        return ResponseEntity.ok(Basket.builder()
                .items(List.of(Items.builder().name("WINE-1").build(),
                    Items.builder().name("WINE-2").build()))
            .build());
    }
}
