import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);

    static Player player;

    public static boolean isRunning;

    // Elementos da historia

    public static int place = 0, act;
    public static String[] places = {"Arredores de Whitechapel", "Pousada do Lamento", "Taverna do Lobo Solitário", "A Loja dos pesadelos", "Subterrâneo(Esgoto)", "Hospital Cullen", "Bar da Marceline", "Castelo da Vânia", "Observatório Real", "Ruas de Greenwich", "Salão do sangue de Vladimir", "Cálice da Noite", "Inventario de Nosferatu", "Cemiterio Highgate", "Altar do Drácula" };

    public static int readInt(String prompt, int userChoices) {
        int input;
        do {
            System.out.print(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;
                System.out.print("");

            }
        } while (input < 1 || input > userChoices);
        return input;

    }

    public static void clearConsole() {
        for (int i = 0; i < 100; i++)
            ;
        System.out.println();

    }

    public static void printSeparator(int n) {
        for (int i = 0; i < n; i++)
            ;
        System.out.print("-");
        System.out.println();
    }

    public static void printHeading(String title) {
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

    public static void anythingToContinue() {
        System.out.println("\nInsira qualquer coisa para continuar...");
    }

    public static void startGame() {
        boolean nameSet = false;
        String name;
        // printar a tela de inicio
        clearConsole();
        printSeparator(40);
        printSeparator(30);
        System.out.println("VAMPIRE HUNTERS");
        System.out.println("Rpg de texto para A3");
        printSeparator(30);
        printSeparator(40);
        anythingToContinue();

        do {
            clearConsole();
            printHeading("Qual o seu nome?");
            name = scanner.next();
            // perguntar se quer corrigir o nome
            clearConsole();
            printHeading("Seu nome é " + name + ".\nEstá correto?");
            System.out.println("(1) Sim");
            System.out.println("(2) Não, eu quero mudar meu nome");
            int input = readInt("-> ", 2);
            if (input == 1)
                nameSet = true;
        } while (!nameSet);

        //intro da historia
        Historia.printIntro();

        // criar novo objeto player com nome
        player = new Player(name);

        Historia.printFirstActIntro();

        // configuração isRunning true para dar loop

        isRunning = true;

        // comear o loop do jogo
        gameLoop();
    }

    public static void continueJourney() {

    }

    public static void characterInfo() {
        clearConsole();
        printHeading("INFORMAÇÕES DO PERSONAGEM");
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
        printSeparator(20);
        System.out.println("XP: " + player.xp);

        // printando os traços escolhidos
        if (player.numAtkUpgrades > 0) {
            System.out.println("Traço ofensivo: " + player.atkUpgrades[player.numAtkUpgrades]);
            printSeparator(20);
        }
        if (player.numDefUpgrades > 0) {
            System.out.println("Traço defensivo: " + player.defUpgrades[player.numDefUpgrades]);

        }
        anythingToContinue();
    }

    public static void printMenu() {
        clearConsole();
        printHeading(places[place]);
        System.out.println("Escolha uma ação");
        printSeparator(20);
        System.out.println("(1) Continuar sua jornada");
        System.out.println("(2) Informações do Personagem");
        System.out.println("(3) Saída");
    }

    public static void gameLoop() {
        while (isRunning) {
            printMenu();
            int input = readInt("-> ", 3);
            if (input == 1)
                continueJourney();
            else if (input == 2)
                characterInfo();
            else
                isRunning = false;
            ;
        }
    }
}
