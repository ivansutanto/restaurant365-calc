package com.restaurant365.tools;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *  Just for fun, it is not in the REQ;Not Used  but it can be done to accept decimal number
 */
public class ConversionDecimalOps  implements ConversionOpsI {
    private static final Logger log = Logger.getLogger(ConversionBasicOps.class.getName());
    private final List<String> numbers;

    public ConversionDecimalOps(List<String> arg) {
        this.numbers = arg;
    }

    public  final List<Double> convert() {
        return numbers.stream()
                .filter(s -> StringUtils.isNotEmpty(s))
                .filter(Objects::nonNull)
                .filter(s -> isNumeric(s))
                .filter(s -> Double.valueOf(s) <= 1000.00)
                .map(Double::valueOf)
                .collect(Collectors.toList());
    }

    public boolean isNumeric(String strNum) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}
