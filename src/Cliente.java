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
        if (!vehiculo.isDisponible()) {
            System.out.println("El vehículo no está disponible.");
            return;
        }
        Reserva nuevaReserva = new Reserva(this, vehiculo, fechaInicio, fechaFin);
        reservas.add(nuevaReserva);
        nuevaReserva.confirmarReserva();
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
}
