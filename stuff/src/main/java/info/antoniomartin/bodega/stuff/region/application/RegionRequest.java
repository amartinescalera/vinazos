package info.antoniomartin.bodega.stuff.region.application;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RegionRequest {

        private final long id;
        private final String name;
        private final String location;
        private final String country;

}
