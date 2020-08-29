package prototypes;

import org.junit.Test;

import java.util.ArrayList;

public class TestServerAllocation {
    ArrayList<Integer> currentServers = new ArrayList<Integer>();
    @Test
    public void getServerNumberEmptyList() {
        assert ServerAllocation.getServerNumber(currentServers) == 1;
    }

    @Test
    public void getServerNumberMissingInnerValue() {
        currentServers.add(1);
        currentServers.add(3);
        assert ServerAllocation.getServerNumber(currentServers) == 2;
    }

    @Test
    public void getServerNumberNoMissingValues() {
        currentServers.add(1);
        currentServers.add(2);
        currentServers.add(3);
        assert ServerAllocation.getServerNumber(currentServers) == 4;
    }
}
