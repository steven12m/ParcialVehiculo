import java.util.ArrayList;
import java.util.List;

public class Administrador {
    private List<Vehiculo> flota;

    public Administrador() {
        this.flota = new ArrayList<>();
    }

    public void añadirVehiculo(Vehiculo vehiculo) {
        flota.add(vehiculo);
        System.out.println("Vehículo añadido: " + vehiculo.getMarca() + " " + vehiculo.getModelo());
    }

    public boolean verificarDisponibilidad(Vehiculo vehiculo) {
        return vehiculo.isDisponible();
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
