package parcialtransporteturistico;

public class LanchaTuristica extends vehiculo{
    private String tipoMotor;
    
    public LanchaTuristica(String tipoMotor, String patente, String marca, int capacidadPasajeros, int anioFabricacion) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        this.tipoMotor = tipoMotor;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        if(!tipoMotor.equalsIgnoreCase("NAFTA") && !tipoMotor.equalsIgnoreCase("DIESEL")
            && !tipoMotor.equalsIgnoreCase("ELECTRICO")){
            throw new IllegalArgumentException("El tipo de motor ingresado es incorrecto, Reingrese el tipo de motor (NAFTA/DIESEL/ELECTRICO)");}
        this.tipoMotor = tipoMotor;
    }
    @Override
    public void realizarServicio(){
        System.out.println("La lancha está realizando un servicio turístico.");
    }
}
