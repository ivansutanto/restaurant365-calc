import com.restaurant365.tools.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class CalculatorMainBK {
    private final static Logger log = Logger.getLogger(CalculatorMainBK.class.getName());
    private static Thread mainThread;
    private static final StringBuilder inps = new StringBuilder();
    private static final Scanner in = new Scanner(System.in);
    private static String inp;

    public static void main(String[] args) throws IOException {
        mainThread = Thread.currentThread();
        Runtime.getRuntime().addShutdownHook(new Thread(() ->  {
                process();
                System.out.println("I am done for today!");
        }));
        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Please enter the number(s):");
        while (in.hasNextLine()) {
            inp = in.nextLine();
            //System.out.println(inp);
            //System.out.println(inp.length());
            if (inp.matches("\\r?\\n|\\r"))
                inps.append(inp+",");
            else if (!inp.matches(","))
                inps.append(inp+",");
            else
                inps.append(inp);
        }

        CalculatorMainBK.mainThread.interrupt();

    }

    public static void process() {
        log.info(inps.toString());
        String inputEntry = inps.toString();
        final ParserI p;
        if (inputEntry.startsWith("//")) {
            p = new CalculatorPatternParser(inputEntry);
        } else if (inputEntry.startsWith("//[")) {
            p = new CalculatorPatternMultipleParser(inputEntry);
        } else {
            //p = new CalculatorBasicParser<>(inputEntry);
            p = new CalculatorPatternParser(inputEntry);
        }

        List<String> t = (List<String>) p.parsing();
        System.out.println(t.toString());
        AddOps add = new AddOps(t);
        long res = add.add();
        System.out.println(String.valueOf(res));
    }
}
