import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Administrador {
    private List<Vehiculo> flota;

    public Administrador() {
        flota = new ArrayList<>();
    }

    public void añadirVehiculo(Vehiculo vehiculo) {
        flota.add(vehiculo);
    }
    

    public boolean verificarDisponibilidad(Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin) {
        // Aquí implementa la lógica para verificar la disponibilidad del vehículo
        // Puedes usar una lista de reservas para hacer esta verificación.
        return vehiculo.isDisponible(); // Método que deberías implementar en Vehiculo
    }

    public List<Vehiculo> listarVehiculosDisponibles() {
        List<Vehiculo> disponibles = new ArrayList<>();
        for (Vehiculo vehiculo : flota) {
            if (vehiculo.isDisponible()) {
                disponibles.add(vehiculo);
            }
        }
        return disponibles;
    }
}
