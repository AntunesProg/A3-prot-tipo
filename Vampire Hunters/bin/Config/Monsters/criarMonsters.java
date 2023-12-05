package bin.Config.Monsters;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class criarMonsters {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            int fileNumber = 1;
            String nomeArquivo = "monster" + fileNumber;

            // Verifica se o arquivo com o nome já existe
            while (arquivoExiste(nomeArquivo)) {
                fileNumber++;
                nomeArquivo = "monster" + fileNumber;
            }

            System.out.print("\nDigite o nome do monstro: ");
            String nomePersonagem = scanner.next();

            System.out.print("Digite a primeira habilidade: ");
            String skill1 = scanner.next();

            System.out.print("Digite a segunda habilidade: ");
            String skill2 = scanner.next();

            System.out.print("Digite a terceira habilidade: ");
            String skill3 = scanner.next();

            int mana = erroInt("Digite o valor de mana: ");
            int dano = erroInt("Digite o valor de dano: ");
            int resistencia = erroInt("Digite o valor de resistência: ");
            int vida = 100;
            System.out.println("\nEstatísticas do personagem:");
            System.out.println("Nome do monstro: " + nomePersonagem);
            System.out.println("Habilidade 1: " + skill1);
            System.out.println("Habilidade 2: " + skill2);
            System.out.println("Habilidade 3: " + skill3);
            System.out.println("Mana: " + mana);
            System.out.println("Dano: " + dano);
            System.out.println("Resistência: " + resistencia);
            System.out.println("Vida: " + vida);

            String confirmacao = "";
            while (true) {
                System.out.print("\nTem certeza de que deseja criar esse monstro? (S/N): ");
                confirmacao = scanner.next();

                if (confirmacao.equalsIgnoreCase("S")) {
                    String nomeDoArquivo = "bin\\assets\\\\Enemies\\Monsters\\" + nomeArquivo + ".java";
                    FileWriter fileWriter = new FileWriter(nomeDoArquivo);
                    BufferedWriter writer = new BufferedWriter(fileWriter);

                    writer.write("package bin.assets.Enemies.Monsters;\n");
                    writer.write("import bin.Config.Class.Boss;\n");
                    writer.write("\n");
                    writer.write("public class " + nomeArquivo +  " extends Boss {\n");
                    writer.write("        public " + nomeArquivo + "() { \n");
                    writer.write("            " +   "nome = \"" + nomePersonagem + "\";\n");
                    writer.write("            " +   "skill1 = \"" + skill1 + "\";\n");
                    writer.write("            " +   "skill2 = \"" + skill2 + "\";\n");
                    writer.write("            " +   "skill3 = \"" + skill3 + "\";\n");
                    writer.write("            " +   "mana = " + mana + ";\n");
                    writer.write("            " +   "dano = " + dano + ";\n");
                    writer.write("            " +   "resistencia = " + resistencia + ";\n");
                    writer.write("            " +   "vida = " + vida + ";\n");
                    writer.write("    }\n");
                    writer.write("}\n");
                    writer.close();
                    System.out.println("\n" + nomePersonagem + " criado com sucesso.");
                    break;
                } else if (confirmacao.equalsIgnoreCase("N")) {
                    System.out.println("Criação do personagem cancelada.");
                    break;
                } else {
                    System.out.println("Entrada inválida. Digite 'S' para criar ou 'N' para cancelar.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int erroInt(String prompt) {
        int valor = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print(prompt);
                valor = scanner.nextInt();
                entradaValida = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Por favor, digite um valor inteiro válido.");
                scanner.next();
            }
        }

        return valor;
    }

    // Função para verificar se o arquivo com o nome já existe
    private static boolean arquivoExiste(String nomeArquivo) {
        File file = new File("bin\\assets\\\\Enemies\\Monsters\\" + nomeArquivo + ".java");
        return file.exists();
    }
}
