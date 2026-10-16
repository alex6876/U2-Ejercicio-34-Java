public class LogArchivoLocal implements DestinoLog{
    @Override
    public void guardarRegistro(String nivel, String mensaje) {
        System.out.println("Guardando en archivo local..");
        System.out.println("Nivel: " + nivel);
        System.out.println("Mensaje: " + mensaje);
    }
}
