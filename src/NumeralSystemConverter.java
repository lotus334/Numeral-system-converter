import java.util.Locale;
import java.util.Scanner;

public class NumeralSystemConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale((Locale.US));
        int sourceRadix = 0;
        String sourceNumber = "";
        int targetRadix = 0;

        if (scanner.hasNextInt()) {
            sourceRadix = scanner.nextInt();
        }
        if (scanner.hasNext()) {
            sourceNumber = scanner.next();
        }
        if (scanner.hasNextInt()) {
            targetRadix = scanner.nextInt();
        }
        if (isInputValid(sourceRadix, sourceNumber, targetRadix)) {
            System.out.println(Converter(sourceRadix, sourceNumber, targetRadix));
        } else {
            System.out.println("error");
        }
    }

    static boolean isInputValid(int sourceRadix, String sourceNumber, int targetRadix) {
        boolean isValid = true;
        if (sourceRadix < 1 || sourceRadix > 36 || targetRadix < 1 || targetRadix > 36) {
            isValid = false;
        } else if (sourceNumber.isEmpty()) {
            isValid = false;
        }
        return isValid;
    }

    static String Converter(int sourceRadix, String sourceNumber, int targetRadix) {
        if (IsThereFractional(sourceNumber)) {
            String integerPart = sourceNumber.split("\\.")[0];
            String fractionalPart = sourceNumber.split("\\.")[1];
            String convertedIntegerPart = ConvertIntegerPart(sourceRadix, integerPart, targetRadix);
            String convertedFractionalPart = ConvertFractionalPart(sourceRadix, fractionalPart, targetRadix);
            return String.join(".", convertedIntegerPart, convertedFractionalPart);
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

    static String ConvertFractionalPart(int sourceRadix, String fractionalPart, int targetRadix) {
        double fractionalPartDecimal = 0;
        StringBuilder targetFractionPart = new StringBuilder();
        if (sourceRadix != 10) {
            int temp = sourceRadix;
            for (int i = 0; i < fractionalPart.length(); i++) {
                fractionalPartDecimal += (Double.parseDouble(String.valueOf(Long.parseLong(String.valueOf(fractionalPart.charAt(i)), sourceRadix))) / temp);
                temp *= sourceRadix;
            }
        } else {
            fractionalPartDecimal += Double.parseDouble("0." + fractionalPart);
        }
        for (int i = 0; i < 5; i++) {
            fractionalPartDecimal *= targetRadix;
            targetFractionPart.append(Long.toString((long) fractionalPartDecimal, targetRadix));
            fractionalPartDecimal -= (long) fractionalPartDecimal;
        }

        return String.valueOf(targetFractionPart);
    }
}