package de_dust;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class PickBan {
    private static int readInt(Scanner scanner) {
        int dot = - 1;
        do {
            if (scanner.hasNextInt()) {
                dot = scanner.nextInt();
            } else {
                System.out.println("Число,будь ласка");
                scanner.nextLine();
            }
        } while (dot < 0);
        return dot;
    }

    public static Map<String, Integer> mapTheTeam(Scanner scanner) {
        Map<String, Integer> team_players = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            System.out.println("Введіть нік гравця:");
            String player = scanner.next();
            System.out.println("Введіть рахунок гравця:");
            int score = PickBan.readInt(scanner);
            team_players.put(player, score);
        }
        return team_players;
    }

    public static int mean(Map<String, Integer> map) {
        int sum = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            sum += e.getValue();
        }
        return sum / 5;
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Вітаємо на турнірі з Counter-Strike.Сьогодні ми визначемо,хто є найшвидшою рукою у комп'ютерному світі.");
        System.out.println("Введіть назву першої команди:");
        String team = scan.next();
        System.out.println("Команда " + team + " :");
        Map<String, Integer> team_players = mapTheTeam(scan);

        System.out.println("Введіть назву другої команди:");
        String team_one = scan.next();
        System.out.println("Команда " + team_one + " :");
        Map<String, Integer> team_one_players = mapTheTeam(scan);

        System.out.println("Триває визначення переможця.Зачекайте...");
        String anim = "|/-\\";
        for (int x = 0; x <= 100; x++) {
            String data = "\r" + anim.charAt(x % anim.length()) + " " + x;
            System.out.write(data.getBytes());
            Thread.sleep(100);
        }
        int team_result = mean(team_players);
        int team_one_result = mean(team_one_players);

        if (team_result > team_one_result) {
            System.out.println(" Перемогла команда " + team + " ,набравши у середньому " + team_result + " поінтів!");
        } else if (team_result == team_one_result) {
            System.out.println(" Перемогла дружба,бо команди набрали рівну кількість балів!");
        } else {
            System.out.println(" Перемогла команда " + team_one + " ,набравши у середньому " + team_one_result + " поінтів!");
        }


    }
}
