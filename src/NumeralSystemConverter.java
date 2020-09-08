import java.util.Arrays;
import java.util.Scanner;

public class NumeralSystemConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int maxpowersOfTwo = 1;
        int lenghtOfList = 1;
        int base = scanner.nextInt();
        while (maxpowersOfTwo < num) {
            maxpowersOfTwo *= base;
            lenghtOfList++;
        }
        int[] powersOfTwo = new int[lenghtOfList];
        int[] ans = new int[lenghtOfList];
        for (int i = 0; i < lenghtOfList; i++) {
            powersOfTwo[i] = maxpowersOfTwo;
            maxpowersOfTwo /= base;
        }

        for (int i = 0; i < lenghtOfList; i++) {
            if (num / powersOfTwo[i] >= 1) {
                ans[i] = num / powersOfTwo[i];
                num %= powersOfTwo[i];
            } else {
                ans[i] = 0;
            }
        }
        boolean startWithZero = true;
        if (base == 16) {
            System.out.print("0x");
            for (int i = 0; i < lenghtOfList; i++) {
                if (ans[i] == 0 && startWithZero) {
                    continue;
                }
                if (ans[i] == 10) {
                    System.out.print("a");
                } else if (ans[i] == 11) {
                    System.out.print("b");
                } else if (ans[i] == 12) {
                    System.out.print("c");
                } else if (ans[i] == 13) {
                    System.out.print("d");
                } else if (ans[i] == 14) {
                    System.out.print("e");
                } else if (ans[i] == 15) {
                    System.out.print("f");
                } else {
                    System.out.print(ans[i]);
                }
                startWithZero = false;
            }
        } else {
            if (base == 8) {
                System.out.print("0");
            } else if (base == 2) {
                System.out.print("0b");
            }
            for (int i = 0; i < lenghtOfList; i++) {
                if (ans[i] == 0 && startWithZero) {
                    continue;
                }
                System.out.print(ans[i]);
                startWithZero = false;
            }
        }
        if (startWithZero) {
            System.out.print("0");
        }
    }
}