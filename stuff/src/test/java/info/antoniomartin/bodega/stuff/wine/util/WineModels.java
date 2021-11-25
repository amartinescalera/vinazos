package info.antoniomartin.bodega.stuff.wine.util;

import info.antoniomartin.bodega.stuff.wine.application.WineRequest;
import info.antoniomartin.bodega.stuff.wine.application.WineResponse;

public class WineModels {

    public static final String GARUM_BODY = "Se caracteriza por un color granate capa media- alta. " +
        "En nariz es intenso y franco, con recuerdos a sotobosque, fruta roja madura, especias, " +
        "cerezas, café y cacao. Se caracteriza por un tanino dulce que lo hace sedoso pero potente, " +
        "de un postgusto tostado y caféico. Los vinos de margas yesíferas son amplios y de largos postgustos.";

    public static final WineRequest WINE_BEFORE_SAVED = WineRequest.builder()
        .bodega("acidity")
        .ageing("alcohol")
        .name("Garum")
        .description(GARUM_BODY)
        .grape("sweetness")
        .tannin("dulce")
        .build();

    public static final WineResponse WINE_AFTER_SAVED = WineResponse.builder()
        .id(1L)
        .bodega("acidity")
        .ageing("alcohol")
        .name("Garum")
        .description(GARUM_BODY)
        .grape("sweetness")
        .tannin("dulce")
        .build();
}
