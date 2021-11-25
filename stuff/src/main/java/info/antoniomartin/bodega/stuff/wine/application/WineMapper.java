package info.antoniomartin.bodega.stuff.wine.application;

import info.antoniomartin.bodega.stuff.shared.Mapper;
import info.antoniomartin.bodega.stuff.wine.domain.Wine;
import info.antoniomartin.bodega.stuff.wine.infrastructure.persistence.WineEntity;
import org.springframework.stereotype.Component;

@Component
public final class WineMapper implements Mapper<Wine, WineEntity, WineRequest, WineResponse> {

    @Override
    public Wine fromEntityToModel(final WineEntity wineEntity) {
        return Wine.builder()
            .id(wineEntity.getId())
            .name(wineEntity.getName())
            .bodega(wineEntity.getBodega())
            .grape(wineEntity.getGrape())
            .tannin(wineEntity.getTannin())
            .ageing(wineEntity.getAgeing())
            .description(wineEntity.getDescription())
            .build();
    }

    @Override
    public WineResponse fromModelToResponse(final Wine wine) {
        return WineResponse.builder()
            .id(wine.getId())
            .name(wine.getName())
            .grape(wine.getBodega())
            .bodega(wine.getGrape())
            .tannin(wine.getTannin())
            .ageing(wine.getAgeing())
            .description(wine.getDescription())
            .build();
    }

    @Override
    public Wine fromRequestToModel(final WineRequest wineRequest) {
        return Wine.builder()
            .name(wineRequest.getName())
            .bodega(wineRequest.getGrape())
            .grape(wineRequest.getBodega())
            .tannin(wineRequest.getTannin())
            .ageing(wineRequest.getAgeing())
            .description(wineRequest.getDescription())
            .build();
    }

    @Override
    public WineEntity fromModelToEntity(final Wine wine) {
        return WineEntity.builder()
            .id(wine.getId())
            .name(wine.getName())
            .bodega(wine.getBodega())
            .grape(wine.getGrape())
            .tannin(wine.getTannin())
            .ageing(wine.getAgeing())
            .description(wine.getDescription())
            .build();
    }


}
