package info.antoniomartin.bodega.stuff.region.application;

import info.antoniomartin.bodega.stuff.region.domain.Region;
import info.antoniomartin.bodega.stuff.region.infrastructure.persistence.RegionEntity;
import info.antoniomartin.bodega.stuff.shared.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
final class RegionMapper implements Mapper<Region, RegionEntity, RegionRequest, RegionResponse> {

    @Override
    public Region fromRequestToModel(RegionRequest request) {
        return Region.builder()
            .id(request.getId())
            .name(request.getName())
            .country(request.getCountry())
            .location(request.getLocation())
            .build();
    }

    @Override
    public RegionEntity fromModelToEntity(final Region region) {
        return RegionEntity.builder()
            .id(region.getId())
            .name(region.getName())
            .country(region.getCountry())
            .location(region.getLocation())
            .build();
    }

    @Override
    public Region fromEntityToModel(final RegionEntity regionEntity) {
        return Region.builder()
            .id(regionEntity.getId())
            .name(regionEntity.getName())
            .country(regionEntity.getCountry())
            .location(regionEntity.getLocation())
            .build();
    }

    @Override
    public RegionResponse fromModelToResponse(final Region region) {
        return RegionResponse.builder()
            .id(region.getId())
            .name(region.getName())
            .country(region.getCountry())
            .location(region.getLocation())
            .build();
    }
}
