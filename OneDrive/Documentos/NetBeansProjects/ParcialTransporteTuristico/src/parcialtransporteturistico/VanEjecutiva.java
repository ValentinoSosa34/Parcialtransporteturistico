package parcialtransporteturistico;

public class VanEjecutiva extends vehiculo{
    private boolean aireAcondicionado;

    public VanEjecutiva(boolean aireAcondicionado, String patente, String marca, int capacidadPasajeros, int anioFabricacion) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        this.aireAcondicionado = aireAcondicionado;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }
    @Override
    public void realizarServicio(){
        System.out.println("La van ejecutiva está realizando un servicio turístico.");
    }
}
