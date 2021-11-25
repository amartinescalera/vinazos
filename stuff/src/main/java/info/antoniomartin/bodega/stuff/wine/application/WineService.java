package info.antoniomartin.bodega.stuff.wine.application;

import info.antoniomartin.bodega.stuff.wine.application.create.CreateWine;
import info.antoniomartin.bodega.stuff.wine.application.delete.DeleteWine;
import info.antoniomartin.bodega.stuff.wine.application.fetch.FetchWine;
import info.antoniomartin.bodega.stuff.wine.application.get.GetAllWine;
import info.antoniomartin.bodega.stuff.wine.application.update.UpdateWine;
import info.antoniomartin.bodega.stuff.wine.domain.Wine;
import info.antoniomartin.bodega.stuff.wine.infrastructure.persistence.WineEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
final class WineService implements FetchWine, GetAllWine, CreateWine, DeleteWine, UpdateWine {

    private final AssertCheckMandatoryWineFields assertCheckMandatoryFields;
    private final AssertIfWineExist assertIfWineExist;
    private final WineDaoFacade facade;
    private final WineMapper map;

    @Override
    public WineResponse getWine(final long id) {
        assertIfWineExist.checkIfExist(id);
        Wine wine = map.fromEntityToModel(facade.getWine(id));
        return map.fromModelToResponse(wine);
    }

    @Override
    public List<WineResponse> getAllWines() {
        List<Wine> wineList = facade.getAll().stream().map(map::fromEntityToModel).collect(Collectors.toList());
        return wineList.stream().map(map::fromModelToResponse).collect(Collectors.toList());
    }

    @Override
    public WineResponse createWine(final WineRequest request) {
        Wine wine = map.fromRequestToModel(request);
        assertCheckMandatoryFields.checksMandatoryFields(wine);
        WineEntity entity = facade.save(map.fromModelToEntity(wine));
        return map.fromModelToResponse(map.fromEntityToModel(entity));
    }

    @Override
    public void delete(final long id) {
        facade.delete(id);
    }

    @Override
    public WineResponse updateWine(final long id, final WineRequest request) {
        assertIfWineExist.checkIfExist(id);
        Wine wine = map.fromRequestToModel(request);
        assertCheckMandatoryFields.checksMandatoryFields(wine);
        Wine wineUpdated = map.fromEntityToModel(facade.update(map.fromModelToEntity(wine)));
        return map.fromModelToResponse(wineUpdated);
    }
}
