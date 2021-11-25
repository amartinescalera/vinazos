package info.antoniomartin.bodega.stuff.wine.application;

import info.antoniomartin.bodega.stuff.wine.infrastructure.persistence.WineEntity;
import info.antoniomartin.bodega.stuff.wine.infrastructure.persistence.delete.DeleteWineDao;
import info.antoniomartin.bodega.stuff.wine.infrastructure.persistence.fetch.FetchWineDao;
import info.antoniomartin.bodega.stuff.wine.infrastructure.persistence.get.GetAllWineDao;
import info.antoniomartin.bodega.stuff.wine.infrastructure.persistence.save.SaveWineDao;
import info.antoniomartin.bodega.stuff.wine.infrastructure.persistence.update.UpdateWineDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class WineDaoFacade {

    private final FetchWineDao fetchWine;
    private final GetAllWineDao getAllWine;
    private final SaveWineDao saveWineDao;
    private final DeleteWineDao deleteWine;
    private final UpdateWineDao updateWineDao;

    WineEntity getWine(final long id) {
        Optional<WineEntity> entity = fetchWine.get(id);
        return entity.orElseGet(() -> WineEntity.builder().build());
    }

    List<WineEntity> getAll() {
        return getAllWine.getAll();
    }

    WineEntity save(final WineEntity entity) {
        return saveWineDao.save(entity);
    }

    void delete(final long id) {
        deleteWine.delete(id);
    }

    WineEntity update(final WineEntity entity) {
        return updateWineDao.update(entity);
    }
}
