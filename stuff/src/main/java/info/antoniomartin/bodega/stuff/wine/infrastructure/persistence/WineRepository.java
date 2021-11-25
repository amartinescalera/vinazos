package info.antoniomartin.bodega.stuff.wine.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface WineRepository extends JpaRepository<WineEntity, Long> {
}
