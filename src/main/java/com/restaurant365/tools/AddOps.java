package com.restaurant365.tools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class AddOps<T> implements OpsI<T> {
    private static final Logger log = LogManager.getLogger();

    private final List<String> numbers;
    private ValidationI validationI;

    public AddOps(List<String> arg, ValidationI arg2) {
        this.numbers = arg;
        this.validationI = arg2;
    }
    public AddOps(List<String> arg) {
       this(arg, null);
    }

    public T operation() {
        List<Integer> listLong = new ConversionBasicOps(numbers).convert();
        log.debug("Number of Elements:"+listLong.size());
        if (validationI == null) {
            if ("N".equals(System.getProperty("ACCEPT_NEG_NUMBER"))) {
                (new ValidationDenyNegativeNumberInSet(listLong)).validate();
            }
            if ("Y".equals(System.getProperty("MAX_NUMBER_2"))) {
                (new ValidationMaxSetOfNumber(listLong)).validate();
            }
        } else {
            validationI.validate();
        }
        Long res = Long.valueOf(listLong.stream().mapToInt(Integer::intValue).sum());

        return (T) res;
        //return listLong.stream().mapToInt(Integer::intValue).reduce(0, (subtotal, val) -> subtotal + val);
    }

}
