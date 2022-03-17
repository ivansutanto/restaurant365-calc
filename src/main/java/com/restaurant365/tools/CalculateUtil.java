package com.restaurant365.tools;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public final class CalculateUtil {
    private final static Logger log = LogManager.getLogger();


    public static void calculate(final String input) {
        final ParserI p;
        if (input.startsWith("//[")) {
            log.debug("CalculatorPatternMultipleParser");
            p = new CalculatorPatternMultipleParser(input);
        } else if (input.startsWith("//")) {
            log.debug("CalculatorPatternParser");
            p = new CalculatorPatternParser(input);
        } else {
            log.debug("CalculatorBasicParser");
            p = new CalculatorBasicParser(input);
        }
        List<String> t = (List<String>) p.parsing();
        log.debug("Parsed String:"+t.toString());
        AddOps add = new AddOps(t);
        long res = add.add();
        log.debug("Answer:"+res);
        System.out.println("Answer:"+res);
    }

}
