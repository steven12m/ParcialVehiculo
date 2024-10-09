public class Camioneta extends Vehiculo {
    private int capacidadCarga;

    public Camioneta(String idVehiculo, String marca, String modelo, int año, double costoDiario, int capacidadCarga) {
        super(idVehiculo, marca, modelo, año, costoDiario);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    protected void setDisponible(boolean b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDisponible'");
    }

    @Override
    protected String getIdVehiculo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIdVehiculo'");
    }

    @Override
    public String getModelo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getModelo'");
    }

    // Getters y Setters...
}
