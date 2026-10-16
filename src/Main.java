public class Main {

    public static void main(String[] args) {

        GestorAuditoria gestor = new GestorAuditoria();

        gestor.agregarDestino(new LogArchivoLocal());
        gestor.agregarDestino(new LogBaseDatos());
        gestor.agregarDestino(new LogServicioNube());

        gestor.emitirRegistro(
                "CRITICO",
                "El servidor principal dejó de responder"
        );

    }

}
