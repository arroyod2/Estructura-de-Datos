import tickets.LogicaTickets;
import javax.swing.JOptionPane;

public class Main {

    static LogicaTickets aplicacion = new LogicaTickets();

    public static void main(String[] args) {
        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "Sistema de Gestiones " + "\n" + "1. Usuario\n" + "2. Administrador\n" + "0. Salir"));

            switch (opcion) {
                case 1:
                    menuUsuario();
                    break;
                case 2:
                    menuAdministrador();
                    break;
            }

        } while (opcion != 0);
    }

    public static void menuUsuario() {
        int opcionUsu = Integer.parseInt(JOptionPane.showInputDialog(
                "MENÚ USUARIO\n" + "1. Crear Ticket\n" + "2. Buscar Ticket"));

        if (opcionUsu == 1) {
            String nombre = JOptionPane.showInputDialog("Nombre: ");
            String descripcion = JOptionPane.showInputDialog("Descripción: ");
            aplicacion.crearTicket(descripcion, nombre);
        }

        if (opcionUsu == 2) {
            int id = Integer.parseInt(JOptionPane.showInputDialog("ID del ticket: "));
            aplicacion.buscarTicket(id);
        }
    }

    public static void menuAdministrador() {
        int opcionAdmin = Integer.parseInt(JOptionPane.showInputDialog(
                "MENÚ ADMINISTRADOR\n\n" + "1. Ver ticket al frente\n" + "2. Resolver ticket"));

        if (opcionAdmin == 1) aplicacion.verFrente();
        if (opcionAdmin == 2) aplicacion.resolverTicket();
    }
}