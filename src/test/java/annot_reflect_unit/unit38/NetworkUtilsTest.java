package annot_reflect_unit.unit38;

import org.junit.Test;

public class NetworkUtilsTest {
    @Test(timeout = 1000)
    public void getConnectionShouldReturnFasterOneSecond() throws InterruptedException {
        NetworkUtils.getConnection();
    }
}
