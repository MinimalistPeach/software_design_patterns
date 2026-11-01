package src.helpers;

import java.util.Scanner;

public class InputHelper {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(SCANNER.nextLine().trim());
            } catch (NumberFormatException ex) {
                System.out.println("Egész számot adj meg!");
            }
        }
    }

    public static double readWeight() {
        while (true) {
            System.out.print("Tömeg kilogrammban (0-30 kg): ");
            try {
                double value = Double.parseDouble(SCANNER.nextLine().trim().replace(',', '.'));
                if (Double.isFinite(value) && value > 0 && value <= 30) {
                    return value;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Csak pozitív egész vagy tört szám adható meg!");
            }
            System.out.println("0-nál nagyobb, legfeljebb 30 kg-os tömeget adj meg!");
        }
    }
}
