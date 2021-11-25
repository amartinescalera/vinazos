package info.antoniomartin.bodega.stuff.region.infrastructure.persistence.create;

import info.antoniomartin.bodega.stuff.region.infrastructure.persistence.RegionEntity;

public interface CreateRegionDao {
    RegionEntity create(RegionEntity entity);
}
