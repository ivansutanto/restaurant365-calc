import com.restaurant365.tools.AddOps;
import com.restaurant365.tools.CalculatorBasicParser;
import org.junit.Test;

import java.util.List;
import java.util.logging.Logger;

public class AddWithConversionBasicTestCases {
    private final Logger log = Logger.getLogger(getClass().getName());
    @Test
    public void basicAddTest() {
        String n = "1,2,3,4";
        CalculatorBasicParser<List<String>> p = new CalculatorBasicParser<>(n);
        List<String> t = p.parsing();
        AddOps add = new AddOps(t);
        long res = add.add();
        log.info(String.valueOf(res));
        assert (res == 10);
    }

    @Test
    public void basicAddWithNonNumberElementTest() {
        String n = "1,aa,3,4";
        CalculatorBasicParser<List<String>> p = new CalculatorBasicParser<>(n);
        List<String> t = p.parsing();
        AddOps add = new AddOps(t);
        long res = add.add();
        log.info(String.valueOf(res));
        assert (res == 8);
    }

    @Test
    public void basicAddWithSlashNElementTest() {
        String n = "1\n3,4";
        CalculatorBasicParser<List<String>> p = new CalculatorBasicParser<>(n);
        List<String> t = p.parsing();
        AddOps add = new AddOps(t);
        long res = add.add();
        log.info(String.valueOf(res));
        assert (res == 8);
    }

    @Test
    public void basicAddEmptyTest() {
        String n = "aa,aa";
        CalculatorBasicParser<List<String>> p = new CalculatorBasicParser<>(n);
        List<String> t = p.parsing();
        AddOps add = new AddOps(t);
        long res = add.add();
        log.info(String.valueOf(res));
        assert (res == 0);
    }


}
