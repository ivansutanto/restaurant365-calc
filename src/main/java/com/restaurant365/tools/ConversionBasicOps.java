package com.restaurant365.tools;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ConversionBasicOps implements ConversionOpsI {
    private static final Logger log = Logger.getLogger(ConversionBasicOps.class.getName());
    private final List<String> numbers;

    public ConversionBasicOps(List<String> arg) {
        this.numbers = arg;
    }

    public  final List<Integer> convert() {
            return numbers.stream()
                    .filter(s -> StringUtils.isNotEmpty(s))
                    .filter(Objects::nonNull)
                    .filter(s -> isNumeric(s))
                    .filter(s -> Integer.valueOf(s) <= 1000)
                    .map(Integer::valueOf)
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
