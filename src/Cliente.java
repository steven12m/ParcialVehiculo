import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String idCliente;
    private String nombre;
    private List<Reserva> reservas;

    public Cliente(String idCliente, String nombre) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.reservas = new ArrayList<>();
    }

    public void reservarVehiculo(Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin, boolean seguro, boolean gps) {
        // Lógica para crear una reserva y agregarla a la lista de reservas
        Reserva nuevaReserva = new Reserva(this, vehiculo, fechaInicio, fechaFin, vehiculo.calcularPrecio(1, seguro, gps));
        reservas.add(nuevaReserva);
        vehiculo.setDisponible(false); // Marcar vehículo como no disponible
        nuevaReserva.confirmarReserva();
    }

    public LocalDate getReservas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReservas'");
    }

    // Getters y Setters...
}
