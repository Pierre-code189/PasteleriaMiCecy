# Pastelería Mi Cecy

Proyecto Java de consola desarrollado en NetBeans. Fue construido con JDK 21 y
también compila desde Java 11 (`javac --release 11`).

## Temas implementados

- **Singleton:** `CajaPasteleria` mantiene una única instancia de la caja
  registradora. Usa inicialización estática segura entre hilos y métodos
  sincronizados para proteger el total de ventas.
- **Builder:** `TortaPersonalizada.Builder` configura una torta por pasos,
  conserva valores predeterminados e valida los datos ingresados.
- **Factory Method:** `FabricaPostres` declara el método abstracto
  `crearPostre()`; `FabricaTortas` y `FabricaBocaditos` lo implementan, cada una
  con su tipo de `Postre`.
- **Template Method:** `FabricaPostres.prepararPostre()` es el esqueleto fijo que
  invoca el hook `crearPostre()` y anuncia el producto en consola.

## Principios SOLID aplicados

- **S — Responsabilidad única:** `CajaPasteleria` administra el total de ventas,
  `PedidoPasteleria` procesa el cobro y las fábricas crean los productos.
- **O — Abierto/cerrado:** se pueden agregar nuevos productos implementando
  `Postre` y nuevas fábricas extendiendo `FabricaPostres`, sin modificar esas
  clases. La elección de la fábrica sigue haciéndose en `Main`.
- **L — Sustitución de Liskov:** `TortaChocolate` y `EmpanadaManjar` se usan
  indistintamente donde se espera un `Postre`.
- **I — Segregación de interfaces:** `Postre` y `RegistradorVentas` son
  contratos pequeños, con lo justo que necesitan sus clientes.
- **D — Inversión de dependencias:** `PedidoPasteleria` recibe un
  `RegistradorVentas` por constructor y no depende de la clase concreta para
  registrar el cobro.

## Ejecución

En NetBeans: abrir el proyecto y ejecutar
`pasteleriamicedy.MainPasteleriaMiCecy`.

Por terminal:

```bash
mkdir -p build/classes
javac -encoding UTF-8 -d build/classes $(find src -name '*.java')
java -cp build/classes pasteleriamicedy.MainPasteleriaMiCecy
```

Salida:

```
=== Bienvenidos a Pastelería Mi Cecy ===
Preparando en Pastelería Mi Cecy: Torta de Chocolate Casera (S/ 45.0)
Preparando en Pastelería Mi Cecy: Empanada de Manjarblanco (S/ 4.5)
Torta personalizada [bizcocho=Red Velvet, relleno=Fresa natural, cobertura=Buttercream suave, mensaje="¡Feliz día!", precio=S/ 68.00]
Total acumulado en caja hoy: S/ 117.50
```

Nota: `build.xml` importa `nbproject/build-impl.xml`, que NetBeans genera al abrir
el proyecto; sin el IDE conviene usar los comandos de arriba.
