import java.time.LocalDateTime;

public class Reserva {
    private String id;
    private Clase clase;
    private Cliente cliente;
    private LocalDateTime fechaReserva;

    // Constructor
    public Reserva(String id, Clase clase, Cliente cliente, String fechaReserva) {
        this.id = id;
        this.clase = clase;
        this.cliente = cliente;
        this.fechaReserva = LocalDateTime.parse(fechaReserva);
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = LocalDateTime.parse(fechaReserva);
    }

    // Método para cancelar la reserva
    public void cancelarReserva() {
        if (clase != null) {
            clase.incrementarCuposDisponibles();  // Se asume que la clase tiene un método para incrementar los cupos disponibles
        }
        // Aquí puedes agregar lógica adicional para eliminar la reserva de una lista de reservas si es necesario
    }

    // Sobrescribir el método toString para una mejor representación de la reserva
    @Override
    public String toString() {
        return "Reserva{" +
                "id='" + id + '\'' +
                ", clase=" + clase.getNombre() + " (" + clase.getId() + ")" +
                ", cliente=" + cliente.getNombre() + " (" + cliente.getIdentificacion() + ")" +
                ", fechaReserva=" + fechaReserva +
                '}';
    }
}
