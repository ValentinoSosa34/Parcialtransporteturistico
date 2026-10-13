package parcialtransporteturistico;

import java.util.Scanner;

public class ParcialTransporteTuristico {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        SistemaTransporteTuristico sistema = new SistemaTransporteTuristico();        
    
    int opcion;
    do {
        System.out.println("---SISTEMA TRANSPORTE TURÍSTICO---");
        System.out.println("1)Agregar vehículo.");
        System.out.println("2)Mostrar todos los vehículos.");
        System.out.println("3)Realizar servicios turísticos.");
        System.out.println("4)Buscar vehículo por patente.");
        System.out.println("5)Mostrar vehículos con capacidad a mayor a tal valor.");
        System.out.println("6)Ordenar por año de fabricación.");
        System.out.println("7)Ordenar por cantidad de pasajeros.");
        System.out.println("8)Salir.");
        System.out.println("Seleccione una opción: ");
        opcion = leerEntero(teclado);
    switch (opcion){
        case 1:
            int tipoVehiculo;
            do {
            System.out.println("¿Que tipo de vehículo quiere agregar?");
            System.out.println("1)Colectivo Turístico.");
            System.out.println("2)Van Ejecutiva.");
            System.out.println("3)Lancha Turística.");
            System.out.println("Seleccione un tipo: ");
            tipoVehiculo = leerEntero(teclado);
            if (tipoVehiculo < 1 || tipoVehiculo > 3){
                System.out.println("El tipo de vehiculo ingresado es incorrecto, reingrese del 1 al 3.");}
            } while (tipoVehiculo < 1 || tipoVehiculo > 3);
            String patente;
            do{
                System.out.println("Ingrese una patente: ");
                patente = teclado.next();
                if (sistema.existePatente(patente)){
                    System.out.println("La patente ingresada ya existe, porfavor ingresar otra.");
                }
            } while (sistema.existePatente(patente));
            System.out.println("Ingrese Marca: ");
            String marca = teclado.next();
            int cantidadPasajeros;
            do{
                System.out.println("Ingrese cantidad de pasajeros(mayor que 0): ");
                cantidadPasajeros = leerEntero(teclado);
                if(cantidadPasajeros <= 0){               
                    System.out.println("La capacidad ingresada es incorrecta, tiene que ser mayor que cero");
                }               
            } while(cantidadPasajeros <= 0);            
            int anioFabricacion;
            int anioActual = java.time.Year.now().getValue();
            do{
                System.out.println("Ingrese el año de fabricación(1990 a" + anioActual + "):");
                anioFabricacion =   leerEntero(teclado);
                if (anioFabricacion < 1990 || anioFabricacion > anioActual){
                    System.out.println("El año que ingreso no es valido, reingrese un año.");
                }
            }while (anioFabricacion < 1990 || anioFabricacion > anioActual); 
            switch (tipoVehiculo){
                case 1:
                    int pisos;
                    do{
                        System.out.println("Ingrese la cantidad de pisos(1 o 2)");
                        pisos = leerEntero(teclado);
                        if(pisos != 1 && pisos != 2){
                            System.out.println("Ingrese una cantidad de pisos valida.");
                        } 
                    } while(pisos != 1 && pisos != 2);
                    sistema.agregarVehiculo(new ColectivoTuristico(pisos, patente, marca, cantidadPasajeros, anioFabricacion));
                    System.out.println("Coletivo Turístico agregado.");
                    break;
                case 2:
                    String respuestaAire;
                    do{
                        System.out.println("¿Tiene aire acondicionado?(true/false): ");
                        respuestaAire = teclado.next();
                        if (!respuestaAire.equalsIgnoreCase("true") && !respuestaAire.equalsIgnoreCase("false")){
                            System.out.println("Ingrese true o false.");
                        }
                    }while (!respuestaAire.equalsIgnoreCase("true") && !respuestaAire.equalsIgnoreCase("false"));
                    boolean aire = respuestaAire.equalsIgnoreCase("true");
                    sistema.agregarVehiculo(new VanEjecutiva(aire, patente, marca,cantidadPasajeros, anioFabricacion));
                    System.out.println("Van Ejecutiva agregada.");
                    break;
                case 3:
                    String motor;
                    do{
                        System.out.println("Ingrese un tipo de motor(NAFTA, DIESEL o ELECTRICO): ");
                        motor = teclado.next();
                        if (!motor.equalsIgnoreCase("NAFTA") && !motor.equalsIgnoreCase("DIESEL")
                            && !motor.equalsIgnoreCase("ELECTRICO")){
                            System.out.println("Reingrese el tipo de motor correcto.");
                        }
                    } while (!motor.equalsIgnoreCase("NAFTA") && !motor.equalsIgnoreCase("DIESEL") && !motor.equalsIgnoreCase("ELECTRICO")); 
                    sistema.agregarVehiculo(new LanchaTuristica(motor, patente, marca, cantidadPasajeros, anioFabricacion));
                    System.out.println("Lancha Turística agregada.");
                    break;
                default:
                    System.out.println("Tipo incorrecto, vuelva a ingresar un tipo(1 al 3).");
            }break;
        case 2:
            sistema.mostrarVehiculo();
            break;
        case 3:
            sistema.realizarServicio();
            break;
        case 4:
            System.out.println("Ingrese la patente que desea buscar: ");
            String patenteBuscada = teclado.next();
            sistema.buscarPorPatente(patenteBuscada);
            break;
        case 5:
            System.out.println("Ingrese un valor de capacidad: ");
            int capacidadMinima =leerEntero(teclado);
            sistema.mostrarConCapacidadMayorA(capacidadMinima);
            break;
        case 6:
            sistema.ordenarPorAnioDescendente();
            sistema.mostrarVehiculo();
            break;
        case 7:
            sistema.ordenarPorCapacidadDescendente();
            sistema.mostrarVehiculo();
            break;
        case 8:
            System.out.println("Se salio del sistema con exito!!!");
            break;
        default:
            System.out.println("La opción ingresada es incorrecta, porfavor reingrese una opción(rango 1 al 8).");
    } 
    } while (opcion != 8);   
    }
    private static int leerEntero(Scanner teclado){
        while (true){
        try {
        return Integer.parseInt(teclado.next());
        } catch (NumberFormatException e){
            System.out.println("ERROR, ingrese un número entero: ");
        }
        }
    }
}   
