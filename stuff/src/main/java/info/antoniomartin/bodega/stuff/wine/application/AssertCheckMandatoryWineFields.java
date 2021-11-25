package info.antoniomartin.bodega.stuff.wine.application;

import info.antoniomartin.bodega.stuff.wine.application.exception.WineMandatoryException;
import info.antoniomartin.bodega.stuff.wine.domain.Wine;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@AllArgsConstructor
@Component
class AssertCheckMandatoryWineFields {

    void checksMandatoryFields(final Wine wine) {
        if (Objects.isNull(wine)
            || Objects.isNull(wine.getName())
            || wine.getName().isBlank()) {
            throw new WineMandatoryException("The wine must include name");
        }
    }
}
