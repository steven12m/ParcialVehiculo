public class Camioneta extends Vehiculo {
    private double capacidadCarga; // en kilogramos

    public Camioneta(String idVehiculo, String marca, String modelo, int año, double costoDiario, double capacidadCarga) {
        super(idVehiculo, marca, modelo, año, costoDiario);
        this.capacidadCarga = capacidadCarga;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public String toString() {
        return super.getMarca() + " " + super.getModelo() + " (Carga: " + capacidadCarga + "kg)";
    }
}
