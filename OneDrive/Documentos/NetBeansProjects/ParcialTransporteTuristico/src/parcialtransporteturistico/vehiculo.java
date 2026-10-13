
package parcialtransporteturistico;
public abstract class vehiculo {
    private String patente;
    private String marca;
    private int capacidadPasajeros;
    private int anioFabricacion;

    public vehiculo(String patente, String marca, int capacidadPasajeros, int anioFabricacion) {
        this.patente = patente;
        this.marca = marca;
        this.capacidadPasajeros = capacidadPasajeros;
        this.anioFabricacion = anioFabricacion;
    }
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        if (patente == null || patente.trim().isEmpty()){
        throw new IllegalArgumentException("La patente no puede estar vacía.");
        }
        this.patente = patente.trim();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        if (capacidadPasajeros <= 0){
        throw new IllegalArgumentException("La capacidad de pasajeros debe ser mayor que 0.");
        }
        this.capacidadPasajeros = capacidadPasajeros; 
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        int anioActual = java.time.Year.now().getValue();
        if(anioFabricacion < 1990 || anioFabricacion > anioActual){
            throw new IllegalArgumentException("El año de fabricacion es incorrecto, debe estar entre el 1990 y " + anioActual);      
        }
        this.anioFabricacion = anioFabricacion;
    }
    public abstract void realizarServicio();
}
