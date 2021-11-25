package info.antoniomartin.bodega.stuff.region.infrastructure.persistence;

import info.antoniomartin.bodega.stuff.region.infrastructure.persistence.create.CreateRegionDao;
import info.antoniomartin.bodega.stuff.region.infrastructure.persistence.get.GetAllRegionDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public final class RegionDao implements CreateRegionDao, GetAllRegionDao {

    private final RegionRepository regionRepository;

    @Override
    public RegionEntity create(final RegionEntity entity) {
        return regionRepository.save(entity);
    }

    @Override
    public List<RegionEntity> getAll() {
        return regionRepository.findAll();
    }
}
