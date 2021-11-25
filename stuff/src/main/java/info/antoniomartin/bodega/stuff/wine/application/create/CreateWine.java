package info.antoniomartin.bodega.stuff.wine.application.create;

import info.antoniomartin.bodega.stuff.wine.application.WineRequest;
import info.antoniomartin.bodega.stuff.wine.application.WineResponse;

public interface CreateWine {
    WineResponse createWine(WineRequest request);
}
