package model;

import java.util.Scanner;
import view.viewCoach;
import view.viewDoctor;
import view.viewPlayer;
import view.viewTeam;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int decision = 0;

        do {
            System.out.println("MENU PRINCIPAL\n");

            System.out.println("1. Menu Equipos");
            System.out.println("2. Menu Jugadores");
            System.out.println("3. Menu Doctores");
            System.out.println("4. Menu Coachs");
            System.out.println("5. Finalizar Programa");

            System.out.println("\nDigita el menu a escoger: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingresa un número válido.");
                scanner.next(); // Desechar entrada no válida
            }
            decision = scanner.nextInt();

            switch (decision) {
                case 1:
                    viewTeam vt = new viewTeam();
                    vt.start();
                    break;

                case 2:
                    viewPlayer vp = new viewPlayer();
                    vp.start();
                    break;

                case 3:
                    viewDoctor vd = new viewDoctor();
                    vd.start();
                    break;

                case 4:
                    viewCoach vc = new viewCoach();
                    vc.start();
                    break;

                case 5:
                    scanner.close();
                    break;

                default:
                    System.out.println("Opción no válida o fuera de rango");
                    break;
            }
        } while (decision != 5);

        System.out.println("\nPrograma finalizado");
    }
}


/*package model;


import java.util.Scanner;

import view.viewCoach;
import view.viewDoctor;
import view.viewPlayer;
import view.viewTeam;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int decision = 0;

        do {
            System.out.println("MENU PRINCIPAL\n");

            System.out.println("1. Menu Equipos");
            System.out.println("2. Menu Jugadores");
            System.out.println("3. Menu Doctores");
            System.out.println("5. Menu Coachs");
            System.out.println("6. Finalizar Programa");
            
            System.out.println("\nDigita el menu a escoger: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingresa un número válido.");
                scanner.next(); // Desechar entrada no válida
            }
            decision = scanner.nextInt();

            switch (decision) {
                case 1:
                    Controller ctrlTeams = new Controller();
                    viewTeam.controlador = ctrlTeams;
                    viewTeam vt = new viewTeam();
                    vt.start();
                    break;

                case 2:
                    Controller ctrlPlayers = new Controller();
                    viewPlayer.controlador = ctrlPlayers;
                    viewPlayer vp = new viewPlayer();
                    vp.start();
                    break;

                case 3: 
                    Controller ctrlDoctors = new Controller();
                    viewDoctor.controlador = ctrlDoctors;
                    viewDoctor vd = new viewDoctor();
                    vd.start();
                    break;

                case 4: 
                    Controller ctrlCoachs = new Controller();
                    viewCoach.controlador = ctrlCoachs;
                    viewCoach vc = new viewCoach();
                    vc.start();
                    break;

                case 5: 
                    scanner.close();
                    break;

                default:
                    System.out.println("Opción no válida o fuera de rango");
                    break;
            }
        } while (decision != 5);

        System.out.println("\nPrograma finalizado");

    }
}
     

         try {
           
            
            

            }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
         
        

       // System.out.println("Jugador"+ eq.getLstJugadores().get(0).getNombre());
    
*/