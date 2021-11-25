package info.antoniomartin.bodega.stuff.shared;

public interface Mapper<M, E, I, O> {

    M fromRequestToModel(final I i);

    E fromModelToEntity(final M m);

    M fromEntityToModel(final E e);

    O fromModelToResponse(final M m);
}
