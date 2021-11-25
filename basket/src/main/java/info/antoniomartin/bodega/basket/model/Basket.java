package info.antoniomartin.bodega.basket.model;


import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Basket {
    private final String sessionId;
    private final String userId;
    private final List<Items> items;
}
