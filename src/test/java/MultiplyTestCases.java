import com.restaurant365.tools.AddOps;
import com.restaurant365.tools.MultiplyOps;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MultiplyTestCases {
    private final Logger log = Logger.getLogger(getClass().getName());
    @Test
    public void basicAddTest() {
        List<String> t = new ArrayList<String>();
        t.add("1");
        t.add("3");
        t.add("2");
        t.add("4");
        MultiplyOps add = new MultiplyOps(t);
        Long res = (Long) add.operation();
        log.info(String.valueOf(res));
        assert (res == 24);
    }


}
