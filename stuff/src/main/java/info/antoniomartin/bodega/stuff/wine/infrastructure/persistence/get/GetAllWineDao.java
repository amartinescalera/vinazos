package info.antoniomartin.bodega.stuff.wine.infrastructure.persistence.get;

import info.antoniomartin.bodega.stuff.wine.infrastructure.persistence.WineEntity;

import java.util.List;

public interface GetAllWineDao {
    List<WineEntity> getAll();
}
