package info.antoniomartin.bodega.stuff.wine.application.update;

import info.antoniomartin.bodega.stuff.wine.application.WineRequest;
import info.antoniomartin.bodega.stuff.wine.application.WineResponse;

public interface UpdateWine {
    WineResponse updateWine(long id, WineRequest request);
}
