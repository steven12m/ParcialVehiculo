import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear el administrador de la flota
        Administrador admin = new Administrador();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Sistema de Gestión de Alquiler de Vehículos ---");
            System.out.println("1. Añadir vehículo");
            System.out.println("2. Listar vehículos disponibles");
            System.out.println("3. Reservar un vehículo");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea después de un int

            switch (opcion) {
                case 1:
                    añadirVehiculo(admin, scanner);
                    break;
                case 2:
                    listarVehiculosDisponibles(admin);
                    break;
                case 3:
                    reservarVehiculo(admin, scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    // Método para añadir un vehículo interactivo
    public static void añadirVehiculo(Administrador admin, Scanner scanner) {
        System.out.println("\n--- Añadir Vehículo ---");
        System.out.println("Seleccione el tipo de vehículo:");
        System.out.println("1. Auto");
        System.out.println("2. Moto");
        System.out.println("3. Camioneta");
        System.out.println("4. Autobús");
        System.out.print("Ingrese opción: ");
        int tipoVehiculo = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        System.out.print("ID del Vehículo: ");
        String idVehiculo = scanner.nextLine();

        System.out.print("Marca: ");
        String marca = scanner.nextLine();

        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();

        System.out.print("Año: ");
        int año = scanner.nextInt();

        System.out.print("Costo diario: ");
        double costoDiario = scanner.nextDouble();
        scanner.nextLine();  // Consumir salto de línea

        switch (tipoVehiculo) {
            case 1: // Auto
                System.out.print("Tipo de combustible (Gasolina, Diesel, Eléctrico): ");
                String tipoCombustible = scanner.nextLine();
                Auto auto = new Auto(idVehiculo, marca, modelo, año, costoDiario, tipoCombustible);
                admin.añadirVehiculo(auto);
                break;
            case 2: // Moto
                System.out.print("Cilindrada (cc): ");
                int cilindrada = scanner.nextInt();
                scanner.nextLine();  // Consumir salto de línea
                Moto moto = new Moto(idVehiculo, marca, modelo, año, costoDiario, cilindrada);
                admin.añadirVehiculo(moto);
                break;
            case 3: // Camioneta
                System.out.print("Capacidad de carga (kg): ");
                double capacidadCarga = scanner.nextDouble();
                scanner.nextLine();  // Consumir salto de línea
                Camioneta camioneta = new Camioneta(idVehiculo, marca, modelo, año, costoDiario, capacidadCarga);
                admin.añadirVehiculo(camioneta);
                break;
            case 4: // Autobús
                System.out.print("Capacidad de pasajeros: ");
                int capacidadPasajeros = scanner.nextInt();
                scanner.nextLine();  // Consumir salto de línea
                Autobus bus = new Autobus(idVehiculo, marca, modelo, año, costoDiario, capacidadPasajeros);
                admin.añadirVehiculo(bus);
                break;
            default:
                System.out.println("Opción no válida.");
        }
        System.out.println("Vehículo añadido exitosamente.");
    }

    // Método para listar vehículos disponibles
    public static void listarVehiculosDisponibles(Administrador admin) {
        System.out.println("\n--- Vehículos Disponibles ---");
        for (Vehiculo vehiculo : admin.listarVehiculosDisponibles()) {
            System.out.println(vehiculo.toString());
        }
    }

    // Método para reservar un vehículo
    public static void reservarVehiculo(Administrador admin, Scanner scanner) {
        System.out.println("\n--- Reservar Vehículo ---");
        System.out.print("Ingrese su ID de cliente: ");
        String idCliente = scanner.nextLine();

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        Cliente cliente = new Cliente(idCliente, nombre);

        listarVehiculosDisponibles(admin);

        System.out.print("Ingrese el ID del vehículo que desea reservar: ");
        String idVehiculo = scanner.nextLine();

        Vehiculo vehiculo = null;
        for (Vehiculo v : admin.listarVehiculosDisponibles()) {
            if (v.getIdVehiculo().equals(idVehiculo)) {
                vehiculo = v;
                break;
            }
        }

        if (vehiculo == null) {
            System.out.println("Vehículo no encontrado o no disponible.");
            return;
        }

        System.out.print("Fecha de inicio (yyyy-mm-dd): ");
        String fechaInicioStr = scanner.nextLine();
        LocalDate fechaInicio = LocalDate.parse(fechaInicioStr);

        System.out.print("Fecha de fin (yyyy-mm-dd): ");
        String fechaFinStr = scanner.nextLine();
        LocalDate fechaFin = LocalDate.parse(fechaFinStr);

        System.out.print("¿Desea seguro? (true/false): ");
        boolean seguro = scanner.nextBoolean();

        System.out.print("¿Desea GPS? (true/false): ");
        boolean gps = scanner.nextBoolean();

        cliente.reservarVehiculo(vehiculo, fechaInicio, fechaFin, seguro, gps);
    }
}
