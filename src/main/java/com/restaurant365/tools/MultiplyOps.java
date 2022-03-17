package com.restaurant365.tools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class MultiplyOps<T> implements OpsI<T> {
    private static final Logger log = LogManager.getLogger();

    private final List<String> numbers;
    private final ValidationI validationI;

    public MultiplyOps(List<String> arg, ValidationI arg2) {
        this.numbers = arg;
        this.validationI = arg2;
    }
    public MultiplyOps(List<String> arg) {
       this(arg, null);
    }

    public T operation() {
        List<Integer> listLong = new ConversionBasicOps(numbers).convert();
        log.debug("Number of Elements:"+listLong.size());
        ValidationI validationI;
        if ("N".equals(System.getProperty("ACCEPT_NEG_NUMBER"))) {
            validationI = new ValidationDenyNegativeNumberInSet(listLong);
            validationI.validate();
        }
        if ("Y".equals(System.getProperty("MAX_NUMBER_2"))) {
            validationI = new ValidationMaxSetOfNumber(listLong);
            validationI.validate();
        }
        Long res = Long.valueOf(listLong.stream().mapToInt(Integer::intValue).reduce(1, (a,b) -> a * b));

        return (T) res;
        //return listLong.stream().mapToInt(Integer::intValue).reduce(0, (subtotal, val) -> subtotal + val);
    }

}
