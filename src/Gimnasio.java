import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Gimnasio {
    private List<Usuario> usuarios;
    private List<Clase> clases;
    private List<Reserva> reservas;
    private List<Entrenamiento> entrenamientos;

    // Constructor
    public Gimnasio() {
        this.usuarios = new ArrayList<>();
        this.clases = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.entrenamientos = new ArrayList<>();
    }

    // Métodos para gestionar usuarios

    public void registrarUsuario(String identificacion, String nombre, String direccion, String telefono, String correoElectronico, String contrasena) {
        if (buscarUsuarioPorIdentificacion(identificacion) == null) {
            Usuario usuario = new Cliente(identificacion, nombre, direccion, telefono, correoElectronico, contrasena);
            usuarios.add(usuario);
        } else {
            throw new IllegalArgumentException("Usuario con identificación " + identificacion + " ya existe.");
        }
    }

    public void actualizarDatosUsuario(String identificacion, String nombre, String direccion, String telefono, String correoElectronico, String contrasena) {
        Usuario usuario = buscarUsuarioPorIdentificacion(identificacion);
        if (usuario != null) {
            usuario.actualizarDatos(nombre, direccion, telefono, correoElectronico, contrasena);
        } else {
            throw new IllegalArgumentException("Usuario con identificación " + identificacion + " no encontrado.");
        }
    }

    public void eliminarUsuario(String identificacion) {
        Usuario usuario = buscarUsuarioPorIdentificacion(identificacion);
        if (usuario != null) {
            usuarios.remove(usuario);
            // Eliminar reservas y entrenamientos del usuario si es necesario
            reservas.removeIf(reserva -> reserva.getCliente().getIdentificacion().equals(identificacion));
            entrenamientos.removeIf(entrenamiento -> entrenamiento.getCliente().getIdentificacion().equals(identificacion));
        } else {
            throw new IllegalArgumentException("Usuario con identificación " + identificacion + " no encontrado.");
        }
    }

    private Usuario buscarUsuarioPorIdentificacion(String identificacion) {
        return usuarios.stream()
                .filter(u -> u.getIdentificacion().equals(identificacion))
                .findFirst()
                .orElse(null);
    }

    // Métodos para gestionar clases
    public void registrarClase(String id, String nombre, LocalTime horario, int capacidad, LocalDate fechaInicio, LocalDate fechaFin, String estado, TipoClase tipoClase, Entrenador entrenador) {
        if (buscarClasePorId(id) == null) {
            Clase nuevaClase = new Clase(id, nombre, horario, capacidad, fechaInicio, fechaFin, estado, tipoClase, entrenador);
            clases.add(nuevaClase);
        } else {
            throw new IllegalArgumentException("Clase con ID " + id + " ya existe.");
        }
    }

    public Clase buscarClasePorId(String id) {
        return clases.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Clase> buscarClases(String tipo, String entrenador, LocalTime horario) {
        return clases.stream()
                .filter(c -> (tipo == null || c.getTipoClase().getNombre().equalsIgnoreCase(tipo)) &&
                        (entrenador == null || c.getEntrenador().getNombre().equalsIgnoreCase(entrenador)) &&
                        (horario == null || c.getHorario().equals(horario)))
                .toList();
    }

    // Métodos para gestionar reservas
    public void reservarClase(String idClase, String identificacionUsuario) {
        Clase clase = buscarClasePorId(idClase);
        Usuario usuario = buscarUsuarioPorIdentificacion(identificacionUsuario);

        if (clase != null && usuario != null) {
            if (clase.getCuposDisponibles() > 0) {
                Reserva reserva = new Reserva(generateId(), clase, (Cliente) usuario, LocalDateTime.now().toString());
                reservas.add(reserva);
                clase.disminuirCuposDisponibles();
            } else {
                throw new IllegalStateException("No hay cupos disponibles para la clase con ID " + idClase);
            }
        } else {
            throw new IllegalArgumentException("Clase con ID " + idClase + " o usuario con identificación " + identificacionUsuario + " no encontrado.");
        }
    }

    public void cancelarReserva(String idReserva) {
        Reserva reserva = buscarReservaPorId(idReserva);
        if (reserva != null) {
            reserva.cancelarReserva();
            reservas.remove(reserva);
        } else {
            throw new IllegalArgumentException("Reserva con ID " + idReserva + " no encontrada.");
        }
    }

    private Reserva buscarReservaPorId(String id) {
        return reservas.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Métodos para gestionar entrenamientos
    public void registrarEntrenamiento(String tipoEjercicio, int duracion, int caloriasQuemadas, String identificacionUsuario) {
        Usuario usuario = buscarUsuarioPorIdentificacion(identificacionUsuario);
        if (usuario != null) {
            Entrenamiento entrenamiento = new Entrenamiento(tipoEjercicio, duracion, caloriasQuemadas, (Cliente) usuario);
            entrenamientos.add(entrenamiento);
        } else {
            throw new IllegalArgumentException("Usuario con identificación " + identificacionUsuario + " no encontrado.");
        }
    }

    public List<Entrenamiento> consultarHistorialEntrenamientos(String identificacionUsuario) {
        Usuario usuario = buscarUsuarioPorIdentificacion(identificacionUsuario);
        if (usuario != null) {
            return entrenamientos.stream()
                    .filter(e -> e.getCliente().getIdentificacion().equals(identificacionUsuario))
                    .toList();
        } else {
            throw new IllegalArgumentException("Usuario con identificación " + identificacionUsuario + " no encontrado.");
        }
    }

    // Método para generar un ID único (simulación simple)
    private String generateId() {
        return String.valueOf(System.currentTimeMillis()); // Simple pero efectivo para demostración
    }

    @Override
    public String toString() {
        return "Gimnasio{" +
                "usuarios=" + usuarios +
                ", clases=" + clases +
                ", reservas=" + reservas +
                ", entrenamientos=" + entrenamientos +
                '}';
    }
}
