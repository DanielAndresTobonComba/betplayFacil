package com.taller.views;

import java.io.DataOutput;
import java.util.Scanner;

import com.taller.Controller;
import com.taller.Model.entity.Doctor;
import com.taller.Model.entity.Team;

public class viewDoctor {

    public static Controller controlador;

    public static Controller datosEquipos;

    public static void start() {

        Doctor doctor = new Doctor();

        Scanner scanner = new Scanner(System.in);

        String codigoDoctor;
        int decision;
        String codigoEquipo;
        Team equipo = new Team();

        doctor.setNombre("Felipe");
        doctor.setApellido("Cardenas");
        doctor.setEdad(34);
        doctor.setExpYear(15);
        doctor.setTitulo("Medico General");
        doctor.setIdEquipo("1");
        controlador.doctores.put("1", doctor);

        /* System.out.println(controlador.equipos);
        System.out.println(controlador.doctores.get("1").getNombre()); */

        while (true) {
            System.out.println("=============================");
            System.out.println("\tMenu Doctores");
            System.out.println("=============================\n");

            System.out.println("1. Ingresar Doctor");
            System.out.println("2. Actualizar Doctor");
            System.out.println("3. Buscar Doctor");
            System.out.println("4. Eliminar Doctor");
            System.out.println("5. Listar todos Doctores");
            System.out.println("6. Salir");

            System.out.println("Ingresa la opcion");
            decision = scanner.nextInt();
            scanner.nextLine(); // Para manejar el salto de línea después de nextInt()

            switch (decision) {
                case 1:
                    System.out.println("=============================");
                    System.out.println("\tCrear Doctor");
                    System.out.println("=============================\n");

                    System.out.println("Ingresa id del doctor:");
                    codigoDoctor = scanner.nextLine();

                    System.out.println("Digita el nombre");
                    doctor.setNombre(scanner.nextLine());

                    System.out.println("Digita el apellido");
                    doctor.setApellido(scanner.nextLine());

                    System.out.println("Digita la edad");
                    doctor.setEdad(scanner.nextInt());
                    scanner.nextLine();

                    System.out.println("Digita el titulo");
                    doctor.setTitulo(scanner.nextLine());

                    System.out.println("Digita los años de experiencia");
                    doctor.setExpYear(scanner.nextInt());
                    scanner.nextLine();

                    System.out.println("Digita el codigo del equipo");
                    codigoEquipo = scanner.nextLine();
                    doctor.setIdEquipo(codigoEquipo);


                    equipo = datosEquipos.equipos.get(codigoEquipo);

                    if (equipo != null) {

                        controlador.doctores.put(codigoDoctor, doctor); // Agregar el doctor al controlador
                        equipo.getLstMasajistas().add(doctor); // Agregar el doctor al equipo
                        System.out.println("El doctor ha sido creado exitosamente");
                        scanner.nextLine();

                    } else {
                        System.out.println("No se encontró un equipo con el código proporcionado.");
                        scanner.nextLine();
                    }

                    break;

                case 2:
                    System.out.println("=============================");
                    System.out.println("\tModificar Doctor");
                    System.out.println("=============================\n");
                    System.out.println("Ingrese el codigo del doctor:");
                    codigoDoctor = scanner.nextLine();

                    doctor = controlador.doctores.get(codigoDoctor);

                    if (doctor == null) {
                        System.out.println("No se encontró un doctor con el código ingresado.");
                    } else {
                        int choice2;

                        do {
                            System.out.println("Qué dato deseas actualizar?");
                            System.out.println("1. Nombre");
                            System.out.println("2. Apellido");
                            System.out.println("3. Edad");
                            System.out.println("4. Titulo");
                            System.out.println("5. Años de experiencia");
                            System.out.println("6. Equipo");
                            System.out.println("7. Salir");

                            choice2 = scanner.nextInt();
                            System.out.print("Opcion: "); 
                            scanner.nextLine(); // Para manejar el salto de línea después de nextInt()

                            switch (choice2) {
                                case 1:
                                    System.out.println("Ingrese el nuevo nombre del doctor:");
                                    doctor.setNombre(scanner.nextLine());
                                    break;

                                case 2:
                                    System.out.println("Ingrese el nuevo apellido:");
                                    doctor.setApellido(scanner.nextLine());
                                    break;

                                case 3:
                                    System.out.println("Ingrese la nueva edad:");
                                    doctor.setEdad(scanner.nextInt());
                                    scanner.nextLine(); // Para manejar el salto de línea después de nextInt()
                                    break;

                                case 4:
                                    System.out.println("Ingrese el nuevo título:");
                                    doctor.setTitulo(scanner.nextLine());
                                    break;

                                case 5:
                                    System.out.println("Ingrese los nuevos años de experiencia:");
                                    doctor.setExpYear(scanner.nextInt());
                                    scanner.nextLine(); // Para manejar el salto de línea después de nextInt()
                                    break;

                                case 6:
                                    System.out.println("Ingrese el id del equipo:");

                                    String nuevoCodigoEquipo = scanner.nextLine();

                                    Team nuevoEquipo = datosEquipos.equipos.get(nuevoCodigoEquipo);

                                    if (nuevoEquipo != null) {

                                        Team equipoActual = datosEquipos.equipos.get(doctor.getIdEquipo());

                                        doctor.setIdEquipo(nuevoCodigoEquipo);

                                        if (equipoActual != null) {
                                            equipoActual.getLstMasajistas().remove(doctor);
                                        }

                                        nuevoEquipo.getLstMasajistas().add(doctor);
    
                                        System.out.println("\nDATOS ACTUALIZADOS DEL DOCTOR");
                                        System.out.println("Nombre: " + doctor.getNombre());
                                        System.out.println("Apellido: " + doctor.getApellido());
                                        System.out.println("Edad: " + doctor.getEdad());
                                        System.out.println("Titulo: " + doctor.getTitulo());
                                        System.out.println("Experiencia: " + doctor.getExpYear());
                                        System.out.println("IdEquipo:" + doctor.getIdEquipo());
                                        
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
                    System.out.println("Ingresa el codigo del doctor:");
                    codigoDoctor = scanner.nextLine();

                    doctor = controlador.doctores.get(codigoDoctor);

                    if (doctor != null) {

                        System.out.println("=============================");
                        System.out.println("\tBuscar Doctor");
                        System.out.println("=============================\n");

                        

                        System.out.println("===============================");
                        System.out.println("\n\tDATOS DEL DOCTOR");
                        System.out.println("===============================");

                        System.out.println("Nombre: " + doctor.getNombre());
                        System.out.println("Apellido: " + doctor.getApellido());
                        System.out.println("Edad: " + doctor.getEdad());
                        System.out.println("Titulo: " + doctor.getTitulo());
                        System.out.println("Años de Experiencia: " + doctor.getExpYear());
                        scanner.nextLine();

                        Team equipoDoctor = datosEquipos.equipos.get(doctor.getIdEquipo());
                        /* if (equipoDoctor != null) {
                            System.out.println("Equipo: " + equipoDoctor.getNombre());
                        } else {
                            System.out.println("El doctor no está asignado a ningún equipo.");
                        } */
                    } else {
                        System.out.println("El codigo del doctor no existe");
                    }

                    break;

                case 4:

                    System.out.println("===============================");
                    System.out.println("\n\tELIMINAR DOCTOR");
                    System.out.println("===============================");
                    System.out.println("Ingresa el codigo del doctor:");
                    codigoDoctor = scanner.nextLine();

                    doctor = controlador.doctores.remove(codigoDoctor);

                    if (doctor != null) {
                        Team equipoEliminar = datosEquipos.equipos.get(doctor.getIdEquipo());
                        if (equipoEliminar != null) {
                            equipoEliminar.getLstMasajistas().remove(doctor);
                        }

                        System.out.println("===============================");
                        System.out.println("\nDATOS DEL DOCTOR ELIMINADO");
                        System.out.println("===============================");

                        System.out.println("Nombre: " + doctor.getNombre());
                        System.out.println("Apellido: " + doctor.getApellido());
                        System.out.println("Edad: " + doctor.getEdad());
                        System.out.println("Titulo: " + doctor.getTitulo());
                        System.out.println("Años de Experiencia: " + doctor.getExpYear());
                    } else {
                        System.out.println("El codigo del doctor no existe");
                    }

                    break;

                case 5:

                        System.out.println("--------------------------------------------------------------------------");
                        System.out.println("\tLISTA DE TODOS LOS DOCTORES:");
                        System.out.println("--------------------------------------------------------------------------");

                        System.out.printf("%-10s %-10s %-10s %-15s %-10s %-10s\n", "Código", "Nombre", "Apellido" , "Edad" , "Titulo" , "Experiencia");

                        System.out.println("--------------------------------------------------------------------------");
                        
                        for (String key : controlador.doctores.keySet()) {

                            doctor = controlador.doctores.get(key);



                            System.out.printf("%-10s %-10s %-10s %-10s %-15s %-10s" , key , doctor.getNombre(), doctor.getApellido(),doctor.getEdad(),doctor.getTitulo(),doctor.getExpYear());


                            /* System.out.println("\nDATOS DE LOS DOCTORES");
                            System.out.println("ID: " + key);
                            System.out.println("Nombre: " + doctor.getNombre());
                            System.out.println("Apellido: " + doctor.getApellido());
                            System.out.println("Edad: " + doctor.getEdad());
                            System.out.println("Titulo: " + doctor.getTitulo());
                            System.out.println("Años de Experiencia: " + doctor.getExpYear());
 */
                        //Team equipoDoc = datosEquipos.equipos.get(doctor.getIdEquipo());

                        /* if (equipoDoc != null) {
                            System.out.println("Equipo: " + equipoDoc.getNombre());
                        } else {
                            System.out.println("El doctor no está asignado a ningún equipo.");
                        } */
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
