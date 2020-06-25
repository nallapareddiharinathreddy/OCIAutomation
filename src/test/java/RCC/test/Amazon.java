package RCC.test;

public  class Amazon {
    public static void foo(int x) {
        x=10;
    }
    public static void foo(String x) {
        x="test";
    }
    public static void main(String args[]) {
        int x=20;
        foo(x);
        System.out.println(x);

    }
}


