package view;

import java.util.Scanner;

import entity.Doctor;
import model.Controller;

public class viewDoctor {

    public static Controller controlador = new Controller();

    public String start() {

        Scanner scanner = new Scanner(System.in);
        String codigoDoctor = "";
        int decision = 0;

        while (true) {

            System.out.println("1. Ingresar Doctor");
            System.out.println("2. Actualizar Doctor");
            System.out.println("3. Buscar Doctor");
            System.out.println("4. Eliminar Doctor");
            System.out.println("5. Listar todos Doctor");
            System.out.println("6. Salir");

            System.out.println("Ingresa la opcion");
            decision = scanner.nextInt();
            scanner.nextLine(); // Para manejar el salto de línea después de nextInt()

            switch (decision) {
                case 1:
                    Doctor doctor = new Doctor();

                    System.out.println("Ingresa id del doctor:");
                    codigoDoctor = scanner.nextLine();

                    System.out.println("Digita el nombre");
                    doctor.setNombre(scanner.nextLine());

                    System.out.println("Digita el apellido");
                    doctor.setApellido(scanner.nextLine());

                    System.out.println("Digita la edad");
                    doctor.setEdad(scanner.nextInt());
                    scanner.nextLine();

                    System.out.println("Digita la posicion");
                    doctor.setTitulo(scanner.nextLine());

                    System.out.println("Digita los años de experiencia");
                    doctor.setExpYear(scanner.nextInt());
                    scanner.nextLine();

                    controlador.doctores.put(codigoDoctor, doctor);

                    System.out.println("El doctor ha sido creado exitosamente");

                    doctor = controlador.doctores.get(codigoDoctor);

                    if (doctor != null) {
                        System.out.println("\nDATOS DEL DOCTOR");
                        System.out.println("Nombre: " + doctor.getNombre());
                        System.out.println("Apellido: " + doctor.getApellido());
                        System.out.println("Edad: " + doctor.getEdad());
                        System.out.println("Dorsal: " + doctor.getTitulo());
                        System.out.println("Posicion: " + doctor.getExpYear());
                    } else {
                        System.out.println("Error al mostrar los datos del doctor");
                    }

                    break;

                case 2:
                    System.out.println("Ingrese el codigo del doctor:");
                    codigoDoctor = scanner.nextLine();

                    doctor = controlador.doctores.get(codigoDoctor);

                    if (doctor == null) {
                        System.out.println("No se encontró un doctor con el código ingresado.");
                    } else {
                        int choice2;

                        do {
                            System.out.println("Que dato deseas actualizar?");
                            System.out.println("1. Nombre");
                            System.out.println("2. Apellido");
                            System.out.println("3. Edad");
                            System.out.println("4. Titulo");
                            System.out.println("5. Años de experiencia");
                            System.out.println("6. Salir");

                            choice2 = scanner.nextInt();
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
                                    System.out.println("Ingrese el nuevo dorsal:");
                                    doctor.setTitulo(scanner.nextLine());
                                    scanner.nextLine(); // Para manejar el salto de línea después de nextInt()
                                    break;

                                case 5:
                                    System.out.println("Ingrese la nueva posicion:");
                                    doctor.setExpYear(scanner.nextInt());
                                    break;

                                case 6:
                                    break;

                                default:
                                    System.out.println("Opción inválida, inténtelo de nuevo.");
                                    break;
                            }

                            System.out.println("\nDATOS ACTUALIZADOS DEL Doctor");
                            System.out.println("Nombre: " + doctor.getNombre());
                            System.out.println("Apellido: " + doctor.getApellido());
                            System.out.println("Edad: " + doctor.getEdad());
                            System.out.println("Titulo: " + doctor.getTitulo());
                            System.out.println("Años de experiencia: " + doctor.getExpYear());

                        } while (choice2 != 6);
                    }

                    break;
                case 3:
                    System.out.println("Ingresa el codigo del doctor:");
                    codigoDoctor = scanner.nextLine();

                    doctor = controlador.doctores.get(codigoDoctor);

                    if (doctor != null) {
                        System.out.println("\nDATOS DEL DOCTOR");
                        System.out.println("Nombre: " + doctor.getNombre());
                        System.out.println("Apellido: " + doctor.getApellido());
                        System.out.println("Edad: " + doctor.getEdad());
                        System.out.println("Titulo: " + doctor.getTitulo());
                        System.out.println("Años de Experiencia: " + doctor.getExpYear());
                    } else {
                        System.out.println("El codigo del doctor no existe");
                    }

                    break;
                case 4:
                    System.out.println("Ingresa el codigo del doctor:");
                    codigoDoctor = scanner.nextLine();

                    doctor = controlador.doctores.remove(codigoDoctor);

                    if (doctor != null) {
                        System.out.println("\nDATOS DEL DOCTOR ELIMINADO");
                        System.out.println("Nombre: " + doctor.getNombre());
                        System.out.println("Apellido: " + doctor.getApellido());
                        System.out.println("Edad: " + doctor.getEdad());
                        System.out.println("Dorsal: " + doctor.getTitulo());
                        System.out.println("Posicion: " + doctor.getExpYear());
                    } else {
                        System.out.println("El codigo del doctor no existe");
                    }

                    break;
                case 5:
                    System.out.println("LISTA DE TODOS LOS DOCTORES");
                    for (String key : controlador.jugadores.keySet()) {
                        doctor = controlador.doctores.get(key);

                        System.out.println("\nDATOS DEL LOS DOCTORES");
                        System.out.println("ID: " + key);
                        System.out.println("Nombre: " + doctor.getNombre());
                        System.out.println("Apellido: " + doctor.getApellido());
                        System.out.println("Edad: " + doctor.getEdad());
                        System.out.println("Dorsal: " + doctor.getTitulo());
                        System.out.println("Posicion: " + doctor.getExpYear());
                    }
                    break;
                case 6:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
                    break;
            }
        }





    }
}   
