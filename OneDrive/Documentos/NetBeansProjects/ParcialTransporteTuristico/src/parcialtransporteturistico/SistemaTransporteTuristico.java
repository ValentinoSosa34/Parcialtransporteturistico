package parcialtransporteturistico;
import java.util.ArrayList;
public class SistemaTransporteTuristico {
     private ArrayList<vehiculo> vehiculos;
     
     public SistemaTransporteTuristico(){
     vehiculos = new ArrayList<>();
     }
     public boolean existePatente(String patenteBuscada){
         for (int i = 0; i < vehiculos.size(); i++){
            if (vehiculos.get(i).getPatente().equalsIgnoreCase(patenteBuscada)){
                return true;                       
            }}
            return false;
         }
     public void agregarVehiculo(vehiculo nuevoVehiculo){
         for (int i = 0; i < vehiculos.size(); i++){
             if (vehiculos.get(i).getPatente().equalsIgnoreCase(nuevoVehiculo.getPatente())){
                 System.out.println("Ya existe un vehiculo con esa patente.");
                 return;
             }    
         }
     vehiculos.add(nuevoVehiculo);        
     }
    
     public void mostrarVehiculo(){
         if (vehiculos.isEmpty()){
             System.out.println("Todavía no hay vehículos cargados. ");
             return;
         }
         for (int i = 0; i < vehiculos.size(); i++){
         vehiculo actual = vehiculos.get(i);
             System.out.println("Patente: " + actual.getPatente());
             System.out.println("Marca: " + actual.getMarca());
             System.out.println("Capacidad de pasajeros: " + actual.getCapacidadPasajeros());
             System.out.println("Año: " + actual.getAnioFabricacion());
          if (actual instanceof ColectivoTuristico){
                ColectivoTuristico colectivo = (ColectivoTuristico) actual;
                System.out.println("Tipo: Colectivo turístico.");
                System.out.println("Cantidad de pisos:" + colectivo.getCantidadPisos());}
          else if (actual instanceof VanEjecutiva){
              VanEjecutiva van = (VanEjecutiva) actual;
              System.out.println("Tipo Van Ejecutiva");
              System.out.println("Aire acondicionado" + van.isAireAcondicionado());}
          else if (actual instanceof LanchaTuristica){
              LanchaTuristica lancha = (LanchaTuristica)actual;
              System.out.println("Tipo Lancha turística.");
              System.out.println("Tipo de motor: " + lancha.getTipoMotor());
          }
             System.out.println("------------------------");
         }
     }
         
    public void realizarServicio(){
        if (vehiculos.isEmpty()){
             System.out.println("Todavía no hay vehículos cargados. ");
             return;}
        for (int i = 0; i < vehiculos.size(); i++ ){
            vehiculo actual = vehiculos.get(i);
            actual.realizarServicio();
        }   
    }
    public void buscarPorPatente(String patenteBuscada){
        for (int i = 0; i < vehiculos.size(); i++){
        vehiculo actual = vehiculos.get(i);
        if (actual.getPatente().equalsIgnoreCase(patenteBuscada)){
            System.out.println("Vehiculo encontrado: ");
            System.out.println("Patente: " + actual.getPatente());
            System.out.println("Marca: " + actual.getMarca());
            System.out.println("Cantidad de pasajeros: " + actual.getCapacidadPasajeros());
            System.out.println("Año fabricación: " + actual.getAnioFabricacion());
         if (actual instanceof ColectivoTuristico){
                ColectivoTuristico colectivo = (ColectivoTuristico) actual;
                System.out.println("Tipo: Colectivo turístico.");
                System.out.println("Cantidad de pisos:" + colectivo.getCantidadPisos());}
         else if (actual instanceof VanEjecutiva){
              VanEjecutiva van = (VanEjecutiva) actual;
              System.out.println("Tipo Van Ejecutiva");
              System.out.println("Aire acondicionado" + van.isAireAcondicionado());}
         else if (actual instanceof LanchaTuristica){
              LanchaTuristica lancha = (LanchaTuristica)actual;
              System.out.println("Tipo Lancha turística.");
              System.out.println("Tipo de motor: " + lancha.getTipoMotor());
          }
            return;
        }
        }
        System.out.println("No se encontró un vehiculo con esa patente");
    }
    public void mostrarConCapacidadMayorA(int capacidadMinima){
        boolean encontrado = false;        
        if (vehiculos.isEmpty()){
             System.out.println("Todavía no hay vehículos cargados. ");
             return;}
        for (int i = 0; i < vehiculos.size(); i++){
            vehiculo actual = vehiculos.get(i);
        if (actual.getCapacidadPasajeros() > capacidadMinima){
             System.out.println("Vehiculo encontrado: ");
            System.out.println("Patente: " + actual.getPatente());
            System.out.println("Marca: " + actual.getMarca());
            System.out.println("Cantidad de pasajeros: " + actual.getCapacidadPasajeros());
            System.out.println("Año fabricación: " + actual.getAnioFabricacion());
        if (actual instanceof ColectivoTuristico){
            ColectivoTuristico colectivo = (ColectivoTuristico) actual;
            System.out.println("Tipo: Colectivo turístico.");
            System.out.println("Cantidad de pisos:" + colectivo.getCantidadPisos());}
         else if (actual instanceof VanEjecutiva){
              VanEjecutiva van = (VanEjecutiva) actual;
              System.out.println("Tipo Van Ejecutiva");
              System.out.println("Aire acondicionado" + van.isAireAcondicionado());}
         else if (actual instanceof LanchaTuristica){
              LanchaTuristica lancha = (LanchaTuristica)actual;
              System.out.println("Tipo Lancha turística.");
              System.out.println("Tipo de motor: " + lancha.getTipoMotor());
          }
            encontrado = true;
        }
        } 
        if (!encontrado){
            System.out.println("No hay vehículos con capacidad mayor a ese valor.");}  
    }
    public void ordenarPorAnioDescendente(){
        for (int i = 0; i < vehiculos.size() - 1; i++){
        for (int j = 0; j < vehiculos.size() - 1 - i; j++){
            if (vehiculos.get(j).getAnioFabricacion() < vehiculos.get(j +1).getAnioFabricacion()){
            vehiculo auxiliar = vehiculos.get(j);
            vehiculos.set(j, vehiculos.get(j + 1));
            vehiculos.set(j + 1, auxiliar);
            }
        }        
        }
    }
    public void ordenarPorCapacidadDescendente(){
        for (int i = 0; i < vehiculos.size() - 1; i++){
        for (int j = 0; j < vehiculos.size() - 1 - i; j++){
            if (vehiculos.get(j).getCapacidadPasajeros() < vehiculos.get(j +1).getCapacidadPasajeros()){
            vehiculo auxiliar = vehiculos.get(j);
            vehiculos.set(j, vehiculos.get(j + 1));
            vehiculos.set(j + 1, auxiliar);
            }
        }        
        }
    }
}
