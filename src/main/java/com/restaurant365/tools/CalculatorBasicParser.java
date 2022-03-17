package com.restaurant365.tools;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CalculatorBasicParser<T> implements ParserI<T> {
    private final String input;
    private List<String> output;

    public CalculatorBasicParser(String arg) {
        this.input = arg;
    }
    public T parsing()
    {
        final String inp = input.replace("\\n",",");
        output = Arrays.stream(inp.split(",")).collect(Collectors.toList());
        return (T) output;
    }

    public List<String> result() {
        return output;
    }
    public static void main(String[] args) {
        CalculatorBasicParser<List<String>> c = new CalculatorBasicParser<>("1\n2,3");
        c.parsing();
        System.out.println(c.result());
    }
}
