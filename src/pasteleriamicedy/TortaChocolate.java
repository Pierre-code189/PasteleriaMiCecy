package pasteleriamicedy;

public class TortaChocolate implements Postre {
    @Override
    public String getNombre() {
        return "Torta de Chocolate Casera";
    }

    @Override
    public double getPrecioBase() {
        return 45.0;
    }
}
