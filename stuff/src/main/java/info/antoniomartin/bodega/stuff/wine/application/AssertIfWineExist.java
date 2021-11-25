package info.antoniomartin.bodega.stuff.wine.application;

import info.antoniomartin.bodega.stuff.wine.application.exception.WineNotFoundException;
import info.antoniomartin.bodega.stuff.wine.infrastructure.persistence.WineEntity;
import info.antoniomartin.bodega.stuff.wine.infrastructure.persistence.fetch.FetchWineDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.springframework.util.Assert.notNull;

@AllArgsConstructor
@Component
class AssertIfWineExist {

    private final FetchWineDao fetchWineDao;

    void checkIfExist(final Long wineId) {
        notNull(wineId, "The Wine Id cannot be null");
        final Optional<WineEntity> wine = fetchWineDao.get(wineId);
        if (wine.isEmpty()) {
            throw new WineNotFoundException("Wine not found");
        }
    }
}
