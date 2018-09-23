package techgig;

import java.util.Stack;

public class genericstack<E> {
    Stack<E> stk = new Stack<>();

    public void push(E obj) {
        stk.push(obj);
    }

    public E pop() {
        E obj = stk.pop();
        return obj;
    }
}

class Output {
    public static void main(String args[]) {
        genericstack<Integer> gs = new genericstack<>();
        gs.push(36);
        System.out.println(gs.pop());
    }
}
