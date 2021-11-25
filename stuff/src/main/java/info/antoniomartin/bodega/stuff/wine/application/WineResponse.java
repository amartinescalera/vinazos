package info.antoniomartin.bodega.stuff.wine.application;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class WineResponse {

    private final Long id;
    private final String name;
    private final String grape;
    private final String bodega;
    private final String tannin;
    private final String ageing;
    private final String description;
}
