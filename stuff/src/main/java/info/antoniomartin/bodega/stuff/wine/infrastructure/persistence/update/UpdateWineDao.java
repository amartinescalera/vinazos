package info.antoniomartin.bodega.stuff.wine.infrastructure.persistence.update;

import info.antoniomartin.bodega.stuff.wine.infrastructure.persistence.WineEntity;

public interface UpdateWineDao {
    WineEntity update(WineEntity entity);
}
