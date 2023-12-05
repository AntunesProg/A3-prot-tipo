package bin.Config.Boss;

import java.io.*;
import java.util.Scanner;

public class apagarBoss {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        File pasta = new File("bin\\assets\\Enemies\\Boss");

        if (pasta.exists() && pasta.isDirectory()) {
            File[] arquivos = pasta.listFiles();

            if (arquivos != null && arquivos.length > 0) {
                exibirListaBosses(arquivos);

                int numero = -1; 
                while (numero < 0 || numero > arquivos.length) {
                    System.out.print("Informe o número do boss que deseja apagar: ");
                    if (scanner.hasNextInt()) {
                        numero = scanner.nextInt();
                        if (numero < 0 || numero > arquivos.length) {
                            System.out.println("Número de arquivo inválido. Digite um número válido.");
                            exibirListaBosses(arquivos);
                        }
                    } else {
                        System.out.println("Entrada inválida. Digite um número válido.");
                        scanner.next();
                        exibirListaBosses(arquivos);
                    }
                }

                if (numero == 0) {
                    return;
                } else {
                    File arquivoParaApagar = arquivos[numero - 1];
                    String nomeMonstro = extractNomeFromFile(arquivoParaApagar);
                    boolean confirmacaoValida = false;

                    while (!confirmacaoValida) {
                        System.out.print("Tem certeza que deseja excluir '" + nomeMonstro
                                + "'? (S para confirmar, N para cancelar): ");
                        String confirmacao = scanner.next();

                        if (confirmacao.equalsIgnoreCase("S")) {
                            if (arquivoParaApagar.delete()) {
                                System.out.println(nomeMonstro + " foi apagado com sucesso.");
                            } else {
                                System.out.println("Não foi possível apagar o arquivo.");
                            }
                            confirmacaoValida = true;
                        } else if (confirmacao.equalsIgnoreCase("N")) {
                            System.out.println("Ação cancelada. O monstro não foi apagado.");
                            confirmacaoValida = true;
                        } else {
                            System.out.println("Entrada inválida. Digite 'S' para confirmar ou 'N' para cancelar.");
                        }
                    }
                }
            } else {
                System.out.println("A pasta está vazia.");
            }
        } else {
            System.out.println("A pasta especificada não existe ou não é um diretório válido.");
        }

        scanner.close();
    }

    private static String extractNomeFromFile(File arquivo) {
        String nomeMonstro = "Nome não encontrado";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(arquivo));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(".nome =")) {
                    int startIndex = line.indexOf("\"");
                    int endIndex = line.lastIndexOf("\"");
                    if (startIndex != -1 && endIndex != -1) {
                        nomeMonstro = line.substring(startIndex + 1, endIndex);
                    }
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nomeMonstro;
    }

    private static void exibirListaBosses(File[] arquivos) {
        System.out.println("\nBoss criados:");
        System.out.println("0 - Voltar");
        for (int i = 0; i < arquivos.length; i++) {
            String nomeMonstro = extractNomeFromFile(arquivos[i]);
            System.out.println((i + 1) + " - " + nomeMonstro);
        }
    }
}
