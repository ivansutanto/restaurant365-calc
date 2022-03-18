import com.restaurant365.tools.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CalculatorMain {
    private final static Logger log = LogManager.getLogger();

    public static void main(String[] args) throws IOException {
        // Enter data using BufferReader
        System.out.println("Please enter the number(s):");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in,"UTF-8"));
        calculate(reader.readLine());
    }

    public static void calculate(final String inp) {
        try {
            CalculateUtil.calculate(inp);
        } catch (Exception e) {
            System.out.println("Oops Something may not be correct with your inputs "+inp);
            log.debug("Something is not right ..."+inp+", Exc:"+e.getMessage());
        }

    }

}
