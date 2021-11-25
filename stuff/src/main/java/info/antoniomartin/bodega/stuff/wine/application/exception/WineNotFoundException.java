package info.antoniomartin.bodega.stuff.wine.application.exception;

public class WineNotFoundException extends RuntimeException {

    public WineNotFoundException(final String s) {
        super(s);
    }
}
