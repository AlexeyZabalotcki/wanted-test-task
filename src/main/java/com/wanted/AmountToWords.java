package com.report.generator.demo;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;

public class AmountToWords {
    private static final String[] tensNames = {
            "", " ten", " twenty", " thirty", " forty", " fifty",
            " sixty", " seventy", " eighty", " ninety"
    };

    private static final String[] numNames = {
            "", " one", " two", " three", " four", " five",
            " six", " seven", " eight", " nine", " ten",
            " eleven", " twelve", " thirteen", " fourteen", " fifteen",
            " sixteen", " seventeen", " eighteen", " nineteen"
    };

    private static String convertLessThanOneThousand(int number) {
        String current;

        if (number % 100 < 20) {
            current = numNames[number % 100];
            number /= 100;
        } else {
            current = numNames[number % 10];
            number /= 10;

            current = tensNames[number % 10] + current;
            number /= 10;
        }
        if (number == 0) return current;
        return numNames[number] + " hundred" + current;
    }

    public static String convert(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) == 0) {
            return "zero";
        }

        long number = amount.longValue();
        String tradThousand;
        String result = "";

        if (number >= 1000) {
            tradThousand = convertLessThanOneThousand((int) (number / 1000));
            result += tradThousand + " thousand";
            number %= 1000;
        }

        String tradHundred = convertLessThanOneThousand((int) number);
        result += tradHundred;

        String[] parts = new DecimalFormat("#.00").format(amount).split("\\.");
        String cents = convertLessThanOneThousand(Integer.parseInt(parts[1]));

        return result.trim() + " dollars and" + cents + " cents";
    }

    public static void main(String[] args) {
        System.out.println(convert(new BigDecimal("99999.99")));
    }
}
