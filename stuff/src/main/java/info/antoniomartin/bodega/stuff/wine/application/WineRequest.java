package info.antoniomartin.bodega.stuff.wine.application;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class WineRequest {

    private long id;
    private String name;
    private String grape;
    private String bodega;
    private String tannin;
    private String ageing;
    private String description;
}
