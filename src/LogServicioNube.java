public class LogServicioNube implements DestinoLog{
    @Override
    public void guardarRegistro(String nivel, String mensaje) {
        System.out.println("Guardando registro en la nube..");
        System.out.println("Nivel: " + nivel);
        System.out.println("Mensaje: " + mensaje);
    }
}
