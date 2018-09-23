package hackerearth.servicenow;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PopUpOrientation {

    private static final String TOP_LEFT = "top-left";
    private static final String TOP_RIGHT = "top-right";
    private static final String BOTTOM_LEFT = "bottom-left";
    private static final String BOTTOM_RIGHT = "bottom-right";

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line;
        for (int t = Integer.parseInt(reader.readLine()); t > 0; t--) {
            // read input
            line = reader.readLine().split(" ");
            int pageWidth = Integer.parseInt(line[0]);
            int pageHeight = Integer.parseInt(line[1]);
            int popupWidth = Integer.parseInt(line[2]);
            int popupHeight = Integer.parseInt(line[3]);
            int dLeft = Integer.parseInt(line[4]);
            int dBottom = Integer.parseInt(line[5]);

            // evaluate options
            boolean canRenderRight = (pageWidth - popupWidth) >= dLeft;
            boolean canRenderBottom = popupHeight <= dBottom;

            // print output
            if (canRenderBottom) {
                if (canRenderRight) {
                    System.out.println(BOTTOM_RIGHT);
                } else {
                    System.out.println(BOTTOM_LEFT);
                }
            } else {
                if (canRenderRight) {
                    System.out.println(TOP_RIGHT);
                } else {
                    System.out.println(TOP_LEFT);
                }
            }
        }
    }
}
