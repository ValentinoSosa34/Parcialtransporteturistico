
package parcialtransporteturistico;

public class ColectivoTuristico extends vehiculo {
    private int cantidadPisos;
    
    public ColectivoTuristico(int cantidadPisos, String patente, String marca, int capacidadPasajeros, int anioFabricacion) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        this.cantidadPisos = cantidadPisos;
    }
    public int getCantidadPisos() {
        return cantidadPisos;
    }

    public void setCantidadPisos(int cantidadPisos) {
        if (cantidadPisos != 1 && cantidadPisos != 2){
            throw new IllegalArgumentException("La cantidad de pisos ingresada no es valida, rango del 1 al 2.");
        }                       
        this.cantidadPisos = cantidadPisos;
    }
    @Override
    public void realizarServicio(){
        System.out.println("El colectivo está realizando un servicio turístico");
    
    }
}
