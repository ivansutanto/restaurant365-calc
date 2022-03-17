package com.restaurant365.tools;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class CalculatorPatternParser<T> implements ParserI<T> {
    private static final Logger log = LogManager.getLogger();
    private final String input;
    private List<String> output;

    public CalculatorPatternParser(String arg) {
        this.input = arg;
    }
    public T parsing()
    {
        System.out.println("Input:"+input);
        Pattern pattern = Pattern.compile("//(.?)",Pattern.MULTILINE | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(input);

        StringBuilder delimiters = new StringBuilder();

        while( matcher.find() ) {
            delimiters.append(matcher.group(1));
        }
        log.debug("Delimiters:"+delimiters);

        String numbers = StringUtils.split(input,"\\n")[1];
        log.debug("Numbers:"+numbers);

        String[] arrayNumbers = numbers.toString().split("["+delimiters+"]");
        log.debug("Arrays of Numbers:"+Arrays.toString(arrayNumbers));

        output = Arrays.stream(arrayNumbers).map(String::trim).collect(Collectors.toList());
        return (T) output;
    }

    public List<String> result() {
        return output;
    }

    public static void main(String[] args) {
        String str = "//[105][200][processed]";

        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        Matcher matcher = pattern.matcher(str);

        while( matcher.find() ) {
            System.out.println( matcher.group(1) );
        }
    }
}
