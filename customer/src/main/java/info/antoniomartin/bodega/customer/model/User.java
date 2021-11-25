package info.antoniomartin.bodega.customer.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {
    private final String id;
    private final String name;
    private final String surname;
    private final String username;
    private final String password;

    private final int port;
}
