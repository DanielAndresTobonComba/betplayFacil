package view;

import java.util.Scanner;

import entity.Coach;

import model.Controller;

public class viewCoach {


    public static Controller controlador = new Controller();

    public void start(){

        Scanner scanner = new Scanner(System.in);
        String codigoCoach = "";
        int decision = 0;

        while (true) {

            System.out.println("1. Ingresar Coach");
            System.out.println("2. Actualizar Coach");
            System.out.println("3. Buscar Coach");
            System.out.println("4. Eliminar Coach");
            System.out.println("5. Listar todos los  Coachs");
            System.out.println("6. Salir");

            System.out.println("Ingresa la opcion");
            decision = scanner.nextInt();
            scanner.nextLine(); // Para manejar el salto de línea después de nextInt()

            switch (decision) {
                case 1:
                    Coach coach = new Coach();

                    System.out.println("Ingresa id del Coach:");
                    codigoCoach = scanner.nextLine();

                    System.out.println("Digita el nombre");
                    coach.setNombre(scanner.nextLine());

                    System.out.println("Digita el apellido");
                    coach.setApellido(scanner.nextLine());

                    System.out.println("Digita la edad");
                    coach.setEdad(scanner.nextInt());
                    scanner.nextLine();

                    System.out.println("Digita la id de la federacion");
                    coach.setIdFederacion(scanner.nextInt());
                    scanner.nextLine();

                    controlador.entrenadores.put(codigoCoach, coach);

                    System.out.println("El coach ha sido creado exitosamente");

                    coach = controlador.entrenadores.get(codigoCoach);

                    if (coach != null) {
                        System.out.println("\nDATOS DEL DOCTOR");
                        System.out.println("Nombre: " + coach.getNombre());
                        System.out.println("Apellido: " + coach.getApellido());
                        System.out.println("Edad: " + coach.getEdad());
                        System.out.println("Federacion: " + coach.getIdFederacion());
                        
                    } else {
                        System.out.println("Error al mostrar los datos del coach");
                    }

                    break;

                case 2:
                    System.out.println("Ingrese el codigo del coach:");
                    codigoCoach = scanner.nextLine();

                    coach = controlador.entrenadores.get(codigoCoach);

                    if (coach == null) {
                        System.out.println("No se encontró un coach con el código ingresado.");
                    } else {
                        int choice2;

                        do {
                            System.out.println("Que dato deseas actualizar?");
                            System.out.println("1. Nombre");
                            System.out.println("2. Apellido");
                            System.out.println("3. Edad");
                            System.out.println("4. Federacion");
                            System.out.println("5. Salir");

                            choice2 = scanner.nextInt();
                            scanner.nextLine(); // Para manejar el salto de línea después de nextInt()

                            switch (choice2) {
                                case 1:
                                    System.out.println("Ingrese el nuevo nombre:");
                                    coach.setNombre(scanner.nextLine());
                                    break;

                                case 2:
                                    System.out.println("Ingrese el nuevo apellido:");
                                    coach.setApellido(scanner.nextLine());
                                    break;

                                case 3:
                                    System.out.println("Ingrese la nueva edad:");
                                    coach.setEdad(scanner.nextInt());
                                    scanner.nextLine(); // Para manejar el salto de línea después de nextInt()
                                    break;

                                case 4:
                                    System.out.println("Ingrese la nueva federacion:");
                                    coach.setIdFederacion(scanner.nextInt());
                                    scanner.nextLine(); // Para manejar el salto de línea después de nextInt()
                                    break;

                                case 5:
                                    break;

                                default:
                                    System.out.println("Opción inválida, inténtelo de nuevo.");
                                    break;
                            }

                            System.out.println("\nDATOS ACTUALIZADOS DEL COACH");
                            System.out.println("Nombre: " + coach.getNombre());
                            System.out.println("Apellido: " + coach.getApellido());
                            System.out.println("Edad: " + coach.getEdad());
                            System.out.println("Federacion: " + coach.getIdFederacion());
                            

                        } while (choice2 != 5);
                    }

                    break;
                case 3:
                    System.out.println("Ingresa el codigo del coach:");
                    codigoCoach = scanner.nextLine();

                    coach = controlador.entrenadores.get(codigoCoach);

                    if (coach != null) {
                        System.out.println("\nDATOS DEL COACH");
                        System.out.println("Nombre: " + coach.getNombre());
                        System.out.println("Apellido: " + coach.getApellido());
                        System.out.println("Edad: " + coach.getEdad());
                        System.out.println("Federacion: " + coach.getIdFederacion());
                    } else {
                        System.out.println("El codigo del coach no existe");
                    }

                    break;
                case 4:
                    System.out.println("Ingresa el codigo del coach:");
                    codigoCoach = scanner.nextLine();

                    coach = controlador.entrenadores.remove(codigoCoach);

                    if (coach != null) {
                        System.out.println("\nDATOS DEL COACH ELIMINADO");
                        System.out.println("Nombre: " + coach.getNombre());
                        System.out.println("Apellido: " + coach.getApellido());
                        System.out.println("Edad: " + coach.getEdad());
                        System.out.println("Federacion: " + coach.getIdFederacion());
                    } else {
                        System.out.println("El codigo del coach no existe");
                    }

                    break;
                case 5:
                    System.out.println("LISTA DE TODOS LOS COACHS");
                    for (String key : controlador.jugadores.keySet()) {
                        coach = controlador.entrenadores.get(key);

                        System.out.println("\nDATOS DEL LOS DOCTORES");
                        System.out.println("ID: " + key);
                        System.out.println("Nombre: " + coach.getNombre());
                        System.out.println("Apellido: " + coach.getApellido());
                        System.out.println("Edad: " + coach.getEdad());
                        System.out.println("Federacion: " + coach.getIdFederacion());
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
