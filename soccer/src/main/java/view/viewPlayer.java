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

                     int decision = scanner.nextInt();

                     Player jugador = new Player();
                    
                     String codigoJugador = "";

                     System.out.println("1. Ingresar Jugador");
                     System.out.println("2. Actualizar Jugador");
                     System.out.println("3. Buscar Jugador");
                     System.out.println("4. Eliminar Jugador");
                     System.out.println("5. Listar todos Jugadores"); 
                     System.out.println("6. Salir");   
                     
                     switch (decision) {
                            case 1:      
                            
                                   
                                  /*  int id = 0; 
                                   String nombre = "";
                                   String apellido = "";
                                   int edad = 0 ;
                                   int drosal = 0; 
                                   String posicion = ""; */
                                   

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