
public class Test {
    public static void main(String[] args)
    {
        Thread t1 = new Thread();
        Thread t2 = new Thread();
        Thread t3 = t1;
        int x1 = 10;
        double x2 = 10.0;

        String s1 = new String("GEEKS");
        String s2 = new String("GEEKS");

        System.out.println(t1 == t3);
        System.out.println(t1 == t2);
        System.out.println(s1 == s2);
        System.out.println(x1 == x2);

        System.out.println(t1.equals(t2));
        System.out.println(s1.equals(s2));
    }
}