package pasteleriamicedy;

/** Define el método de creación que implementará cada fábrica concreta. */
public abstract class FabricaPostres {
    public abstract Postre crearPostre();

    public void prepararPostre() {
        Postre postre = crearPostre();
        System.out.println("Preparando en Pastelería Mi Cecy: "
                + postre.getNombre() + " (S/ " + postre.getPrecioBase() + ")");
    }
}
