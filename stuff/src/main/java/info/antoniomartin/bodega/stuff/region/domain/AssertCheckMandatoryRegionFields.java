package info.antoniomartin.bodega.stuff.region.domain;

import info.antoniomartin.bodega.stuff.region.application.exception.RegionMandatoryException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@AllArgsConstructor
@Component
public final class AssertCheckMandatoryRegionFields {

    public void checksMandatoryFields(final Region region) {
        if (Objects.isNull(region)
            || Objects.isNull(region.getName())
            || region.getName().isBlank()
            || Objects.isNull(region.getLocation())
            || region.getLocation().isBlank()
            || Objects.isNull(region.getCountry())
            || region.getCountry().isBlank()) {
            throw new RegionMandatoryException("The Region must include name, location and Country");
        }
    }
}
