package info.antoniomartin.bodega.stuff.region.domain;

import info.antoniomartin.bodega.stuff.region.application.exception.RegionMandatoryException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static info.antoniomartin.bodega.stuff.region.util.RegionUtils.REGION_2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@ExtendWith(MockitoExtension.class)
class AssertCheckMandatoryFieldsTest {

    @InjectMocks
    private AssertCheckMandatoryRegionFields assertCheck;

    @Test
    void should_doNothing_when_mandatoryFields() {
        //given
        @SuppressWarnings("Redundant")
        Region region = REGION_2;

        //when
        assertCheck.checksMandatoryFields(region);

        //then
        assertThat(region).isNotNull();

    }

    @Test
    void should_trowException_when_notMandatoryFields() {
        //given
        Region region = Region.builder().build();

        //when
        final Throwable throwable = catchThrowable(() -> assertCheck.checksMandatoryFields(region));

        //then
        assertThat(throwable).isInstanceOf(RegionMandatoryException.class)
            .hasMessage("The Region must include name, location and Country");

    }
} 
