import java.util.Arrays;
import java.util.Scanner;

public class NumeralSystemConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        int radix = scanner.nextInt();
        switch (radix) {
            case 2:
                System.out.print("0b");
                break;
            case 8:
                System.out.print("0");
                break;
            case 16:
                System.out.print("0x");
                break;
            default:
                break;
        }
        System.out.print(Long.toString(num, radix));
    }
}