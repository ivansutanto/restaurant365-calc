import com.restaurant365.tools.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ConversionDecimalTest {
    private final Logger log = Logger.getLogger(getClass().getName());

    @Test
    public void conversionDecimalTest() {
        List<String> t = new ArrayList<String>();
        t.add("1");
        t.add("3.2");
        t.add("2.2");
        List<Double> nmbr = new ConversionDecimalOps(t).convert();
        System.out.println(nmbr);
    }

}
