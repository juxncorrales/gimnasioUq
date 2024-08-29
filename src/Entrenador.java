public class Entrenador extends Usuario {
    private String especialidad;

    // Constructor
    public Entrenador(String identificacion, String nombre, String especialidad) {
        super(identificacion, nombre);
        this.especialidad = especialidad;
    }

    // Getters y Setters
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    // Método para actualizar la especialidad del entrenador

    public void actualizarEspecialidad(String nuevaEspecialidad) {
        this.especialidad = nuevaEspecialidad;
    }

    // Sobrescribir el método toString para una mejor representación del entrenador
    @Override
    public String toString() {
        return "Entrenador{" +
                "identificacion='" + getIdentificacion() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}
