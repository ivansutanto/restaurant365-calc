import com.restaurant365.tools.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculatorMain {
    private final static Logger log = Logger.getLogger(CalculatorMain.class.getName());

    public static void main(String[] args) throws IOException {
        // Enter data using BufferReader
        System.out.println("Please enter the number(s):");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in,"UTF-8"));
        calculate(reader.readLine());
    }

    public static void calculate(final String inp) {
        CalculateUtil.calculate(inp);
//        final ParserI p;
//        if (inp.startsWith("//[")) {
//            System.out.println("CalculatorPatternMultipleParser");
//            p = new CalculatorPatternMultipleParser(inp);
//        } else if (inp.startsWith("//")) {
//            System.out.println("CalculatorPatternParser");
//            p = new CalculatorPatternParser(inp);
//        } else {
//            System.out.println("CalculatorBasicParser");
//            p = new CalculatorBasicParser(inp);
//        }
//        List<String> t = (List<String>) p.parsing();
        //System.out.println(t.toString());
//        AddOps add = new AddOps(t);
//        long res = add.add();
//        log.info("Answer:"+String.valueOf(res));
    }

}
