package tickets;

import java.util.PriorityQueue;
import javax.swing.JOptionPane;

public class LogicaTickets {

    private NodoLista primero;
    private PriorityQueue<NodoLista> pendientes;


    public LogicaTickets() {
        primero = null;
        pendientes = new PriorityQueue<>((a, b) -> a.getId() - b.getId());
    }

    public void crearTicket(String descripcion, String nombre) {
        NodoLista ticket = new NodoLista(descripcion, nombre);
        pendientes.add(ticket);
        JOptionPane.showMessageDialog(null, "Ticket número de ticket es: " + ticket.getId());
    }

    public void verFrente() {
        if (pendientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay tickets pendientes.");
            return;
        }
        JOptionPane.showMessageDialog(null, pendientes.peek().toString());
    }

    public void resolverTicket() {
        if (pendientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay tickets por resolver. ");
            return;
        }

        NodoLista ticket = pendientes.poll();
        ticket.resolver();

        if (primero == null) {
            primero = ticket;
        } else {
            NodoLista temp = primero;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(ticket);
        }

        JOptionPane.showMessageDialog(null, "Ticket número: " + ticket.getId() + " resuelto exitosamente.");
    }

    public void buscarTicket(int id) {
        NodoLista temp = primero;
        while (temp != null) {
            if (temp.getId() == id) {
                JOptionPane.showMessageDialog(null, temp.toString());
                return;
            }
            temp = temp.getSiguiente();
        }

        for (NodoLista ticket : pendientes) {
            if (ticket.getId() == id) {
                JOptionPane.showMessageDialog(null, "El ticket está pendiente de resolución.");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No existe ningún ticket con el identificador: " + id);
    }
}
