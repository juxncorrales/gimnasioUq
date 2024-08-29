import java.time.LocalDate;
import java.time.LocalTime;

public class Clase {
    private String id;
    private String nombre;
    private LocalTime horario;
    private int capacidad;
    private int cuposDisponibles;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;
    private TipoClase tipoClase;
    private Entrenador entrenador;

    // Constructor
    public Clase(String id, String nombre, LocalTime horario, int capacidad, LocalDate fechaInicio, LocalDate fechaFin, String estado, TipoClase tipoClase, Entrenador entrenador) {
        this.id = id;
        this.nombre = nombre;
        this.horario = horario;
        this.capacidad = capacidad;
        this.cuposDisponibles = capacidad; // Inicialmente, todos los cupos están disponibles
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.tipoClase = tipoClase;
        this.entrenador = entrenador;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getCuposDisponibles() {
        return cuposDisponibles;
    }

    public void setCuposDisponibles(int cuposDisponibles) {
        this.cuposDisponibles = cuposDisponibles;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TipoClase getTipoClase() {
        return tipoClase;
    }

    public void setTipoClase(TipoClase tipoClase) {
        this.tipoClase = tipoClase;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    // Método para incrementar los cupos disponibles
    public void incrementarCuposDisponibles() {
        if (cuposDisponibles < capacidad) {
            cuposDisponibles++;
        }
    }

    // Método para disminuir los cupos disponibles
    public void disminuirCuposDisponibles() {
        if (cuposDisponibles > 0) {
            cuposDisponibles--;
        }
    }

    // Sobrescribir el método toString para una mejor representación de la clase
    @Override
    public String toString() {
        return "Clase{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", horario=" + horario +
                ", capacidad=" + capacidad +
                ", cuposDisponibles=" + cuposDisponibles +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", estado='" + estado + '\'' +
                ", tipoClase=" + tipoClase.getNombre() + " (" + tipoClase.getId() + ")" +
                ", entrenador=" + entrenador.getNombre() + " (" + entrenador.getIdentificacion() + ")" +
                '}';
    }
}
