import java.util.Arrays;
import java.util.Scanner;

public class NumeralSystemConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sourceRadix = scanner.nextInt();
        long sourceNum = scanner.nextLong();
        int targetRadix = scanner.nextInt();
        if (sourceRadix != 1 && targetRadix != 1) {
            long numDecimal = Long.parseLong(String.valueOf(sourceNum), sourceRadix);
            String numTarget = Long.toString(numDecimal, targetRadix);
            System.out.println(numTarget);
        } else if (sourceRadix == 1) {
            long numDecimal = String.valueOf(sourceNum).length();
            String numTarget = Long.toString(numDecimal, targetRadix);
            System.out.println(numTarget);
        } else if (targetRadix == 1) {
            long numDecimal = Long.parseLong(String.valueOf(sourceNum), sourceRadix);
            for (int i = (int) numDecimal; i > 0; i--) {
                System.out.print(1);
            }
        }
    }
}