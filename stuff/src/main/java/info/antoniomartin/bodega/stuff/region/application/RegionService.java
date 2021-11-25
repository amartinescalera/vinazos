package info.antoniomartin.bodega.stuff.region.application;

import info.antoniomartin.bodega.stuff.region.application.create.CreateRegion;
import info.antoniomartin.bodega.stuff.region.application.fetch.FetchRegion;
import info.antoniomartin.bodega.stuff.region.application.get.GetRegion;
import info.antoniomartin.bodega.stuff.region.domain.AssertCheckMandatoryRegionFields;
import info.antoniomartin.bodega.stuff.region.domain.Region;
import info.antoniomartin.bodega.stuff.region.infrastructure.persistence.RegionEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
final class RegionService implements CreateRegion, GetRegion, FetchRegion {

    private final AssertCheckMandatoryRegionFields assertCheckMandatoryFields;
    private final RegionMapper mapper;
    private final RegionFacadeDao regionFacadeDao;

    @Override
    public RegionResponse Create(final RegionRequest request) {
        Region region = mapper.fromRequestToModel(request);
        assertCheckMandatoryFields.checksMandatoryFields(region);
        RegionEntity entity = regionFacadeDao.createRegion(mapper.fromModelToEntity(region));
        return mapper.fromModelToResponse(mapper.fromEntityToModel(entity));
    }

    @Override
    public List<RegionResponse> getAll() {
        return regionFacadeDao.getAll().stream()
            .map(mapper::fromEntityToModel)
            .map(mapper::fromModelToResponse)
            .collect(Collectors.toList());
    }

    @Override
    public RegionResponse get(final long id) {
        return mapper.fromModelToResponse(mapper.fromEntityToModel(regionFacadeDao.get(id)));
    }
}
