package model;


import java.util.Scanner;

import view.viewPlayer;
import view.viewTeam;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int decision = 0;

        try {
            System.out.println("Inserta tu codigo");
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

                default:
                    System.out.println("Opción no válida o fuera de rango");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
        


       // System.out.println("Jugador"+ eq.getLstJugadores().get(0).getNombre());
    }
}