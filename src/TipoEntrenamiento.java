public class TipoEntrenamiento {
    private String id;
    private String nombre;
    private String descripcion;

    // Constructor
    public TipoEntrenamiento(String id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Método para actualizar el tipo de entrenamiento
    public void actualizarTipoEntrenamiento(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Sobrescribir el método toString para una mejor representación del tipo de entrenamiento
    @Override
    public String toString() {
        return "TipoEntrenamiento{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
