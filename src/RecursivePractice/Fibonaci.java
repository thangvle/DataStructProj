package RecursivePractice;

public class Fibonaci {
    public static int fibo(int i) {
        if (i == 1 || i == 2){
            return 1;
        }
        else {
            return fibo(i-1) + fibo(i-2);
    }
}

    public static void main(String[] args) {
        System.out.println(fibo(3));
    }
}
