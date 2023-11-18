package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] demonNames = scanner.nextLine() //"M3ph1st0**, Azazel"
                .replaceAll(" ", "") //"M3ph1st0**,Azazel" -> махаме интервалите
                .split(",");//"M3ph1st0**,Azazel".split(",") -> ["M3ph1st0**", "Azazel"]

        for (String demonName : demonNames) {
            int health = getDemonsHealth(demonName);
            double damage = getDemonsDamage(demonName);

            //променяме damage спрямо * и \
            for (char symbol : demonName.toCharArray()){
                if (symbol == '*') {
                    damage *= 2;
                } else if (symbol == '/') {
                    damage /= 2;
                }
            }

            //отпечатване за всеки демон
            System.out.printf("%s - %d health, %.2f damage%n", demonName, health, damage);

        }
    }

    //изчислява и връща damage
    private static double getDemonsDamage(String demonName) {
        double damage = 0;
        //всички дробни и цели числа, които са положителни и отрицателни
        Pattern pattern = Pattern.compile("[-]?\\d+\\.?\\d*");
        Matcher matcher = pattern.matcher(demonName);
        //demonName = "M3ph-0.5s-0.5t0.0**"
        //matcher = ["3", "-0.5", "-0.5", "0.0"]
        while (matcher.find()) {
            damage += Double.parseDouble(matcher.group());
        }

        return damage;
    }

    //изчислява и връща health
    private static int getDemonsHealth(String demonName) {
        int health = 0;
        //всички текстове различни от 0-9, +, -, /, *
        Pattern pattern = Pattern.compile("[^\\+\\-\\*\\/0-9\\.]");
        Matcher matcher = pattern.matcher(demonName);
        //demonName = "M3ph-0.5s-0.5t0.0**"
        //matcher - съвкупността от текстове, които отговарят на шаблона
        //matcher = ["M", "p", "h", "s", "t"]
        while (matcher.find()) {
            health += (int) matcher.group().charAt(0);
        }

        return health;
    }
}
