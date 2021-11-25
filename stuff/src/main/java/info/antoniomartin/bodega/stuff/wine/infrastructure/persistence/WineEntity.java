package info.antoniomartin.bodega.stuff.wine.infrastructure.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "WINE")
public class WineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String bodega;
    private String grape;
    private String tannin;
    private String ageing;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(name = "region_id")
    private long regionId;
}
