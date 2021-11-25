package info.antoniomartin.bodega.stuff.wine.infrastructure.persistence;

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
class WineDao implements FetchWineDao, GetAllWineDao, SaveWineDao, DeleteWineDao, UpdateWineDao {

    private final WineRepository repository;

    @Override
    public Optional<WineEntity> get(final long id) {
        return repository.findById(id);
    }

    @Override
    public List<WineEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public WineEntity save(final WineEntity entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(final long id) {
        Optional<WineEntity> optionalEntity = get(id);
        optionalEntity.ifPresent(repository::delete);
    }

    @Override
    public WineEntity update(final WineEntity entity) {
        return repository.save(entity);
    }
}
