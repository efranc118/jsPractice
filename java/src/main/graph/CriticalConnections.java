package main.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CriticalConnections {

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> criticalConnections = new ArrayList<>();

        HashMap<Integer, List<Integer>> connectionMap = new HashMap<>();

        for(int i = 0; i < connections.size(); i++) {
            Integer key1 = connections.get(i).get(0);
            Integer key2 = connections.get(i).get(1);
            if(!connectionMap.containsKey(key1)) connectionMap.put(key1, new ArrayList<>());
            if(!connectionMap.containsKey(key2)) connectionMap.put(key1, new ArrayList<>());
            List<Integer> valueList1 = connectionMap.get(key1);
            valueList1.add(key2);
            List<Integer> valueList2 = connectionMap.get(key2);
            valueList2.add(key1);
            connectionMap.put(key1, valueList1 );
            connectionMap.put(key2, valueList2);
        }

        for(Integer key: connectionMap.keySet()) {
            if(connectionMap.get(key).size() == 1) {
                ArrayList<Integer> connection = new ArrayList<>();
                connection.add(key, connectionMap.get(key).get(0));
                criticalConnections.add(connection);
                connectionMap.remove(connectionMap.get(key));
                connectionMap.remove(key);
            }
        }
        return criticalConnections;
    }


    public static void main(String[] args) {
        CriticalConnections solution = new CriticalConnections();
        //System.out.println(solution.criticalConnections());
    }

}
