package info.antoniomartin.bodega.stuff.region.application;

import info.antoniomartin.bodega.stuff.region.infrastructure.persistence.RegionEntity;
import info.antoniomartin.bodega.stuff.region.infrastructure.persistence.create.CreateRegionDao;
import info.antoniomartin.bodega.stuff.region.infrastructure.persistence.get.GetAllRegionDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
final class RegionFacadeDao {

    private final CreateRegionDao createRegionDao;
    private final GetAllRegionDao getAllRegionDao;

    RegionEntity createRegion(final RegionEntity entity) {
        return createRegionDao.create(entity);
    }

    List<RegionEntity> getAll() {
        return getAllRegionDao.getAll();
    }

    RegionEntity get(final long id) {
        return RegionEntity.builder().build();
    }
}

