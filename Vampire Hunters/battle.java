
import bin.assets.Enemies.Boss.*;
import bin.Config.Class.Boss;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class battle {
    public static void main(String[] args) {
        File bossFolder = new File("bin/assets/Enemies/Boss/");
        File[] bossFiles = bossFolder.listFiles();

        if (bossFiles != null) {
            List<Boss> bosses = new ArrayList<>();

            for (File bossFile : bossFiles) {
                if (bossFile.isFile() && bossFile.getName().endsWith(".java")) {
                    String bossClassName = bossFile.getName().replace(".java", "");
                    try {
                        String bossClassFullName = "bin.assets.Enemies.Boss." + bossClassName;

                        Class<?> bossClass = Class.forName(bossClassFullName);

                        // Criar uma instância da classe Boss
                        Boss bossInstance = (Boss) bossClass.getDeclaredConstructor().newInstance();

                        // Adicionar a instância à lista
                        bosses.add(bossInstance);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            for (Boss boss : bosses) {
                System.out.println("Nome do Boss: " + boss.nome);
                System.out.println("Vida do Boss: " + boss.vida);
                System.out.println("------------------");
            }

            System.out.println("Bosses Spawnares Aleatórios:");
            Random random = new Random();
            int numberOfBossesToSpawn = Math.min(5, bosses.size()); 
            for (int i = 0; i < numberOfBossesToSpawn; i++) {
                Boss randomBoss = bosses.get(random.nextInt(bosses.size()));
                System.out.println("Nome do Boss: " + randomBoss.nome);
                System.out.println("Vida do Boss: " + randomBoss.vida);
                System.out.println("------------------");
            }
        }
    }
}
