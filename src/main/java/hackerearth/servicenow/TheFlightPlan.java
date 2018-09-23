package hackerearth.servicenow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TheFlightPlan {

    private int cityCount, routeCount, transitionPeriod, travelPeriod;
    private List<List<Integer>> routes;
    private int source, destination;

    private TheFlightPlan(int cityCount, int routeCount, int transitionPeriod, int travelPeriod) {
        this.cityCount = cityCount;
        this.routeCount = routeCount;
        this.transitionPeriod = transitionPeriod;
        this.travelPeriod = travelPeriod;

        routes = new ArrayList<>(this.routeCount);
        for (int r = 0; r < routeCount; r++) {
            routes.add(new ArrayList<>());
        }
    }

    private void addRoute(int a, int b) {
        if (a < b) {
            routes.get(a).add(b);
        } else {
            routes.get(b).add(a);
        }
    }

    private void addEndPoints(int a, int b) {
        if (a < b) {
            source = a;
            destination = b;
        } else {
            source = b;
            destination = a;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split(" ");
        TheFlightPlan problem = new TheFlightPlan(Integer.parseInt(line[0]),
                Integer.parseInt(line[1]),
                Integer.parseInt(line[2]),
                Integer.parseInt(line[3]));

        for (int i = 0; i < problem.routeCount; i++) {
            line = reader.readLine().split(" ");
            problem.addRoute(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }

        line = reader.readLine().split(" ");
        problem.addEndPoints(Integer.parseInt(line[0]), Integer.parseInt(line[1]));

        int minTimeToMove = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<>();
        stack.push(problem.source);

        int timeToMove = 0;
        // TODO: USE DFS
        while (!stack.isEmpty()) {
            int start = stack.pop();
            if (start == problem.destination) {
                minTimeToMove = timeToMove < minTimeToMove ? timeToMove : minTimeToMove;
                timeToMove = 0;
            }

            List<Integer> paths = problem.routes.get(start);
            if (!paths.isEmpty()) {
                stack.addAll(paths);
                timeToMove += problem.travelPeriod;
                int temp = timeToMove % problem.transitionPeriod;
                timeToMove += (temp != 0) ? (problem.transitionPeriod - temp) : 0;
            } else {
            }
        }
    }
}
