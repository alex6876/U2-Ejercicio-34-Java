import java.util.ArrayList;

public class GestorAuditoria {

    ArrayList<DestinoLog>  destinos = new ArrayList<>();

    public void agregarDestino(DestinoLog destino) {
        destinos.add(destino);
    }

    public void emitirRegistro(String nivel, String mensaje) {
        for (DestinoLog destino : destinos) {
            destino.guardarRegistro(nivel, mensaje);
        }
    }
}
