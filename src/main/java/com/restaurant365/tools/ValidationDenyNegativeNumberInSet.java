package com.restaurant365.tools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class ValidationDenyNegativeNumberInSet implements ValidationI{
    private static final Logger log = LogManager.getLogger();
    private final List<Integer> nmbrs;

    public ValidationDenyNegativeNumberInSet(List<Integer> arg) {
        nmbrs = arg;
    }
    @Override
    public void validate() {
       log.debug("Validate This:"+nmbrs);
        List <Integer> negativeNmbr = nmbrs.stream().filter(s -> (s < 0))
                                                    .collect(Collectors.toList());
        log.debug("Negative Numbers Found:"+negativeNmbr);
        if (negativeNmbr.size() > 0) {
            throw new RuntimeException("Negative Numbers Found:"+ negativeNmbr);
        }
    }
}
