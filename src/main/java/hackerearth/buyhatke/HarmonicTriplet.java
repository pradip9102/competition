package hackerearth.buyhatke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HarmonicTriplet {
    private List<Integer> contents;
    private List<Long> harmonicPeaks;
    private List<Integer> leftPeakValues;
    private List<Integer> rightPeakValues;

    private HarmonicTriplet() {
        contents = new ArrayList<>();
        harmonicPeaks = new ArrayList<>();
    }

    private Integer findRestrictedMax(List<Integer> contents, Integer peakValue) {
        return contents.stream()
                .filter(value -> value <= peakValue)
                .max(Integer::compareTo)
                .orElse(0);
    }

    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);

        // test case count
        Integer testCaseCount = s.nextInt();

        // main loop
        for (int t = 0; t < testCaseCount; t++) {
            HarmonicTriplet problem = new HarmonicTriplet();

            // array size
            Integer arraySize = s.nextInt();

            // query count
            Integer queryCount = s.nextInt();

            // contents of array
            for (int i = 0; i < arraySize; i++) {
                problem.contents.add(s.nextInt());
                problem.harmonicPeaks.add(null);
                problem.leftPeakValues.add(null);
                problem.rightPeakValues.add(null);
            }

            for (int i = 0; i < queryCount; i++) {
                Integer peakIndex = s.nextInt() - 1;
                if (problem.harmonicPeaks.get(peakIndex) != null) {
                    System.out.println(problem.harmonicPeaks.get(peakIndex));
                } else if (peakIndex > 0 && peakIndex < arraySize) {
                    Integer peakValue = problem.contents.get(peakIndex);
                    Integer leftValue = 0;
                    Integer rightValue = 0;

                    if (peakIndex <= (arraySize - peakIndex - 1)) {
                        leftValue = problem.findRestrictedMax(problem.contents.subList(0, peakIndex), peakValue);
                        problem.leftPeakValues.add(peakIndex, leftValue);
                        if (leftValue > 0) {
                            rightValue = problem.findRestrictedMax(problem.contents.subList(peakIndex + 1, arraySize), peakValue);
                            problem.rightPeakValues.add(peakIndex, rightValue);
                        }
                    } else {
                        rightValue = problem.findRestrictedMax(problem.contents.subList(peakIndex + 1, arraySize), peakValue);
                        problem.rightPeakValues.add(peakIndex, rightValue);
                        if (rightValue > 0) {
                            leftValue = problem.findRestrictedMax(problem.contents.subList(0, peakIndex), peakValue);
                            problem.leftPeakValues.add(peakIndex, leftValue);
                        }
                    }
                    Long result = Long.valueOf(leftValue) * Long.valueOf(peakValue) * Long.valueOf(rightValue);
                    System.out.println(result);
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}
