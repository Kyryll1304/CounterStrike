package de_dust;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class PickBan {
    private static int readInt(Scanner scanner) {
        int x;
        while (true) {
            if (scanner.hasNextInt()) {
                x = scanner.nextInt();
                if (x < 0) {
                    System.out.println("Only positive");
                    scanner.nextLine();
                } else {
                    return x;
                }
            } else {
                System.out.println("Only positive number");
                scanner.nextLine();
            }
        }
    }

    public static Map<String, Integer> mapTheTeam(Scanner scanner) {
        Map<String, Integer> teamPlayers = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            System.out.println("Введіть нік гравця:");
            String player = scanner.next();
            System.out.println("Введіть рахунок гравця:");
            int score = PickBan.readInt(scanner);
            teamPlayers.put(player, score);
        }
        return teamPlayers;
    }

    public static float mean(Map<String, Integer> map) {
        int sum = 0;
        float div = map.size();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            sum += e.getValue();
        }
        return sum / div;
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Вітаємо на турнірі з Counter-Strike.Сьогодні ми визначемо,хто є найшвидшою рукою у комп'ютерному світі.");
        System.out.println("Введіть назву першої команди:");
        String team = scan.next();
        System.out.println("Команда " + team + " :");
        Map<String, Integer> teamPlayers = mapTheTeam(scan);

        System.out.println("Введіть назву другої команди:");
        String teamOne = scan.next();
        System.out.println("Команда " + teamOne + " :");
        Map<String, Integer> teamOnePlayers = mapTheTeam(scan);

        System.out.println("Триває визначення переможця.Зачекайте...");
        String anim = "|/-\\";
        for (int x = 0; x <= 100; x++) {
            String data = "\r" + anim.charAt(x % anim.length()) + " " + x;
            System.out.print(data);
            Thread.sleep(100);
        }
        float teamResult = mean(teamPlayers);
        float teamOneResult = mean(teamOnePlayers);

        if (teamResult > teamOneResult) {
            System.out.println(" Перемогла команда " + team + " ,набравши у середньому " + teamResult + " поінтів!");
        } else if (teamResult == teamOneResult) {
            System.out.println(" Перемогла дружба,бо команди набрали рівну кількість балів!");
        } else {
            System.out.println(" Перемогла команда " + teamOne + " ,набравши у середньому " + teamOneResult + " поінтів!");
        }


    }
}
