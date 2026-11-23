package pasteleriamicedy;

public class FabricaBocaditos extends FabricaPostres {
    @Override
    public Postre crearPostre() {
        return new EmpanadaManjar();
    }
}
