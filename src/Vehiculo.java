
public abstract class Vehiculo {
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
        this.disponibilidad = true; // Por defecto disponible
    }

    public double calcularPrecio(int dias, boolean seguro, boolean gps) {
        double precio = dias * costoDiario;
        if (seguro) {
            precio += precio * 0.10; // 10% adicional
        }
        if (gps) {
            precio += 5 * dias; // $5 por día
        }
        return precio;
    }

    protected abstract void setDisponible(boolean b);

    public boolean isDisponible() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isDisponible'");
    }

    protected abstract String getIdVehiculo();

    public String getMarca() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMarca'");
    }

    public String getModelo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getModelo'");
    }


    // Getters y Setters
}
