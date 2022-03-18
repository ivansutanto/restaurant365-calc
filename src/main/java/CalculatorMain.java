import com.restaurant365.tools.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

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
    }

}
