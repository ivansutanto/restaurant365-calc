package com.restaurant365.tools;

import java.util.List;

public class ValidationMaxSetOfNumber implements ValidationI{
    private final List<Integer> nmbrs;

    public ValidationMaxSetOfNumber(List<Integer> arg) {
        nmbrs = arg;
    }
    @Override
    public void validate() {
        if (nmbrs.size() > 2) {
            throw new RuntimeException("Maximum Accepted Set of Number is 2");
        }
    }
}
