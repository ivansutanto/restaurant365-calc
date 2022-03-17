import com.restaurant365.tools.AddOps;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AddTestCases {
    private final Logger log = Logger.getLogger(getClass().getName());
    @Test
    public void basicAddTest() {
        List<String> t = new ArrayList<String>();
        t.add("1");
        t.add("3");
        t.add("2");
        t.add("4");
        AddOps add = new AddOps(t);
        long res = add.add();
        log.info(String.valueOf(res));
        assert (res == 10);
    }

    @Test
    public void basicAddWithNonNumberElementTest() {
        List<String> t = new ArrayList<String>();
        t.add("1");
        t.add("aa");
        t.add("2");
        t.add("4");
        AddOps add = new AddOps(t);
        long res = add.add();
        log.info(String.valueOf(res));
        assert (res == 7);
    }

    @Test
    public void noNumberTest() {
        List<String> t = new ArrayList<String>();
        t.add("");
        AddOps add = new AddOps(t);
        long res = add.add();
        log.info(String.valueOf(res));

    }
}
