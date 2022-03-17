package com.restaurant365.tools;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class CalculatorPatternMultipleParser<T> implements ParserI<T> {
    private static final Logger log = LogManager.getLogger();
    private final String input;
    private List<String> output;

    public CalculatorPatternMultipleParser(String arg) {
        this.input = arg;
    }

    public T parsing()
    {

        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        Matcher matcher = pattern.matcher(input);

        StringBuilder delimiters = new StringBuilder();

        while( matcher.find() ) {
            delimiters.append(matcher.group(1));
        }
        log.debug("Delimiters:"+delimiters);

        String numbers = StringUtils.split(input,"\\n")[1];
        log.debug("Numbers:"+numbers);

        String[] arrayNumbers = numbers.split("["+delimiters+"]");
        log.debug("Arrays of Numbers:"+Arrays.toString(arrayNumbers));

        output = Arrays.stream(arrayNumbers).collect(Collectors.toList());
        return (T) output;
    }

    public List<String> result() {
        return output;
    }
    public static void main(String[] args) {
        CalculatorPatternMultipleParser<List<String>> c = new CalculatorPatternMultipleParser<>("1\n2,3");
        c.parsing();
        System.out.println(c.result());
    }
}
