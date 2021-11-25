package info.antoniomartin.bodega.stuff.region.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface RegionRepository extends JpaRepository<RegionEntity, Long> {
}
