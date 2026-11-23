package pasteleriamicedy;

/** Representa un pedido y delega el registro de su cobro. */
public class PedidoPasteleria {
    private final RegistradorVentas registrador;

    public PedidoPasteleria(RegistradorVentas registrador) {
        if (registrador == null) {
            throw new IllegalArgumentException("Se requiere un registrador de ventas.");
        }
        this.registrador = registrador;
    }

    public double finalizarCobro(double monto) {
        if (monto < 0) {
            throw new IllegalArgumentException("El monto no puede ser negativo.");
        }
        registrador.registrarVenta(monto);
        return monto;
    }
}
