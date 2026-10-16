public class LogBaseDatos implements DestinoLog{
    @Override
    public void guardarRegistro(String nivel, String mensaje) {
        System.out.println("Guardando en base de datos..");
        System.out.println("Nivel: " + nivel);
        System.out.println("Mensaje: " + mensaje);
    }
}
