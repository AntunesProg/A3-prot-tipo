import bin.Config.Monsters.*;
import bin.Config.Boss.*;
import java.util.Scanner;

public class config {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String escolhasPrincipal = "\nMenu Principal\n1 - Monsters\n2 - Sair";
        String escolhasMonsters = "\nMenu Monsters\n1 - Criar monstro\n2 - Deletar monstro\n3 - Editar monstro\n4 - Voltar";
        String escolhasBoss = "\nMenu Boss\n1 - Criar Boss\n2 - Deletar Boss\n3 - Editar Boss\n4 - Voltar";

        while (true) {
            System.out.println("\nConfigurações do Vampire Hunters\nSelecione a opção:" + escolhasPrincipal);

            if (scanner.hasNextInt()) {
                int escolhaPrincipal = scanner.nextInt();

                if (escolhaPrincipal == 2) {
                    System.out.println("Saindo...");
                    break;
                } else if (escolhaPrincipal == 1) {
                    while (true) {
                        System.out.println("\n" + escolhasMonsters);

                        if (scanner.hasNextInt()) {
                            int escolhaMonsters = scanner.nextInt();

                            if (escolhaMonsters == 4) {
                                break;
                            } else if (escolhaMonsters == 1) {
                                criarMonsters.main(new String[] {});
                            } else if (escolhaMonsters == 2) {
                                apagarMonsters.main(new String[] {});
                            } else if (escolhaMonsters == 3) {
                                editarMonsters.main(new String[] {});
                            } else {
                                System.out.println("Opção inválida. Tente novamente.");
                            }
                        } else {
                            scanner.next();
                            System.out.println("Opção inválida. Tente novamente.");
                        }
                    }
                } else if (escolhaPrincipal == 999) {
                    while (true) {
                        System.out.println("\n" + escolhasBoss);

                        if (scanner.hasNextInt()) {
                            int escolhaBoss = scanner.nextInt();

                            if (escolhaBoss == 4) {
                                break;
                            } else if (escolhaBoss == 1) {
                                criarBoss.main(new String[] {});
                            } else if (escolhaBoss == 2) {
                                apagarBoss.main(new String[] {});
                            } else if (escolhaBoss == 3) {
                                editarBoss.main(new String[] {});
                            } else {
                                System.out.println("Opção inválida. Tente novamente.");
                            }
                        } else {
                            scanner.next();
                            System.out.println("Opção inválida. Tente novamente.");
                        }
                    }
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } else {
                scanner.next();
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
