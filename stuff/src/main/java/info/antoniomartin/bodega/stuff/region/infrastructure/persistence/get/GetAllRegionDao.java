package info.antoniomartin.bodega.stuff.region.infrastructure.persistence.get;

import info.antoniomartin.bodega.stuff.region.infrastructure.persistence.RegionEntity;

import java.util.List;

public interface GetAllRegionDao {
    List<RegionEntity> getAll();
}
