import java.util.Arrays;
import java.util.Scanner;

public class NumeralSystemConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int maxpowersOfTwo = 1;
        int lenghtOfList = 1;
        int base = 8;
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

        System.out.println(ans[lenghtOfList - 1]);
    }
}