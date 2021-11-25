package info.antoniomartin.bodega.stuff.wine.infrastructure.persistence.save;

import info.antoniomartin.bodega.stuff.wine.infrastructure.persistence.WineEntity;

public interface SaveWineDao {
    WineEntity save(WineEntity entity);
}
