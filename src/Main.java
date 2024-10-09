import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Crear un administrador
        Administrador administrador = new Administrador();

        // Ingreso de información del vehículo
        System.out.println("=== Ingreso de Información del Vehículo ===");
        
        System.out.print("ID del vehículo: ");
        String idVehiculo = scanner.nextLine();
        
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        
        System.out.print("Año: ");
        int año = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Costo diario: ");
        double costoDiario = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Disponibilidad (true/false): ");
        boolean disponibilidad = Boolean.parseBoolean(scanner.nextLine());

        // Crear un cliente
        System.out.println("\n=== Ingreso de Información del Cliente ===");
        System.out.print("Ingrese ID del cliente: ");
        String idCliente = scanner.nextLine();
        
        System.out.print("Ingrese nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        
        Cliente cliente = new Cliente(idCliente, nombreCliente);

        
        // Ingresar tipo de vehículo específico
        System.out.print("Tipo de vehículo (Auto, Moto, Camioneta, Autobús): ");
        String tipoVehiculo = scanner.nextLine().toLowerCase();
        
        Vehiculo vehiculo = null;

        // Solicitar características específicas según el tipo de vehículo
        switch (tipoVehiculo) {
            case "auto":
                System.out.print("Tipo de combustible (Gasolina, Diésel, Eléctrico): ");
                String tipoCombustible = scanner.nextLine();
                vehiculo = new Auto(idVehiculo, marca, modelo, año, costoDiario, tipoCombustible);
                break;

            case "moto":
                System.out.print("Cilindrada (cc): ");
                int cilindrada = Integer.parseInt(scanner.nextLine());
                vehiculo = new Moto(idVehiculo, marca, modelo, año, costoDiario, cilindrada);
                break;

            case "camioneta":
                System.out.print("Capacidad de carga (kg): ");
                int capacidadCarga = Integer.parseInt(scanner.nextLine());
                vehiculo = new Camioneta(idVehiculo, marca, modelo, año, costoDiario, capacidadCarga);
                break;

            case "autobús":
                System.out.print("Capacidad de pasajeros: ");
                int capacidadPasajeros = Integer.parseInt(scanner.nextLine());
                vehiculo = new Autobus(idVehiculo, marca, modelo, año, costoDiario, capacidadPasajeros);
                break;

            default:
                System.out.println("Tipo de vehículo no reconocido.");
                scanner.close();
                return;
        }

        // Establecer disponibilidad
        vehiculo.setDisponible(disponibilidad);
        administrador.añadirVehiculo(vehiculo);

        // Mostrar vehículos disponibles
        System.out.println("\n=== Vehículos Disponibles ===");
        for (Vehiculo v : administrador.listarVehiculosDisponibles()) {
            System.out.println("ID: " + v.getIdVehiculo() + 
                               ", Marca: " + v.getMarca() + 
                               ", Modelo: " + v.getModelo() + 
                               ", Disponible: " + v.isDisponible());
        }

        
        // Hacer una reserva
        System.out.println("\n=== Proceso de Reserva ===");
        System.out.print("Ingrese fecha de inicio (YYYY-MM-DD): ");
        LocalDate fechaInicio = LocalDate.parse(scanner.nextLine());
        
        System.out.print("Ingrese número de días de reserva: ");
        int dias = Integer.parseInt(scanner.nextLine());
        
        LocalDate fechaFin = fechaInicio.plusDays(dias);
        
        cliente.reservarVehiculo(vehiculo, fechaInicio, fechaFin, false, true); // Reserva sin seguro, con GPS

        // Confirmar reserva
        System.out.println("\n=== Reserva Realizada ===");
        System.out.println("ID de Reserva: " + cliente.getReservas());
        System.out.println("Vehículo reservado: " + vehiculo.getMarca() + " " + vehiculo.getModelo());
        System.out.println("¿El vehículo está disponible? " + vehiculo.isDisponible()); // Debería ser false

        // Cerrar el escáner
        scanner.close();
    }
}
