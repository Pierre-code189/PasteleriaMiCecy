package pasteleriamicedy;

/** Caja única de la pastelería; concentra el registro y consulta de ventas. */
public final class CajaPasteleria implements RegistradorVentas {
    private static final CajaPasteleria INSTANCIA = new CajaPasteleria();
    private double totalVentasDia;

    private CajaPasteleria() { }

    public static CajaPasteleria getInstancia() {
        return INSTANCIA;
    }

    @Override
    public synchronized void registrarVenta(double monto) {
        if (monto < 0) {
            throw new IllegalArgumentException("El monto no puede ser negativo.");
        }
        totalVentasDia += monto;
    }

    public synchronized double getTotalVentasDia() {
        return totalVentasDia;
    }
}
