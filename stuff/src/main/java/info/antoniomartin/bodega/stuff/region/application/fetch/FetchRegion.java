package info.antoniomartin.bodega.stuff.region.application.fetch;

import info.antoniomartin.bodega.stuff.region.application.RegionResponse;

public interface FetchRegion {
    RegionResponse get(long id);
}
