package info.antoniomartin.bodega.stock.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("number-of-items")
@Getter
@Setter
public class ItemsProperties {
    private int wines;
}
