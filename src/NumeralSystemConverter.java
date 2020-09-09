import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class NumeralSystemConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale((Locale.US));
        int sourceRadix = scanner.nextInt();
        String sourceNumber = scanner.next();
        int targetRadix = scanner.nextInt();
        System.out.println(Converter(sourceRadix, sourceNumber, targetRadix));
    }

    static String Converter(int sourceRadix, String sourceNumber, int targetRadix) {
        if (IsThereFractional(sourceNumber)) {
            String integerPart = sourceNumber.split("\\.")[0];
            String fractionalPart = sourceNumber.split("\\.")[1];
            String decimalInteger = ConvertIntegerPart(sourceRadix, integerPart, targetRadix);
            String decimalFractional = ConvertFractionalPart(fractionalPart);
            return String.join(".", decimalInteger, decimalFractional);
        }
        return ConvertIntegerPart(sourceRadix, sourceNumber, targetRadix);
    }

    static boolean IsThereFractional(String sourceNumber) {
        for (int i = 0; i < sourceNumber.length(); i++) {
            if (sourceNumber.charAt(i) == '.') {
                return true;
            }
        }
        return false;
    }

    static String ConvertIntegerPart(int sourceRadix, String integerPart, int targetRadix) {
        long integerPartDecimal = 0;
        StringBuilder targetNumber = new StringBuilder();
        if (sourceRadix == 1 && targetRadix == 1) {
            targetNumber.append(integerPart);
        } else if (sourceRadix == 1) {
            integerPartDecimal += integerPart.length();
            targetNumber.append(Long.toString(integerPartDecimal, targetRadix));
        } else if (targetRadix == 1) {
            integerPartDecimal += Long.parseLong(integerPart, sourceRadix);
            for (long i = integerPartDecimal; i > 0; i--) {
                targetNumber.append("1");
            }
        } else {
            integerPartDecimal += Long.parseLong(integerPart, sourceRadix);
            targetNumber.append(Long.toString(integerPartDecimal, targetRadix));
        }
        return targetNumber.toString();
    }

    static String ConvertFractionalPart(String fractionalPart) {
        return fractionalPart;
    }
}