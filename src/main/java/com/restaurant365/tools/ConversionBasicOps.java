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
                    .filter(s -> maxNumber(s))
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

    public boolean maxNumber(String strNum) {
        int max=0;
        boolean ret=true;
        if (System.getProperty("MAX_VALUE") != null) {
            max = Integer.valueOf(System.getProperty("MAX_VALUE"));
            ret = Integer.valueOf(strNum) <= max;
        }
        return ret;
    }
}
