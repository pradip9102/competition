package hackerearth.buyhatke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArchitectsDilemma {

    private Integer workerCount;
    private Integer extraWorkAmount;
    private List<Integer> fixedWork;

    private ArchitectsDilemma() {
        workerCount = 0;
        extraWorkAmount = 0;
        fixedWork = new ArrayList<>();
    }

    private Integer distributeWork(List<Integer> workList, Integer workAmount) {
        Integer result = 0;
        Integer distributedAmount = 0;

        for (int i = 1; i < workList.size(); i++) {
            int atd = (workList.get(i) - workList.get(i - 1)) * i;
            if (distributedAmount + atd <= workAmount) {
                distributedAmount += atd;
                ++result;
            } else {
                break;
            }
        }

//        System.out.println("Distributed amount: " + distributedAmount);
//        System.out.println("Result: " + (result + 1));
        return result + 1;
    }

    public static void main(String args[]) throws Exception {
        ArchitectsDilemma problem = new ArchitectsDilemma();

        Scanner s = new Scanner(System.in);
        problem.workerCount = s.nextInt();
        problem.extraWorkAmount = s.nextInt();
        for (int i = 0; i < problem.workerCount; i++) {
            problem.fixedWork.add(s.nextInt());
        }

        problem.fixedWork.sort(Integer::compareTo);

        Integer max = 0;
        for (int i = 0; i < problem.workerCount; i++) {
            Integer temp = problem.distributeWork(problem.fixedWork.subList(i, problem.workerCount), problem.extraWorkAmount);
            if (temp > max) {
                max = temp;
            }
        }

        System.out.println(max);
    }
}
