package com.taller.views;

import java.util.Scanner;

import com.taller.Controller;
import com.taller.Model.entity.Player;
import com.taller.Model.entity.Team;

public class viewPlayer {

    public static Controller controlador;

    public static Controller datosEquipos;


public static void start() {

    Scanner scanner = new Scanner(System.in);

    String codigoJugador = "";
    int decision = 0;

    Player jugador = new Player();
    Team equipo = new Team();

    


    jugador.setNombre("James");
    jugador.setApellido("Rodriguez");
    jugador.setEdad(25);
    jugador.setIdEquipo("1");
    jugador.setDorsal(12);
    jugador.setPosicion("GP");
    controlador.jugadores.put("1", jugador);

    while (true) {
        System.out.println("=============================");
        System.out.println("\tMenu Jugadores");
        System.out.println("=============================\n");

        System.out.println("1. Ingresar Jugador");
        System.out.println("2. Actualizar Jugador");
        System.out.println("3. Buscar Jugador");
        System.out.println("4. Eliminar Jugador");
        System.out.println("5. Listar todos Jugadores");
        System.out.println("6. Salir");

        System.out.println("Ingresa la opcion");
        decision = scanner.nextInt();
        scanner.nextLine(); // Para manejar el salto de línea después de nextInt()

        switch (decision) {
            case 1:
                
                try {

                    /* System.out.println("Equipos" + datosEquipos.equipos);

                    if (datosEquipos.equipos.size() > 0) {
                        
                        System.out.println("SI HAY DATOS: " + datosEquipos.equipos.size());
                    } else {
                        System.out.println("NO HAY DATOS:" + datosEquipos.equipos.size());
                    } */
                    System.out.println("=============================");
                    System.out.println("\nIngresar Jugador");
                    System.out.println("=============================\n");

                    System.out.println("Ingresa id del jugador:");
                    codigoJugador = scanner.nextLine();

                    System.out.println("Digita el nombre");
                    jugador.setNombre(scanner.nextLine());

                    System.out.println("Digita el apellido");
                    jugador.setApellido(scanner.nextLine());

                    System.out.println("Digita la edad");
                    jugador.setEdad(scanner.nextInt());
                    scanner.nextLine();

                    System.out.println("Digita el numero de camiseta");
                    jugador.setDorsal(scanner.nextInt());
                    scanner.nextLine();

                    System.out.println("Digita la posicion");
                    jugador.setPosicion(scanner.nextLine());

                    System.out.println("Digita el id del equipo");
                    String codigoEquipo = scanner.nextLine();
                    jugador.setIdEquipo(codigoEquipo);

                    // Ingresar jugador al equipo

                    equipo = datosEquipos.equipos.get(codigoEquipo);

                    /* System.out.println("Codigo equipo: " + codigoEquipo);
                    System.out.println("Equipo: " + equipo); 
 */
                    if (equipo != null) {

                        

                        controlador.jugadores.put(codigoJugador, jugador);
                        boolean insertado = equipo.getLstJugadores().add(jugador);// Se añade el jugador a la lista de jugadores del equipo

                        System.out.println("Agregado: " + insertado);
                        System.out.println("El jugador ha sido creado exitosamente");
                    } else {
                        System.out.println("No se encontró un equipo con el código proporcionado.");
                        // System.out.println(jugador);
                    }
                    
                } catch (Exception e) {
                    System.out.println("Error al ingresar los datos"+ e);
                }
               

                break;

            case 2:
                System.out.println("=============================");
                System.out.println("\nModificar Jugador");
                System.out.println("=============================\n");

                System.out.println("Ingrese el codigo del jugador:");
                codigoJugador = scanner.nextLine();

                jugador = controlador.jugadores.get(codigoJugador);

                if (jugador == null) {
                    System.out.println("No se encontró un jugador con el código ingresado.");
                } else {
                    int choice2;

                    do {
                        System.out.println("Que dato deseas actualizar?");
                        System.out.println("1. Nombre");
                        System.out.println("2. Apellido");
                        System.out.println("3. Edad");
                        System.out.println("4. Dorsal");
                        System.out.println("5. Posicion");
                        System.out.println("6. Equipo");
                        System.out.println("7. Salir");

                        choice2 = scanner.nextInt();
                        scanner.nextLine(); // Para manejar el salto de línea después de nextInt()

                        switch (choice2) {
                            case 1:
                                System.out.println("Ingrese el nuevo nombre del jugador:");
                                jugador.setNombre(scanner.nextLine());
                                break;

                            case 2:
                                System.out.println("Ingrese el nuevo apellido:");
                                jugador.setApellido(scanner.nextLine());
                                break;

                            case 3:
                                System.out.println("Ingrese la nueva edad:");
                                jugador.setEdad(scanner.nextInt());
                                scanner.nextLine(); // Para manejar el salto de línea después de nextInt()
                                break;

                            case 4:
                                System.out.println("Ingrese el nuevo dorsal:");
                                jugador.setDorsal(scanner.nextInt());
                                scanner.nextLine(); // Para manejar el salto de línea después de nextInt()
                                break;

                            case 5:
                                System.out.println("Ingrese la nueva posicion:");
                                jugador.setPosicion(scanner.nextLine());
                                break;

                            case 6:
                                System.out.println("Ingrese el id del equipo:");

                                String nuevoCodigoEquipo = scanner.nextLine();

                                Team nuevoEquipo = datosEquipos.equipos.get(nuevoCodigoEquipo);
                                
                                if (nuevoEquipo != null) {
                                    Team equipoActual = datosEquipos.equipos.get(jugador.getIdEquipo());
                                    jugador.setIdEquipo(nuevoCodigoEquipo);
                                    if (equipoActual != null) {
                                        equipoActual.getLstJugadores().remove(jugador);
                                    }
                                    nuevoEquipo.setLstJugadores(jugador);

                                    System.out.println("\nDATOS ACTUALIZADOS DEL JUGADOR");
                                    System.out.println("Nombre: " + jugador.getNombre());
                                    System.out.println("Apellido: " + jugador.getApellido());
                                    System.out.println("Edad: " + jugador.getEdad());
                                    System.out.println("Dorsal: " + jugador.getDorsal());
                                    System.out.println("Posicion: " + jugador.getPosicion());
                                    System.out.println("IdEquipo:" + jugador.getIdEquipo());

                                } else {
                                    System.out.println("No se encontró un equipo con el código proporcionado.");
                                }
                                break;

                            case 7:
                                break;

                            default:
                                System.out.println("Opción inválida, inténtelo de nuevo.");
                                break;
                        }

                        

                    } while (choice2 != 7);
                }

                break;

            case 3:
                System.out.println("=============================");
                System.out.println("\tBuscar Jugador");
                System.out.println("=============================\n");

                System.out.println("Ingresa el codigo del jugador:");
                codigoJugador = scanner.nextLine();

                jugador = controlador.jugadores.get(codigoJugador);

                if (jugador != null) {
                    System.out.println("===============================");
                    System.out.println("\nDATOS DEL JUGADOR");
                    System.out.println("===============================\n");
                    System.out.println("Nombre: " + jugador.getNombre());
                    System.out.println("Apellido: " + jugador.getApellido());
                    System.out.println("Edad: " + jugador.getEdad());
                    System.out.println("Dorsal: " + jugador.getDorsal());
                    System.out.println("Posicion: " + jugador.getPosicion());
                    System.out.println("IdEquipo:" + jugador.getIdEquipo());
                } else {
                    System.out.println("El codigo del jugador no existe");
                }

                break;
            case 4:
                System.out.println("Ingresa el codigo del jugador:");
                codigoJugador = scanner.nextLine();

                jugador = controlador.jugadores.remove(codigoJugador);

                if (jugador != null) {
                    System.out.println("===============================");
                    System.out.println("\nDATOS DEL JUGADOR ELIMINADO");
                    System.out.println("===============================\n");
                    System.out.println("Nombre: " + jugador.getNombre());
                    System.out.println("Apellido: " + jugador.getApellido());
                    System.out.println("Edad: " + jugador.getEdad());
                    System.out.println("Dorsal: " + jugador.getDorsal());
                    System.out.println("Posicion: " + jugador.getPosicion());
                    System.out.println("IdEquipo:" + jugador.getIdEquipo());
                } else {
                    System.out.println("El codigo del jugador no existe");
                }

                break;
            case 5:
                System.out.println("=================================");
                System.out.println("LISTA DE TODOS LOS JUGADORES");
                System.out.println("=================================\n");
                
                //System.out.println(controlador.equipos.contains("1")); 
                System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", "Código", "Nombre", "Apellido" , "Edad" , "Dorsal" , "Posicion" , "IdEquipo");
                System.out.println("------------------------------------------------------------------------------\n");


                for (String key : controlador.jugadores.keySet()) {
                    jugador = controlador.jugadores.get(key);
                    
                    System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s" , key , jugador.getNombre(),jugador.getApellido(),jugador.getEdad(),jugador.getDorsal(),jugador.getPosicion(),jugador.getIdEquipo());
                    
                    /* System.out.println("ID: " + key);
                    System.out.println("Nombre: " + jugador.getNombre());
                    System.out.println("Apellido: " + jugador.getApellido());
                    System.out.println("Edad: " + jugador.getEdad());
                    System.out.println("Dorsal: " + jugador.getDorsal());
                    System.out.println("Posicion: " + jugador.getPosicion());
                    System.out.println("IdEquipo:" + jugador.getIdEquipo()); */
                } 
                scanner.nextLine();
                break;
            case 6:
                return;
            default:
                System.out.println("Opción inválida, inténtelo de nuevo.");
                break;
        }
    }
}
}
