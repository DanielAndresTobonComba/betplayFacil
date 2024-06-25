package com.taller;

import java.util.Scanner;

import com.taller.views.viewCoach;
import com.taller.views.viewDoctor;
import com.taller.views.viewPlayer;
import com.taller.views.viewTeam;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int decision = 0;
        
        Controller ctrlPlayers = new Controller();
        Controller ctrlTeams = new Controller();
        Controller ctrlDoctors = new Controller();
        Controller ctrlCoachs = new Controller();

        viewPlayer.controlador = ctrlPlayers; 
        viewPlayer.datosEquipos = ctrlTeams;
    
        viewDoctor.controlador = ctrlDoctors;
        viewDoctor.datosEquipos = ctrlTeams;
        
        viewCoach.controlador = ctrlCoachs;
        viewCoach.datosEquipos = ctrlTeams;

        viewTeam.controlador = ctrlTeams;
        viewTeam.datosJugadores = ctrlPlayers;
        viewTeam.datosDoctores = ctrlDoctors; 
        viewTeam.datosCoachs = ctrlCoachs;

        
        

        do {
            System.out.println("=================================");
            System.out.println("    \tMENU PRINCIPAL");
            System.out.println("=================================");

            System.out.println("\n1. Gestor Equipos");
            System.out.println("2. Gestor Jugadores");
            System.out.println("3. Gestor Doctores");
            System.out.println("4. Gestor Coachs");
            System.out.println("5. Finalizar Programa");
            
            System.out.print("\nDigita el menu a escoger: ");
            
            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, ingresa un número válido: ");
                scanner.next(); // Desechar entrada no válida
            }
            decision = scanner.nextInt();

            switch (decision) {
                case 1:
                     //System.out.println("Equipos " + ctrlTeams.equipos );
                     scanner.nextLine();
                    // viewTeam vt = new viewTeam();
                    viewTeam.start();
                    
                    break;

                case 2:
                    //System.out.println("Equipos" + ctrlTeams.equipos );
                    scanner.nextLine();
                    // viewPlayer vp = new viewPlayer();
                    viewPlayer.start();
                    break;

                case 3:

                    //viewDoctor vd = new viewDoctor();
                    //vd.start();
                    viewDoctor.start();
                    break;

                case 4:
                    //viewCoach vc = new viewCoach();

                    viewCoach.start();
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