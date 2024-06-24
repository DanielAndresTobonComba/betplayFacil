package view;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import entity.Team;
import model.Controller;

public class viewTeam {

    public static Controller controlador = new Controller();

    public static String start() {

        Scanner scanner = new Scanner(System.in);
        String codigoEquipo = null;

        while (true) {

            System.out.println("1. Crear Equipo");
            System.out.println("2. Actualizar Equipo");
            System.out.println("3. Buscar Equipo");
            System.out.println("4. Eliminar Equipo");
            System.out.println("5. Listar todos Equipos");
            System.out.println("6. Salir");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Para manejar el salto de línea después de nextInt()

            switch (choice) {
                case 1:
                    // Crear Equipo
                    Team equipo = new Team();

                    System.out.println("Ingrese el codigo del equipo:");
                    codigoEquipo = scanner.nextLine();

                    System.out.println("Ingrese Nombre del equipo:");
                    equipo.setNombre(scanner.nextLine());

                    System.out.println("Ingrese la ciudad:");
                    equipo.setCiudad(scanner.nextLine());

                    controlador.equipos.put(codigoEquipo, equipo);

                    System.out.println(controlador.equipos);

                    break;

                case 2:
                    // Actualizar Equipo

                    System.out.println("Ingrese el codigo del equipo:");
                    codigoEquipo = scanner.nextLine();

                    equipo = controlador.equipos.get(codigoEquipo);
                    if (equipo == null) {
                        System.out.println("No se encontró un equipo con el código proporcionado.");
                        break;
                    }

                    int choice2;

                    do {
                        System.out.println("Que dato deseas actualizar?");
                        System.out.println("1. Nombre del equipo");
                        System.out.println("2. Ciudad");
                        System.out.println("3. Jugadores");
                        System.out.println("4. Entrenadores");
                        System.out.println("5. Doctores");
                        System.out.println("6. Salir");

                        choice2 = scanner.nextInt();
                        scanner.nextLine(); // Para manejar el salto de línea después de nextInt()

                        switch (choice2) {
                            case 1:
                                System.out.println("Ingrese el nuevo nombre del equipo:");
                                equipo.setNombre(scanner.nextLine());
                                break;
                            case 2:
                                System.out.println("Ingrese la nueva ciudad del equipo:");
                                equipo.setCiudad(scanner.nextLine());
                                break;
                            case 3:
                                // Actualizar Jugadores
                                break;
                            case 4:
                                // Actualizar Entrenadores
                                break;
                            case 5:
                                // Actualizar Doctores
                                break;
                            case 6:
                                break;
                            default:
                                System.out.println("Opción inválida, inténtelo de nuevo.");
                        }
                    } while (choice2 != 6);

                    break;

                case 3:
                    // Buscar Equipo
                    System.out.println("Ingrese el codigo del equipo:");
                    codigoEquipo = scanner.nextLine();

                    equipo = controlador.equipos.get(codigoEquipo);
                    
                    if (equipo != null) {
                        System.out.println("DATOS DEL EQUIPO");
                        System.out.println("Nombre: " + equipo.getNombre());
                        System.out.println("Ciudad: " + equipo.getCiudad());
                        System.out.println("Jugadores: " + equipo.getLstJugadores());
                        System.out.println("Entrenadores: " + equipo.getLstEntrenadores());
                        System.out.println("Masajistas: " + equipo.getLstMasajistas());
                    } else {
                        System.out.println("No se encontró un equipo con el código proporcionado.");
                    }

                    break;

                case 4:
                    // Eliminar Equipo
                    System.out.println("Ingrese el codigo del equipo:");
                    codigoEquipo = scanner.nextLine();

                    Team eliminarEquipo = controlador.equipos.remove(codigoEquipo);

                    if (eliminarEquipo != null) {
                        // Si el equipo fue eliminado, muestra sus detalles
                        System.out.println("El equipo ha sido eliminado.");
                        System.out.println("Nombre: " + eliminarEquipo.getNombre());
                        System.out.println("Ciudad: " + eliminarEquipo.getCiudad());
                        System.out.println("Jugadores: " + eliminarEquipo.getLstJugadores());
                        System.out.println("Entrenadores: " + eliminarEquipo.getLstEntrenadores());
                        System.out.println("Masajistas: " + eliminarEquipo.getLstMasajistas());
                    } else {
                        // Si el equipo no fue encontrado, muestra un mensaje de error
                        System.out.println("No se encontró un equipo con el código proporcionado.");
                    }

                    break;

                case 5:
                    // Listar todos los Equipos
                    Set<String> keys = controlador.equipos.keySet();
                    ArrayList<String> lstKeyArrayList = new ArrayList<>(keys);

                    System.out.println("LISTA DE TODOS LOS EQUIPOS:");
                    for (String key : lstKeyArrayList) {
                        Team t = controlador.equipos.get(key);
                        System.out.println("Código: " + key + ", Nombre: " + t.getNombre() + ", Ciudad: " + t.getCiudad());
                    }

                    break;

                case 6:
                    // Salir
                    return "";

                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        }
    }
}
