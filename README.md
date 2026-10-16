# 📋 Simulación de Sistema de Auditoría y Logs Multidestino (Interfaces y Polimorfismo en Java)

Este proyecto es una aplicación en Java que modela un sistema centralizado de registros y auditoría capaz de despachar alertas simultáneamente hacia múltiples destinos de almacenamiento (Archivos locales, Bases de datos y Servicios en la Nube). Pone en práctica conceptos avanzados de la **Programación Orientada a Objetos (POO)** como **interfaces**, **polimorfismo**, colecciones dinámicas y el patrón de diseño **Observer / Strategy** en memoria.

---

## 🧩 Clases y Estructura del Sistema

El diseño del software se compone de un contrato contractual por interfaz, múltiples implementaciones especializadas y un gestor centralizador:

*   **`DestinoLog` (Interfaz)**: Define el contrato genérico que todo destino de registro debe cumplir mediante el método `guardarRegistro(String nivel, String mensaje)`.
*   **`LogArchivoLocal`**: Modela el almacenamiento de logs en un archivo físico local del sistema.
*   **`LogBaseDatos`**: Modela el registro de auditoría orientado a tablas o motores de bases de datos.
*   **`LogServicioNube`**: Modela el envío y sincronización de eventos de auditoría hacia plataformas de infraestructura cloud.
*   **`GestorAuditoria`**: Actúa como el orquestador principal del sistema de logs.
    *   **Atributos:** Mantiene una colección dinámica `ArrayList<DestinoLog>` para registrar los destinos activos.
    *   **Métodos principales:**
        *   `agregarDestino(DestinoLog destino)`: Permite incorporar dinámicamente nuevos canales de salida al gestor.
        *   `emitirRegistro(String nivel, String mensaje)`: Recorre la colección completa de destinos mediante un bucle, propagando el evento de forma polimórfica a cada uno de ellos.
*   **`Main`**: Punto de entrada del programa. Configura el gestor de auditoría, registra los tres destinos disponibles y simula la emisión de una alerta crítica de sistema.

---

## ⚙️ Conceptos Clave de POO Aplicados

1. **Polimorfismo por Interfaces:** El `GestorAuditoria` manipula objetos de clases completamente diferentes (`LogArchivoLocal`, `LogBaseDatos`, `LogServicioNube`) de manera totalmente uniforme a través del tipo genérico `DestinoLog`.
2. **Composición y Colecciones Dinámicas (`ArrayList`):** Permite registrar y modularizar la cantidad de salidas activas sin acoplar el código central a implementaciones específicas.
3. **Principio Abierto/Cerrado (OCP):** Es posible añadir nuevos destinos de log (ej. `LogConsolaRemota`, `LogFilaMensajeria`) creando nuevas clases que implementen la interfaz `DestinoLog`, sin necesidad de alterar la lógica de difusión del gestor.
4. **Desacoplamiento de Componentes:** La lógica encargada de emitir la alerta ignora por completo cómo procesa o almacena internamente cada destino el mensaje recibido.

---

## 💻 Salida por Consola

Al ejecutar la clase `Main`, el programa genera el siguiente resultado:

```text
Guardando en archivo local..
Nivel: CRITICO
Mensaje: El servidor principal dejó de responder
Guardando en base de datos..
Nivel: CRITICO
Mensaje: El servidor principal dejó de responder
Guardando registro en la nube..
Nivel: CRITICO
Mensaje: El servidor principal dejó de responder
