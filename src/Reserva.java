import java.time.LocalDate;

public class Reserva {
    private static int contadorReservas = 0;
    private String idReserva;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double costoTotal;

    public Reserva(Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idReserva = generarIdReserva();
        this.costoTotal = vehiculo.calcularPrecio((int) (fechaFin.toEpochDay() - fechaInicio.toEpochDay()), false, false);
    }

    private String generarIdReserva() {
        contadorReservas++;
        return "R" + contadorReservas;
    }

    public void confirmarReserva() {
        vehiculo.setDisponible(false);  // Marca el vehículo como no disponible
        System.out.println("Reserva confirmada. Costo total: " + costoTotal);
    }

    public String getIdReserva() {
        return idReserva;
    }
}
