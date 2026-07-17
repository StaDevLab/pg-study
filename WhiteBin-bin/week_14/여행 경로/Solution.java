import java.util.*;

class Solution {

    private String[][] tickets;
    private boolean[] used;
    private List<String> route;

    public String[] solution(String[][] tickets) {
        
        Arrays.sort(tickets, (ticket1, ticket2) -> {
            return ticket1[1].compareTo(ticket2[1]);
        });

        this.tickets = tickets;
        this.used = new boolean[tickets.length];
        this.route = new ArrayList<>();

        route.add("ICN");

        dfs("ICN", 0);

        return route.toArray(new String[0]);
    }

    private boolean dfs(String currentAirport, int usedTicketCount) {

        if (usedTicketCount == tickets.length) {
            return true;
        }

        for (int i = 0; i < tickets.length; i++) {

            if (used[i]) {
                continue;
            }


            if (!tickets[i][0].equals(currentAirport)) {
                continue;
            }

            used[i] = true;
            route.add(tickets[i][1]);

            boolean found = dfs(tickets[i][1], usedTicketCount + 1);

            if (found) {
                return true;
            }

            used[i] = false;
            route.remove(route.size() - 1);
        }

        return false;
    }
}