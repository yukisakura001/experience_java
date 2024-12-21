import java1_mult.CalcLogic;

public class Calc {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int total = CalcLogic.tasu(a, b);
        int delta = CalcLogic.hiku(a, b);
        System.out.println("tasu=" + total + " hiku=" + delta);

    }
}
