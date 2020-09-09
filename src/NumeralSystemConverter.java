import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class NumeralSystemConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale((Locale.US));
        int sourceRadix = scanner.nextInt();
        String sourceNum = scanner.next();
        sourceNum += ".";
        String[] str = sourceNum.split("\\.");
        int targetRadix = scanner.nextInt();
        boolean b1 = str[1].equals("");
        if (sourceRadix != 1 && targetRadix != 1) {
            if (b1) {
                Long numDecimal = Long.parseLong(sourceNum, sourceRadix);
                String numTarget = Long.toString(numDecimal, targetRadix);
                System.out.println(numTarget);
            }
            else {
                StringBuilder intPart = new StringBuilder();
                StringBuilder fracPart = new StringBuilder();

                Long numDecimal = Long.parseLong(str[0], sourceRadix);
                String numTarget = Long.toString(numDecimal, targetRadix);
                intPart.append(numTarget);

                double numFrac = 0;
                if (sourceRadix != 10) {
                    int permBase = sourceRadix;
                    for (int i = 0; i < str[1].length(); i++) {
                        numFrac += Double.parseDouble(String.valueOf(Long.parseLong(String.valueOf(str[1].charAt(i)), sourceRadix))) / permBase;
                        permBase *= sourceRadix;
                    }
                } else {
                    numFrac += Double.parseDouble(str[1]) / (Math.pow(10, String.valueOf(Integer.parseInt(str[1])).length()));
                }

                for (int i = 0; i < 5; i++) {
                    numFrac *= targetRadix;
                    String permTarget = Long.toString((long) numFrac, targetRadix);
                    fracPart.append(permTarget);
                    numFrac -= (long) numFrac;
                }

                System.out.println(intPart + "." + fracPart);
            }
        } else if (sourceRadix == 1) {
            if (b1) {
                long numDecimal = (sourceNum).length();
                String numTarget = Long.toString(numDecimal, targetRadix);
                System.out.println(numTarget);
            }
        } else if (targetRadix == 1) {
            if (b1) {
                long numDecimal = Long.parseLong((sourceNum), sourceRadix);
                for (int i = (int) numDecimal; i > 0; i--) {
                    System.out.print(1);
                }
            }
        }
    }
}