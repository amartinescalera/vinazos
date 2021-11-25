package info.antoniomartin.bodega.stuff.region.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public final class Region {

    private final long id;
    private final String name;
    private final String location;
    private final String country;
}
