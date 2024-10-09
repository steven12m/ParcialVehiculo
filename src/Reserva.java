import java.time.LocalDate;

public class Reserva {
    private String idReserva;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double costoTotal;

    public Reserva(Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin, double costoTotal) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costoTotal = costoTotal;
        this.idReserva = generarIdReserva(); // Implementa un método para generar ID
    }

    private String generarIdReserva() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generarIdReserva'");
    }

    public void confirmarReserva() {
        // Lógica para confirmar la reserva (puedes marcar el vehículo como reservado)
        vehiculo.setDisponible(false);
    }

    // Getters y Setters...
}
