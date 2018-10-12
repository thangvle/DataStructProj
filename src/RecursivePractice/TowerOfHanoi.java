package RecursivePractice;

import java.util.Stack;

public class TowerOfHanoi {


    public static void towerOfHanoi(int n, Stack<Integer> source, Stack<Integer> target, Stack<Integer> aux)
    {

        if (n > 0) {
            towerOfHanoi(n-1, source, aux, target);

            System.out.print(source.toString());
            System.out.print("########\n");
            System.out.print(aux.toString());
            System.out.print("########\n");
            System.out.print(target.toString());
            target.push(source.pop());
            towerOfHanoi(n-1, aux, target, source);

        }
    }

    public static void main(String[] args) {

        Stack source = new Stack();
        Stack target = new Stack();
        Stack aux = new Stack();

        source.push(3);
        source.push(2);
        source.push(1);

        towerOfHanoi(3, source, target, aux);
    }

}
