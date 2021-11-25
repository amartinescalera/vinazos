package info.antoniomartin.bodega.stuff.region.util;

import info.antoniomartin.bodega.stuff.region.application.RegionRequest;
import info.antoniomartin.bodega.stuff.region.application.RegionResponse;
import info.antoniomartin.bodega.stuff.region.domain.Region;
import info.antoniomartin.bodega.stuff.region.infrastructure.persistence.RegionEntity;

public class RegionUtils {

    public static final RegionEntity REGION_ENTITY_1 = RegionEntity.builder()
        .id(1L)
        .name("La Rioja")
        .location("Rioja")
        .country("España")
        .build();

    public static final RegionEntity REGION_ENTITY_2 = RegionEntity.builder()
        .id(2L)
        .name("Tierra de Cadiz")
        .location("Andalucia")
        .country("España")
        .build();

    public static final Region REGION_1 = Region.builder()
        .id(1L)
        .name("La Rioja")
        .location("Rioja")
        .country("España")
        .build();

    public static final Region REGION_2 = Region.builder()
        .id(2L)
        .name("Tierra de Cadiz")
        .location("Andalucia")
        .country("España")
        .build();

    public static final RegionResponse REGION_RESPONSE_1 = RegionResponse.builder()
        .id(1L)
        .name("La Rioja")
        .location("Rioja")
        .country("España")
        .build();

    public static final RegionResponse REGION_RESPONSE_2 = RegionResponse.builder()
        .id(2L)
        .name("Tierra de Cadiz")
        .location("Andalucia")
        .country("España")
        .build();

    public static final RegionRequest REGION_REQUEST_1 = RegionRequest.builder()
        .id(1L)
        .name("La Rioja")
        .location("Rioja")
        .country("España")
        .build();

    public static final RegionRequest REGION_REQUEST_2 = RegionRequest.builder()
        .id(2L)
        .name("Tierra de Cadiz")
        .location("Andalucia")
        .country("España")
        .build();
}
