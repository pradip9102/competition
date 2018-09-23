package hackerearth.congnizant;

import java.util.Scanner;

class MyException extends Exception {
    MyException(int param) {
        super("MyException[" + param + "]");
    }
}

public class ExceptionHandling {
    private static void solve(int arr[]) throws Exception {
        int ans = 0;

        for (int i = 0; i < 10; i++)
            for (int j = i + 1; j < 10; j++)
                ans += arr[i] / arr[j];

        throw new MyException(ans);
    }

    public static void main(String args[]) {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int[] arr = new int[n];
            in.nextLine();

            for (int i = 0; i < 10; i++)
                arr[i] = Integer.parseInt(in.nextLine());

            String s = in.nextLine();
            System.out.println(s.charAt(10));

            solve(arr);
        } catch (ArithmeticException ae) {
            System.out.println("Format mismatch");
        } catch (StringIndexOutOfBoundsException siobe) {
            System.out.println("Index is invalid");
        } catch (ArrayIndexOutOfBoundsException aiobe) {
            System.out.println("Array index is invalid");
        } catch (MyException me) {
            System.out.println(me.getMessage());
        } catch (Exception e) {
            System.out.println("Exception encountered");
        } finally {
            System.out.println("Exception Handling Completed");
        }
    }
}