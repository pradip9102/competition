package hackerearth.quest;

import java.util.*;
import java.util.stream.Collectors;

class Task {
    Integer startTime;
    Integer endTime;
    boolean completed = false;

    public Task(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(startTime, task.startTime) &&
                Objects.equals(endTime, task.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, endTime);
    }
}

public class HecticGame {

    private static List<Task> filterTasks(final List<Task> tasks, Integer start, Integer end) {
        Task first = tasks.stream().filter(it -> it.endTime < end).findFirst().orElse(null);
        if (first == null) {
            return Collections.emptyList();
        }

        List<Task> selectedTasks = new ArrayList<>();
        selectedTasks.add(first);
        List<Task> nexts = filterTasks(tasks, first.endTime+1, end);
        if (nexts.isEmpty()) {
            return selectedTasks;
        }

        selectedTasks.addAll(nexts);
        return selectedTasks;
    }

    private static List<Task> completeNonOverlappingTasks(final List<Task> tasks) {
        if (tasks.isEmpty()) {
            return Collections.emptyList();
        }

        List<Task> selectedTasks = filterTasks(tasks, tasks.get(0).startTime, tasks.get(tasks.size()-1).endTime);
        return tasks.stream().filter(it -> !selectedTasks.contains(it)).collect(Collectors.toList());
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        for (int t = scanner.nextInt(); t > 0; t--) {
            int taskCount = scanner.nextInt();
            List<Task> tasks = new ArrayList<>(taskCount);
            for (int i = 0; i < taskCount; i++) {
                tasks.add(new Task(scanner.nextInt(), scanner.nextInt()));
            }

            // sorted by end times
            tasks = tasks.stream().sorted((t1, t2) -> t1.endTime.compareTo(t2.endTime)).collect(Collectors.toList());

            int alice = 0;
            int bob = 0;
            while (!tasks.isEmpty()) {
                int beforeAlice = tasks.size();
                tasks = completeNonOverlappingTasks(tasks);
                alice ^= beforeAlice - tasks.size();

                int beforeBob = tasks.size();
                tasks = completeNonOverlappingTasks(tasks);
                bob ^= beforeBob - tasks.size();
            }

            if (alice > bob) {
                System.out.println("Alice");
            } else if (bob > alice) {
                System.out.println("Bob");
            } else {
                System.out.println("Tie");
            }
        }
    }
}
