package main.graph;

import java.util.*;

public class OrganizeTickets {

    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, List<String>> graph = new TreeMap<>();
        int totalStops = 1;
        for(List<String> ticket : tickets) {
            totalStops++;
            List<String> destinations = graph.getOrDefault(ticket.get(0), new ArrayList<String>());
            destinations.add(ticket.get(1));
            graph.put(ticket.get(0), destinations);
        }

        String departure = "JFK";
        List<String> trip = new ArrayList<String>();
        trip.add(departure);
        return checkItinerary(trip, departure, graph, totalStops);

    }


    public List<String> checkItinerary(List<String> trip, String current, Map<String, List<String>> tickets, int totalStops) {
        if(trip.size() == totalStops) {
            return trip;
        }

        List<String> potentialDestinations = tickets.get(current);
        if(potentialDestinations == null || potentialDestinations.size() == 0) return null;
        Collections.sort(potentialDestinations);

        for(int i = 0; i < potentialDestinations.size(); i++) {
            String destination = potentialDestinations.get(i);
            tickets.get(current).remove(i);
            trip.add(destination);
            List<String> result = checkItinerary(trip, destination, tickets, totalStops);
            if(result != null) return result;
            tickets.get(current).add(0, destination);
            trip.remove(trip.size() - 1);
        }
        return null;
    }


    public static void main(String[] args) {
        OrganizeTickets solution = new OrganizeTickets();
        List<String> ticket1 = Arrays.asList("JFK", "KUL");
        List<String> ticket2 = Arrays.asList("JFK", "NRT");
        List<String> ticket3 = Arrays.asList("NRT", "JFK");

        //[["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
        List<List<String>> tickets = Arrays.asList(ticket1, ticket2, ticket3);
        System.out.println(solution.findItinerary(tickets));
    }

}
