package pasteleriamicedy;

/** Abstracción para registrar ventas sin acoplar el pedido a una caja concreta. */
public interface RegistradorVentas {
    void registrarVenta(double monto);
}
