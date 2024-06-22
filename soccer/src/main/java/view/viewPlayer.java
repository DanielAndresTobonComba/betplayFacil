package view;

import java.util.Enumeration;
import java.util.Map;
import java.util.Scanner;

import entity.Player;
import model.Controller;



public class viewPlayer {
       
        public static Controller controlador = new Controller();

        public void start() {

              Scanner scanner = new Scanner(System.in);
              

              while (true) {

                     
                     int decision = 0;

                     Player jugador = new Player();
                    
                     String codigoJugador = "";

                     System.out.println("1. Ingresar Jugador");
                     System.out.println("2. Actualizar Jugador");
                     System.out.println("3. Buscar Jugador");
                     System.out.println("4. Eliminar Jugador");
                     System.out.println("5. Listar todos Jugadores"); 
                     System.out.println("6. Salir"); 

                     System.out.println("Ingresa la opcion");
                     decision = scanner.nextInt(); 
                     
                     switch (decision) {
                            case 1:      
                                   
                                   System.out.println("Ingresa id del jugador:");
                                   codigoJugador = scanner.nextLine();
                                   
                                   // System.out.println("Digita el id del equipo");
                                   scanner.nextLine();

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


                                   controlador.jugadores.put(codigoJugador, jugador);

                                   System.out.println("El jugador ha sido creado exitosamente");

                                   jugador = controlador.jugadores.get(codigoJugador); 

                                   if (jugador != null){
                                          System.out.println("\nDATOS DEL Jugador");
                                          System.out.println("Nombre: " + jugador.getNombre());
                                          System.out.println("Apellido: " + jugador.getApellido());
                                          System.out.println("Edad: " + jugador.getEdad());
                                          System.out.println("Dorsal: " + jugador.getDorsal());
                                          System.out.println("Posicion: " + jugador.getPosicion());
                                   }else {
                                          System.out.println("Error al mostrar los datos del jugador");
                                   }                                     
                                  
                                   break;

                            case 2:   
                                   System.out.println("Ingrese el codigo del jugador:");
                                   codigoJugador = scanner.nextLine();    

                                   jugador = controlador.jugadores.get(codigoJugador);

                                   if (jugador == null) {
                                          System.out.println("No se encontró un jugador con el código ingresado.");
                                          break;
                                          
                                   } else {

                                          int choice2;

                                          do {
                                                 System.out.println("Que dato deseas actualizar?");
                                                 System.out.println("1. Nombre");
                                                 System.out.println("2. Apellido");
                                                 System.out.println("3. Edad");
                                                 System.out.println("4. Dorsal");
                                                 System.out.println("5. Posicion");
                                                 System.out.println("6. Salir");
       
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
                                                               System.out.println("Ingrese el nuevo apellido:");
                                                               jugador.setEdad(scanner.nextInt());
                                                        break;
       
                                                        case 4:
                                                               System.out.println("Ingrese el nuevo dorsal:");
                                                               jugador.setDorsal(scanner.nextInt());
                                                        break;
       
                                                        case 5:
                                                               System.out.println("Ingrese la nuevo posicion:");
                                                               jugador.setPosicion(scanner.nextLine());
                                                        break;
       
                                                        case 6:
                                                        break;
       
                                                        default:
                                                        System.out.println("Opción inválida, inténtelo de nuevo.");
                                                 }
       
                                                 System.out.println("\nDATOS ACTUALIZADOS DEL Jugador");
                                                 System.out.println("Nombre: " + jugador.getNombre());
                                                 System.out.println("Apellido: " + jugador.getApellido());
                                                 System.out.println("Edad: " + jugador.getEdad());
                                                 System.out.println("Dorsal: " + jugador.getDorsal());
                                                 System.out.println("Posicion: " + jugador.getPosicion());
       
       
                                          } while (choice2 != 6);
                                          
                                   }

                                   
                                   
                                   break;
                            case 3:
                                   
                                   break;
                            case 4:
                                   
                                   break;

                            case 5:
                            
                                   break;

                            case 6:
                                   scanner.close();
                                   System.exit(0);
                                   break;
                     
                            default:
                                   break;
                     }
              }

             
                     
              
       
        }

        
}   