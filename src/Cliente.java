public class Cliente extends Usuario {
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private String contrasena;

    // Constructor
    public Cliente(String identificacion, String nombre, String direccion, String telefono, String correoElectronico, String contrasena) {
        super(identificacion, nombre);
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
    }

    // Getters y Setters
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    // Método para actualizar la información del cliente

    public void actualizarInformacion(String direccion, String telefono, String correoElectronico, String contrasena) {
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
    }

    // Método para verificar la contraseña (útil para autenticación)

    public boolean verificarContrasena(String contrasena) {
        return this.contrasena.equals(contrasena);
    }

    // Sobrescribir el método toString para una mejor representación del cliente
    @Override
    public String toString() {
        return "Cliente{" +
                "identificacion='" + getIdentificacion() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                '}';
    }
}
