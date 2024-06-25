package com.taller.views;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import com.taller.Controller;
import com.taller.Model.entity.Coach;
import com.taller.Model.entity.Doctor;
import com.taller.Model.entity.Player;
import com.taller.Model.entity.Team;

public class viewTeam {

    public static Controller controlador;

    public static Controller datosJugadores;
    public static Controller datosDoctores;
    public static Controller datosCoachs;


public static void start() {

    Team equipo = new Team();
    Player jugador = new Player();

    equipo.setNombre("Bucaros");
    equipo.setCiudad("Bucaramanga");
    controlador.equipos.put("1", equipo); 
    

    System.out.println(controlador.equipos);
    System.out.println(datosCoachs.entrenadores);
    System.out.println(datosDoctores.doctores);
    System.out.println(datosJugadores.jugadores);

    Scanner scanner = new Scanner(System.in);
    String codigoEquipo = "";
    

    /* Otra forma de comunicar el controler con las vistas
    Controller ctrlTeams = new Controller();
    System.out.println(ctrlTeams.equipos);
    */
    

    while (true) {
        System.out.println("=============================");
        System.out.println("\tMenu Equipos");
        System.out.println("=============================\n");
        System.out.println("1. Crear Equipo");
        System.out.println("2. Actualizar Equipo");
        System.out.println("3. Buscar Equipo");
        System.out.println("4. Eliminar Equipo");
        System.out.println("5. Listar todos Equipos");
        System.out.println("6. Salir\n");
        System.out.print("Opcion:");
        int choice = scanner.nextInt();

        scanner.nextLine(); // Para manejar el salto de línea después de nextInt()

        switch (choice) {
            case 1:
                System.out.println("=============================");
                System.out.println("\tCrear Equipo");
                System.out.println("=============================\n");
                
                System.out.print("Ingrese el codigo del equipo:");
                codigoEquipo = scanner.nextLine();

                System.out.print("Ingrese Nombre del equipo:");
                equipo.setNombre(scanner.nextLine());

                System.out.print("Ingrese la ciudad:");
                equipo.setCiudad(scanner.nextLine());

                controlador.equipos.put(codigoEquipo, equipo);

                // if (controlador.equipos.size() > 0) {
                //     System.out.println("SI HAY DATOS" + controlador.equipos.size());
                // } else {
                //     System.out.println(controlador.equipos.size());
                // }
                System.out.println(equipo);

                break;

            case 2:
                System.out.println("=============================\n");
                System.out.println("\tModificar Equipo");
                System.out.println("=============================\n");

                System.out.print("Ingrese el codigo del equipo: ");
                codigoEquipo = scanner.nextLine();

                equipo = controlador.equipos.get(codigoEquipo);

                if (equipo == null) {
                    System.out.println("No se encontró un equipo con el código proporcionado.");
                    scanner.nextLine();
                    break;
                }

                int choice2;

                do {
                    System.out.println("Qué dato deseas actualizar?");
                    System.out.println("1. Nombre del equipo");
                    System.out.println("2. Ciudad");
                    System.out.println("3. Salir");
                    System.out.print("\nOpcion: ");
                    choice2 = scanner.nextInt();
                    scanner.nextLine(); // Para manejar el salto de línea después de nextInt()

                    switch (choice2) {
                        case 1:
                            System.out.print("Ingrese el nuevo nombre del equipo:");
                            equipo.setNombre(scanner.nextLine());
                            break;
                        case 2:
                            System.out.print("Ingrese la nueva ciudad del equipo:");
                            equipo.setCiudad(scanner.nextLine());
                            break;

                        case 3:
                            break;
                        default:
                            System.out.print("Opción inválida, inténtelo de nuevo.");
                    }
                } while (choice2 != 3);

                break;

            case 3:

            Coach coach = new Coach();
            Doctor doctor = new Doctor();

            /* if (controlador.equipos.containsKey("001")) {
                System.out.println("SI EXISTE LA LLAVE EN HASHTABLE");
            } else {
                System.out.println("NO EXISTE LA LLAVE EN HASHTABLE");
            } */
                System.out.println("=============================");
                System.out.println("\tBuscar Equipo");
                System.out.println("=============================\n");

                System.out.print("Ingrese el codigo del equipo:");
                codigoEquipo = scanner.nextLine();

                equipo = controlador.equipos.get(codigoEquipo);

                if (equipo != null) {
                    System.out.println("===============================");
                    System.out.println("\n\tDATOS DEL EQUIPO");
                    System.out.println("===============================");
                    System.out.println("\tNombre: " + equipo.getNombre());
                    System.out.println("\tCiudad: " + equipo.getCiudad());
                
                    System.out.println("\n\n\n\tLISTA DE JUGADORES");
                    System.out.println("-------------------------------");
                    System.out.println("\tNombre   Apellido");
                    System.out.println("-------------------------------");

                    for (String key : datosJugadores.jugadores.keySet()) {
                        jugador = datosJugadores.jugadores.get(key);
                        if (jugador.getIdEquipo().equals(codigoEquipo)) {

                            System.out.println("\t" + jugador.getNombre() + "   " + jugador.getApellido());
                        }
                    }
                
                    System.out.println("\n\n\n\tLISTA DE COACHS");
                    System.out.println("-------------------------------");
                    System.out.println("\tNombre   Apellido");
                    System.out.println("-------------------------------");
                    for (String key : datosCoachs.entrenadores.keySet()) {
                        coach = datosCoachs.entrenadores.get(key);
                        if (coach.getIdEquipo().equals(codigoEquipo)) {

                            
                            System.out.println("\t" + coach.getNombre() + "   " + coach.getApellido());
                        }
                    }
                
                    System.out.println("\n\n\n\tLISTA DE DOCTORES");
                    System.out.println("-------------------------------");
                    System.out.println("\tNombre   Apellido");
                    System.out.println("-------------------------------");
                    for (String key : datosDoctores.doctores.keySet()) {
                        doctor = datosDoctores.doctores.get(key);
                        if (doctor.getIdEquipo().equals(codigoEquipo)) {

                           

                            System.out.println("\t" + doctor.getNombre() + "   " + doctor.getApellido());
                        }
                    }
                
                    scanner.nextLine();
                
                } else {
                    System.out.println("No se encontró un equipo con el código proporcionado.");
                }
                
                

                break;

            case 4:
                System.out.println("=============================");
                System.out.println("\nEliminar Equipo");
                System.out.println("=============================\n");

                System.out.print("Ingrese el codigo del equipo:");
                codigoEquipo = scanner.nextLine();

                Team eliminarEquipo = controlador.equipos.remove(codigoEquipo);

                if (eliminarEquipo != null) {
                    System.out.println("El equipo ha sido eliminado.");
                    System.out.println("Nombre: " + eliminarEquipo.getNombre());
                    System.out.println("Ciudad: " + eliminarEquipo.getCiudad());

                    // Eliminar jugadores, entrenadores y masajistas asociados
                    eliminarEquipo.getLstJugadores().clear();
                    eliminarEquipo.getLstEntrenadores().clear();
                    eliminarEquipo.getLstMasajistas().clear();
                    scanner.nextLine();

                } else {
                    System.out.println("No se encontró un equipo con el código proporcionado.");
                    
                }

                break;

            case 5:
            System.out.println("=================================");
            System.out.println("\tListar Equipos");
            System.out.println("=================================\n");
            
            Set<String> keys = controlador.equipos.keySet();
            ArrayList<String> lstKeyArrayList = new ArrayList<>(keys);
            
            System.out.println("------------------------------------------------");
            System.out.println("\tLISTA DE TODOS LOS EQUIPOS:");
            System.out.println("------------------------------------------------");
            System.out.printf("%-15s %-15s %-15s\n", "Código", "Nombre", "Ciudad");
            System.out.println("------------------------------------------------");
            
            for (String key : lstKeyArrayList) {
                Team t = controlador.equipos.get(key);
                System.out.printf("%-15s %-15s %-15s\n", key, t.getNombre(), t.getCiudad());
            }
            
            scanner.nextLine();
            

                break;

            case 6:
                return;

            default:
                System.out.println("Opción inválida, inténtelo de nuevo.");
        }
    }
}
}
