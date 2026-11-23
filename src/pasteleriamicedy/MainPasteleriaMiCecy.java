package pasteleriamicedy;

public class MainPasteleriaMiCecy {
    public static void main(String[] args) {
        System.out.println("=== Bienvenidos a Pastelería Mi Cecy ===");

        // Las fábricas concretas crean distintos tipos de postres.
        FabricaPostres fabricaTortas = new FabricaTortas();
        FabricaPostres fabricaBocaditos = new FabricaBocaditos();
        Postre torta = fabricaTortas.crearPostre();
        Postre bocadito = fabricaBocaditos.crearPostre();
        fabricaTortas.prepararPostre();
        fabricaBocaditos.prepararPostre();

        // El Builder permite personalizar solo los datos necesarios.
        TortaPersonalizada tortaEncargo = new TortaPersonalizada.Builder()
                .conBizcocho("Red Velvet")
                .conRelleno("Fresa natural")
                .conPrecio(68.0)
                .build();
        System.out.println(tortaEncargo);

        // El pedido depende de una abstracción, no de la clase CajaPasteleria.
        RegistradorVentas caja = CajaPasteleria.getInstancia();
        PedidoPasteleria pedido = new PedidoPasteleria(caja);
        pedido.finalizarCobro(torta.getPrecioBase());
        pedido.finalizarCobro(bocadito.getPrecioBase());
        pedido.finalizarCobro(tortaEncargo.getPrecio());

        System.out.printf(java.util.Locale.US,
                "Total acumulado en caja hoy: S/ %.2f%n",
                CajaPasteleria.getInstancia().getTotalVentasDia());
    }
}
