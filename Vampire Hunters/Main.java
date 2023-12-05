// import java.util.Scanner;

// import bin.Class.Boss.Boss;

// import java.util.Random;

// public class Main {
// public static void main(String[] args) {
// Scanner entrada = new Scanner(System.in);
// Random random = new Random();
// int numeroAleatorio = random.nextInt(11) + 15; // Gera um número entre 15 e
// 25.
// Boss vilao1 = new Boss();
// vilao1.nome = "Ichigo Yagami";
// vilao1.habilidade = "Professor faltei hoje";
// vilao1.mana = 50;

// Boss vilao2 = new Boss();
// vilao2.nome = "Gladistone";
// vilao2.habilidade = "Pedra Grata";
// vilao2.mana = 50;

// System.out.println(vilao1.toString());
// System.out.println(vilao2.toString());

// boolean vidaConfigurada1 = vilao1.configurarVida(75);
// boolean vidaConfigurada2 = vilao2.configurarVida(75);

// if (vidaConfigurada1 && vidaConfigurada2) {
// System.out.println("Vida do inimigo " + vilao1.nome + ": " + vilao1.vida);
// System.out.println("Vida do inimigo " + vilao2.nome + ": " + vilao2.vida);
// }

// while (vilao1.vida > 0 && vilao2.vida > 0) {
// System.out.println("\nTurno do Vilão " + vilao1.nome);
// int ataque1 = gerarDanoAleatorio(numeroAleatorio);
// System.out.print("Aperte enter");
// String a = entrada.nextLine();

// if (ataque1 == 0) {
// break; // O usuário escolheu sair do loop
// }

// int novaVida2 = vilao2.vida - ataque1;
// vidaConfigurada2 = vilao2.configurarVida(novaVida2);

// if (vidaConfigurada2) {
// System.out.println("\n\nO ataque '" + vilao1.habilidade + "' de " +
// vilao1.nome + " tirou " + ataque1
// + " de vida de " + vilao2.nome + ". A nova vida de " + vilao2.nome + " é " +
// vilao2.vida);
// }

// System.out.println("\nTurno do Vilão " + vilao2.nome);
// int ataque2 = gerarDanoAleatorio(numeroAleatorio);
// System.out.print("Aperte enter");
// String b = entrada.nextLine();

// if (ataque2 == 0) {
// break; // O usuário escolheu sair do loop
// }

// int novaVida1 = vilao1.vida - ataque2;
// vidaConfigurada1 = vilao1.configurarVida(novaVida1);

// if (vidaConfigurada1) {
// System.out.println("\n\nO ataque '" + vilao2.habilidade + "' de " +
// vilao2.nome + " tirou " + ataque2
// + " de vida de " + vilao1.nome + ". A nova vida de " + vilao1.nome + " é " +
// vilao1.vida);
// }
// }

// if (vilao1.vida < 1) {
// System.out.println("O vilão " + vilao1.nome + " foi derrotado!");
// }
// if (vilao2.vida < 1) {
// System.out.println("O vilão " + vilao2.nome + " foi derrotado!");
// }
// }

// // Função para gerar um dano aleatório entre 0 e o valor máximo especificado.
// public static int gerarDanoAleatorio(int maxDano) {
// Random random = new Random();
// return random.nextInt(maxDano + 1);
// }
// }
