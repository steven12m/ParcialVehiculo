public class Vehiculo {
    private String idVehiculo;
    private String marca;
    private String modelo;
    private int año;
    private double costoDiario;
    private boolean disponibilidad;

    public Vehiculo(String idVehiculo, String marca, String modelo, int año, double costoDiario) {
        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.costoDiario = costoDiario;
        this.disponibilidad = true;  // Disponible por defecto
    }

    public double calcularPrecio(int dias, boolean seguro, boolean gps) {
        double precioBase = dias * costoDiario;
        if (seguro) {
            precioBase += precioBase * 0.10;  // 10% adicional por seguro
        }
        if (gps) {
            precioBase += dias * 5;  // Cargo fijo de $5 por día por GPS
        }
        return precioBase;
    }

    public boolean isDisponible() {
        return disponibilidad;
    }

    public void setDisponible(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    // Getters y setters para otros atributos
    public String getIdVehiculo() { return idVehiculo; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAño() { return año; }
    public double getCostoDiario() { return costoDiario; }
}
