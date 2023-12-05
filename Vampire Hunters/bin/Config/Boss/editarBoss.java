package bin.Config.Boss;

import java.io.*;
import java.util.Scanner;

public class editarBoss {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        File pastaMonstros = new File("bin/assets/Enemies/Boss");
        File[] arquivosMonstros = pastaMonstros.listFiles();

        if (arquivosMonstros == null || arquivosMonstros.length == 0) {
            System.out.println("Nenhum arquivo de monstro encontrado na pasta.");
            return;
        }

        System.out.println("Boss disponíveis para edição:");

        for (int i = 0; i < arquivosMonstros.length; i++) {
            File arquivo = arquivosMonstros[i];
            String nomeAtual = null;

            try {
                BufferedReader reader = new BufferedReader(new FileReader(arquivo));
                String line;

                while ((line = reader.readLine()) != null) {
                    if (line.contains(".nome =")) {
                        nomeAtual = line.trim().split("\"")[1];
                        break;
                    }
                }

                reader.close();
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            }

            System.out.println((i + 1) + " - " + nomeAtual);
        }

        System.out.print("Escolha o número do boss que deseja editar: ");
        int file = scanner.nextInt();

        if (file < 1 || file > arquivosMonstros.length) {
            System.out.println("Escolha inválida.");
            return;
        }

        String nomeArquivo = arquivosMonstros[file - 1].getName();
        nomeArquivo = nomeArquivo.substring(0, nomeArquivo.lastIndexOf('.'));

        String filePath = "bin/assets/Enemies/Boss/" + nomeArquivo + ".java";

        try {
            File arquivo = new File(filePath);

            if (!arquivo.exists()) {
                System.out.println("Arquivo não encontrado.");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(arquivo));
            StringBuilder fileContents = new StringBuilder();
            String line;
            String nomeAtual = null;

            while ((line = reader.readLine()) != null) {
                fileContents.append(line).append("\n");

                if (line.contains(".nome =")) {
                    nomeAtual = line.trim().split("\"")[1];
                }
            }
            System.out.print(nomeAtual);
            reader.close();

            boolean continuarEdicao = true;
            String skill1Atual = extractValue(fileContents, nomeArquivo + ".skill1 =");
            String skill2Atual = extractValue(fileContents, nomeArquivo + ".skill2 =");
            int manaAtual = extractIntValue(fileContents, nomeArquivo + ".mana =");
            int danoAtual = extractIntValue(fileContents, nomeArquivo + ".dano =");
            int resistenciaAtual = extractIntValue(fileContents, nomeArquivo + ".resistencia =");
            String skill3Atual = extractValue(fileContents, nomeArquivo + ".skill3 =");
            int vidaAtual = extractIntValue(fileContents, nomeArquivo + ".vida =");
            int novoMana = manaAtual;
            int novoDano = danoAtual;
            int novaResistencia = resistenciaAtual;
            String novoNome = nomeAtual;
            String novaSkill1 = skill1Atual;
            String novaSkill2 = skill2Atual;
            String novaSkill3 = skill3Atual;
            int novaVida = vidaAtual;
            System.out.print("\n");
            while (continuarEdicao) {
                System.out.println("\nEscolha o atributo que deseja mudar:");
                System.out.println("1 - Nome");
                System.out.println("2 - Skill1");
                System.out.println("3 - Skill2");
                System.out.println("4 - Skill3");
                System.out.println("5 - Mana");
                System.out.println("6 - Dano");
                System.out.println("7 - Resistência");
                System.out.println("8 - Vida");
                System.out.println("9 - Salvar\n");

                int escolha = scanner.nextInt();
                scanner.nextLine();

                if (escolha < 1 || escolha > 9) {
                    System.out.println("Escolha inválida.");
                    continue;
                }

                switch (escolha) {
                    case 1:
                        System.out.print("Nome atual = " + novoNome + "\nEscolha o novo nome: ");
                        novoNome = scanner.nextLine();
                        String nomeArquivoLine = nomeArquivo + ".nome =";
                        fileContents = replaceAttribute(fileContents, nomeArquivoLine,
                                nomeArquivoLine + " \"" + novoNome + "\";");
                        break;
                    case 2:
                        System.out.print("Habilidade 1 atual = " + novaSkill1 + "\nEscolha a nova habilidade 1: ");
                        novaSkill1 = scanner.nextLine();
                        String skill1Line = nomeArquivo + ".skill1 =";
                        fileContents = replaceAttribute(fileContents, skill1Line,
                                skill1Line + " \"" + novaSkill1 + "\";");
                        break;
                    case 3:
                        System.out.print("Habilidade 2 atual = " + novaSkill2 + "\nEscolha a nova habilidade 2: ");
                        novaSkill2 = scanner.nextLine();
                        String skill2Line = nomeArquivo + ".skill2 =";
                        fileContents = replaceAttribute(fileContents, skill2Line,
                                skill2Line + " \"" + novaSkill2 + "\";");
                        break;
                    case 4:
                        System.out.print("Habilidade 3 atual = " + novaSkill3 + "\nEscolha a nova habilidade 3: ");
                        novaSkill3 = scanner.nextLine();
                        String skill3Line = nomeArquivo + ".skill3 =";
                        fileContents = replaceAttribute(fileContents, skill3Line,
                                skill3Line + " \"" + novaSkill3 + "\";");
                        break;
                    case 5:

                        System.out.print("Mana atual = " + novoMana + "\nEscolha a nova quantidade de mana: ");
                        if (scanner.hasNextInt()) {
                            novoMana = scanner.nextInt();
                            scanner.nextLine();
                        } else {
                            System.out.println("\nValor inválido. Insira um valor numérico inteiro para Mana.");
                            scanner.nextLine();
                            continue;
                        }

                        String manaLine = nomeArquivo + ".mana =";
                        fileContents = replaceAttribute(fileContents, manaLine, manaLine + " " + novoMana + ";");
                        break;
                    case 6:

                        System.out.print("Dano atual = " + novoDano + "\nEscolha a nova quantidade de dano: ");
                        if (scanner.hasNextInt()) {
                            novoDano = scanner.nextInt();
                            scanner.nextLine();
                        } else {
                            System.out.println("\nValor inválido. Insira um valor numérico inteiro para Dano.");
                            scanner.nextLine();
                            continue;
                        }

                        String danoLine = nomeArquivo + ".dano =";
                        fileContents = replaceAttribute(fileContents, danoLine, danoLine + " " + novoDano + ";");
                        break;
                    case 7:

                        System.out.print("Resistência atual = " + novaResistencia
                                + "\nEscolha a nova quantidade de resistência: ");
                        if (scanner.hasNextInt()) {
                            novaResistencia = scanner.nextInt();
                            scanner.nextLine();
                        } else {
                            System.out.println("\nValor inválido. Insira um valor numérico inteiro para Resistência.");
                            scanner.nextLine();
                            continue;
                        }

                        String resistenciaLine = nomeArquivo + ".resistencia =";
                        fileContents = replaceAttribute(fileContents, resistenciaLine,
                                resistenciaLine + " " + novaResistencia + ";");
                        break;
                    case 8:

                        System.out.print("Vida atual = " + novaVida + "\nEscolha a nova quantidade de vida: ");
                        if (scanner.hasNextInt()) {
                            novaVida = scanner.nextInt();
                            scanner.nextLine();
                        } else {
                            System.out.println("\nValor inválido. Insira um valor numérico inteiro para vida.");
                            scanner.nextLine();
                            continue;
                        }

                        String vidaLine = nomeArquivo + ".vida =";
                        fileContents = replaceAttribute(fileContents, vidaLine, vidaLine + " " + novaVida + ";");
                        break;
                    case 9:
                        continuarEdicao = false;
                        break;
                }
            }
            if (!novoNome.equals(nomeAtual) ||
                    !novaSkill1.equals(skill1Atual) ||
                    !novaSkill2.equals(skill2Atual) ||
                    !novaSkill3.equals(skill3Atual) ||
                    novoMana != manaAtual ||
                    novoDano != danoAtual ||
                    novaResistencia != resistenciaAtual ||
                    novaVida != vidaAtual) {

                if (!novoNome.equals(nomeAtual)) {
                    System.out.println("Nome antigo: " + nomeAtual + " / Novo nome: " + novoNome);
                }

                if (!novaSkill1.equals(skill1Atual)) {
                    System.out.println("Habilidade 1 antiga: " + skill1Atual + " / Nova habilidade 1: " + novaSkill1);
                }

                if (!novaSkill2.equals(skill2Atual)) {
                    System.out.println("Habilidade 2 antiga: " + skill2Atual + " / Nova habilidade 2: " + novaSkill2);
                }

                if (!novaSkill3.equals(skill3Atual)) {
                    System.out.println("Habilidade 3 antiga: " + skill3Atual + " / Nova habilidade 3: " + novaSkill3);
                }

                if (novoMana != manaAtual) {
                    System.out.println("Mana antiga: " + manaAtual + " / Nova mana: " + novoMana);
                }

                if (novoDano != danoAtual) {
                    System.out.println("Dano antigo: " + danoAtual + " / Dano novo: " + novoDano);
                }

                if (novaResistencia != resistenciaAtual) {
                    System.out.println(
                            "Resistência antiga: " + resistenciaAtual + " / Nova resistência: " + novaResistencia);
                }

                if (novaVida != vidaAtual) {
                    System.out.println("Vida antiga: " + vidaAtual + " / Nova vida: " + novaVida);
                }

                System.out.print("\nDeseja confirmar a edição do monstro? (S/N): ");
                String confirmacao = scanner.next();

                if (confirmacao.equalsIgnoreCase("S")) {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo));
                    writer.write(fileContents.toString());
                    writer.close();
                    System.out.println("Edição confirmada. O monstro foi atualizado.\n");
                } else if (confirmacao.equalsIgnoreCase("N")) {
                    // Descarte as alterações
                    System.out.println("Edição descartada. O monstro não foi alterado.\n");
                } else {
                    System.out.println("Resposta inválida. As alterações não foram confirmadas.\n");
                }
            } else {
                System.out.print("Nenhuma alteração detectada.");
            }

        } catch (IOException e) {
            System.out.println("Erro ao editar o arquivo: " + e.getMessage());
        }
    }

    private static String extractValue(StringBuilder fileContents, String attribute) {
        String searchString = attribute + " \"";
        int index = fileContents.indexOf(searchString);
        if (index != -1) {
            int startIndex = index + searchString.length();
            int endIndex = fileContents.indexOf("\";", startIndex);
            if (endIndex != -1) {
                return fileContents.substring(startIndex, endIndex);
            }
        }
        return "";
    }

    private static int extractIntValue(StringBuilder fileContents, String attribute) {
        String searchString = attribute + " ";
        int index = fileContents.indexOf(searchString);
        if (index != -1) {
            int startIndex = index + searchString.length();
            int endIndex = fileContents.indexOf(";", startIndex);
            if (endIndex != -1) {
                String valueStr = fileContents.substring(startIndex, endIndex).trim();
                try {
                    return Integer.parseInt(valueStr);
                } catch (NumberFormatException e) {
                    System.out.print("");
                }
            }
        }
        return 0;
    }

    private static StringBuilder replaceAttribute(StringBuilder fileContents, String search, String replacement) {
        int index = fileContents.indexOf(search);
        if (index != -1) {
            int endIndex = fileContents.indexOf(";", index) + 1;
            fileContents.replace(index, endIndex, replacement);
        }
        return fileContents;
    }
}
