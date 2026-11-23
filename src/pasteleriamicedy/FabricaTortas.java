package pasteleriamicedy;

public class FabricaTortas extends FabricaPostres {
    @Override
    public Postre crearPostre() {
        return new TortaChocolate();
    }
}
