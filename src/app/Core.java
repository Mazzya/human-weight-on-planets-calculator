package app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Core extends Thread {
    float earthWeight;
    final float earthGravity = 9.81f;
    float planetGravity;
    float planetWeight;
    int choice;
    Scanner scanner = new Scanner(System.in);

    enum Planets {
        Mercury,
        Venus,
        Mars,
        Jupiter,
        Saturn,
        Uranus,
        Neptune,
        Pluton,
        Moon
    }

    @Override
    public void run(){
        try {
            program();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void program() throws InterruptedException {


        System.out.println(" |    __\n" +
                " |--``\n" +
                " |\n" +
                " |\n" +
                " | ---'''     You are here:     :-)\n" +
                " |                  |                .'':\n" +
                " |                  V          .-\"\"\"\"-.'         .---.          .----.        .-\"\"\"-.\n" +
                " |             _    _        .\"     .' \".    ...\"     \"...    .\"      \".    .\"       \".\n" +
                " |  ---    o  (_)  (_)  ()   :    .'    :   '..:.......:..'   :        :    :         :   o\n" +
                " |                           :  .'      :       '.....'       '.      .'    '.       .'\n" +
                " |                          .'.'.      .'                       `''''`        `'''''`\n" +
                " |                         ''   ``````\n" +
                " | ---'''\n" +
                " |\n" +
                " |\n" +
                " |--..__");



        Thread.sleep(500);

        try {
            System.out.print("Your weight in Earth: ");
            earthWeight = scanner.nextFloat();
            cycle();
        } catch (InputMismatchException e) {
            System.out.println("You have to introduce an number");
        }
    }

    public void response(String planetName, String planetWeight) {
        System.out.println("Your weight in " + planetName + " is: " + planetWeight + " Kg");
    }

    public void showPlanets() {
        int i = 1;
        for (Planets planet: Planets.values()) {
            System.out.println((i++) + ") " + planet);
        }
    }


    public void cycle() throws InterruptedException {
        while (true) {
            showPlanets();

            System.out.print("Choose a planet (if you want exit, press 0) : ");

            choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Bye");
                break;
            }

            calculateWeight(choice);

            Thread.sleep(500);
        }
    }

    public void calculateWeight(int choice) {
        switch (choice) {
            case 1 -> {
                planetGravity = 3.7f;
                planetWeight = earthWeight / earthGravity * planetGravity;
                response(Planets.Mercury.name(), String.format("%.2f", planetWeight));
            }
            case 2 -> {
                planetGravity = 8.87f;
                planetWeight = earthWeight / earthGravity * planetGravity;
                response(Planets.Venus.name(), String.format("%.2f", planetWeight));
            }
            case 3 -> {
                planetGravity = 3.711f;
                planetWeight = earthWeight / earthGravity * planetGravity;
                response(Planets.Mars.name(), String.format("%.2f", planetWeight));
            }
            case 4 -> {
                planetGravity = 24.79f;
                planetWeight = earthWeight / earthGravity * planetGravity;
                response(Planets.Jupiter.name(), String.format("%.2f", planetWeight));
            }
            case 5 -> {
                planetGravity = 10.44f;
                planetWeight = earthWeight / earthGravity * planetGravity;
                response(Planets.Saturn.name(), String.format("%.2f", planetWeight));
            }
            case 6 -> {
                planetGravity = 8.69f;
                planetWeight = earthWeight / earthGravity * planetGravity;
                response(Planets.Uranus.name(), String.format("%.2f", planetWeight));
            }
            case 7 -> {
                planetGravity = 11.15f;
                planetWeight = earthWeight / earthGravity * planetGravity;
                response(Planets.Neptune.name(), String.format("%.2f", planetWeight));
            }
            case 8 -> {
                planetGravity = 0.62f;
                planetWeight = earthWeight / earthGravity * planetGravity;
                response(Planets.Pluton.name(), String.format("%.2f", planetWeight));
            }
            case 9 -> {
                planetGravity = 1.62f;
                planetWeight = earthWeight / earthGravity * planetGravity;
                response(Planets.Moon.name(), String.format("%.2f", planetWeight));
            }
            default -> System.out.println("Try again please");
        }
    }

    public static void main(String[] args) {
        Core core = new Core();
        core.start();
    }
}
