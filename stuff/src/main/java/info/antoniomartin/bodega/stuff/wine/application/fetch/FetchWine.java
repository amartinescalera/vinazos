package info.antoniomartin.bodega.stuff.wine.application.fetch;

import info.antoniomartin.bodega.stuff.wine.application.WineResponse;

public interface FetchWine {
    WineResponse getWine(long id);
}
