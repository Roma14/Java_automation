
public class Test {
    public static void main(String[] args)
    {
//        Thread t1 = new Thread();
//        Thread t2 = new Thread();
//        Thread t3 = t1;
//        int x1 = 10;
//        double x2 = 10.0;
//
//        String s1 = new String("GEEKS");
//        String s2 = new String("GEEKS");
//
//        System.out.println(t1 == t3);
//        System.out.println(t1 == t2);
//        System.out.println(s1 == s2);
//        System.out.println(x1 == x2);
//
//        System.out.println(t1.equals(t2));
//        System.out.println(s1.equals(s2));


//        int i, j;
//        for(i=0; i<10; i++){
//            for(j=i; j<10; j++){
//                System.out.print (".");
//            }
//            System.out.println();
//        }
//        for(int i=0; i<10; i++) {
//            System.out.print (i + " ");
//            if (i%2 == 0) continue;
//            System.out.println("");
//        }
//        countRunTime(2 , 3);
//        findMin(1, 5, 9, 2);
        int test = 5;
        test <<=1;
        System.out.println(test);

    }

    public static void findMin(int a, int b, int c, int d){
        int min1,min2;
        int min = ( min1 = a < b ? a : b)<(min2 = c < d ? c : d) ? min1:min2;
        System.out.println("Min value is " + min);
    }

    public static void countRunTime(int a, int b){
        long before = System.currentTimeMillis();
        int sum = a + b;
                for(int i=0; i<sum; i++) {
            System.out.print (i + " ");
            if (i%2 == 0) continue;
            System.out.println("");
        }
        System.out.println("");
        long after = System.currentTimeMillis();
        System.out.printf("The result of the function a + b  = %d. Time of performing = %d ms", sum, (after - before));
    }
}