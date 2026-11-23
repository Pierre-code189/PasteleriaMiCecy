package pasteleriamicedy;

/** Producto inmutable que se configura mediante su constructor interno Builder. */
public class TortaPersonalizada {
    private final String bizcocho;
    private final String relleno;
    private final String cobertura;
    private final String mensaje;
    private final double precio;

    private TortaPersonalizada(Builder builder) {
        bizcocho = builder.bizcocho;
        relleno = builder.relleno;
        cobertura = builder.cobertura;
        mensaje = builder.mensaje;
        precio = builder.precio;
    }

    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return "Torta personalizada [bizcocho=" + bizcocho + ", relleno=" + relleno
                + ", cobertura=" + cobertura + ", mensaje=\"" + mensaje
                + "\", precio=S/ " + String.format(java.util.Locale.US, "%.2f", precio) + "]";
    }

    public static class Builder {
        private String bizcocho = "Vainilla clásico";
        private String relleno = "Manjar de la casa";
        private String cobertura = "Buttercream suave";
        private String mensaje = "¡Feliz día!";
        private double precio = 50.0;

        public Builder conBizcocho(String valor) { bizcocho = textoValido(valor, "bizcocho"); return this; }
        public Builder conRelleno(String valor) { relleno = textoValido(valor, "relleno"); return this; }
        public Builder conCobertura(String valor) { cobertura = textoValido(valor, "cobertura"); return this; }
        public Builder conMensaje(String valor) { mensaje = textoValido(valor, "mensaje"); return this; }

        public Builder conPrecio(double valor) {
            if (!Double.isFinite(valor) || valor <= 0) {
                throw new IllegalArgumentException("El precio debe ser mayor que cero.");
            }
            precio = valor;
            return this;
        }

        private String textoValido(String valor, String campo) {
            if (valor == null || valor.isBlank()) {
                throw new IllegalArgumentException("El campo " + campo + " no puede estar vacío.");
            }
            return valor.trim();
        }

        public TortaPersonalizada build() { return new TortaPersonalizada(this); }
    }
}
