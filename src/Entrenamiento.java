import java.time.LocalDate;

public class Entrenamiento {
    private String id;
    private String tipoEjercicio;
    private int duracion; // En minutos
    private int caloriasQuemadas;
    private LocalDate fecha;
    private Cliente cliente;

    // Constructor
    public Entrenamiento(String id, String tipoEjercicio, int duracion, int caloriasQuemadas, String fecha, Cliente cliente) {
        this.id = id;
        this.tipoEjercicio = tipoEjercicio;
        this.duracion = duracion;
        this.caloriasQuemadas = caloriasQuemadas;
        this.fecha = LocalDate.parse(fecha);
        this.cliente = cliente;
    }

    public Entrenamiento(String tipoEjercicio, int duracion, int caloriasQuemadas, Cliente usuario) {
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoEjercicio() {
        return tipoEjercicio;
    }

    public void setTipoEjercicio(String tipoEjercicio) {
        this.tipoEjercicio = tipoEjercicio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getCaloriasQuemadas() {
        return caloriasQuemadas;
    }

    public void setCaloriasQuemadas(int caloriasQuemadas) {
        this.caloriasQuemadas = caloriasQuemadas;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = LocalDate.parse(fecha);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Método para actualizar los detalles del entrenamiento
    public void actualizarEntrenamiento(String tipoEjercicio, int duracion, int caloriasQuemadas, String fecha) {
        this.tipoEjercicio = tipoEjercicio;
        this.duracion = duracion;
        this.caloriasQuemadas = caloriasQuemadas;
        this.fecha = LocalDate.parse(fecha);
    }

    // Sobrescribir el método toString para una mejor representación del entrenamiento
    @Override
    public String toString() {
        return "Entrenamiento{" +
                "id='" + id + '\'' +
                ", tipoEjercicio='" + tipoEjercicio + '\'' +
                ", duracion=" + duracion +
                " minutos, caloriasQuemadas=" + caloriasQuemadas +
                ", fecha=" + fecha +
                ", cliente=" + cliente.getNombre() + " (" + cliente.getIdentificacion() + ")" +
                '}';
    }
}
