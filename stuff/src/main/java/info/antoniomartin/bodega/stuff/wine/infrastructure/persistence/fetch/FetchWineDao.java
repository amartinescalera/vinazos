package info.antoniomartin.bodega.stuff.wine.infrastructure.persistence.fetch;

import info.antoniomartin.bodega.stuff.wine.infrastructure.persistence.WineEntity;

import java.util.Optional;

public interface FetchWineDao {
    Optional<WineEntity> get(long id);
}
