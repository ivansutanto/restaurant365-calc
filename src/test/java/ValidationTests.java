import com.restaurant365.tools.ConversionBasicOps;
import com.restaurant365.tools.ValidationDenyNegativeNumberInSet;
import com.restaurant365.tools.ValidationI;
import com.restaurant365.tools.ValidationMaxSetOfNumber;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ValidationTests {
    private final Logger log = Logger.getLogger(getClass().getName());
    @Test(expected = RuntimeException.class)
    public void validationMaxSetOfNumberTest() {
        List<String> t = new ArrayList<String>();
        t.add("1");
        t.add("3");
        t.add("2");
        List<Integer> nmbr = new ConversionBasicOps(t).convert();
        ValidationI validationI = new ValidationMaxSetOfNumber(nmbr);
        validationI.validate();
    }
    @Test(expected = RuntimeException.class)
    public void validationNegNumberInSetTest() {
        List<String> t = new ArrayList<String>();
        t.add("1");
        t.add("-3");
        t.add("2");
        List<Integer> nmbr = new ConversionBasicOps(t).convert();
        ValidationI validationI = new ValidationDenyNegativeNumberInSet(nmbr);
        validationI.validate();
    }

}
