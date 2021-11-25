package info.antoniomartin.bodega.stuff.region.application.create;

import info.antoniomartin.bodega.stuff.region.application.RegionRequest;
import info.antoniomartin.bodega.stuff.region.application.RegionResponse;

public interface CreateRegion {

    RegionResponse Create(RegionRequest request);
}
