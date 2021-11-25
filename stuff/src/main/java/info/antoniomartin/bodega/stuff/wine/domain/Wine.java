package info.antoniomartin.bodega.stuff.wine.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public final class Wine {

    private final long id;
    private final String name;
    private final String bodega;
    private final String grape;
    private final String tannin;
    private final String ageing;
    private final String description;

}
