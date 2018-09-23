package hackerearth.deshaw;

public class Test {
    public synchronized void foo(int i, String msg){
    }

    public void bar(int i, String msg){
        synchronized(this){
        }
    }

    public static void main(String[] args) {

    }
}