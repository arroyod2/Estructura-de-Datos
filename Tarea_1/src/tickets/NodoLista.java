package tickets;

import java.time.LocalDateTime;

public class NodoLista {

    private static int cantidad = 1;

    private int id;
    private String descripcion;
    private String nombreCompleto;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaResolucion;
    private NodoLista siguiente;

    public NodoLista(String descripcion, String nombreCompleto) {
        this.id = cantidad++;
        this.descripcion = descripcion;
        this.nombreCompleto = nombreCompleto;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaResolucion = null;
        this.siguiente = null;
    }

    public static int getCantidad() {
        return cantidad;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public static void setCantidad(int cantidad) {
        NodoLista.cantidad = cantidad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaResolucion(LocalDateTime fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaResolucion() {
        return fechaResolucion;
    }

    public NodoLista getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(NodoLista siguiente) {
        this.siguiente = siguiente;
    }

    public void resolver() {

        fechaResolucion = LocalDateTime.now();
    }

    public String toString() {
        return "ID: " + id +
                "\nNombre: " + nombreCompleto +
                "\nDescripcion: " + descripcion +
                "\nFecha Creacion: " + fechaCreacion +
                "\nFecha Resolucion: " + fechaResolucion;
    }
}
