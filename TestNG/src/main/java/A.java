public class A extends B {
    public static void main(String[] a) {


    A ref = new A();
    ref.set("Sandeep");
    System.out.println(ref.get());
}
}
class B {
    private String a;

    public String get() {
        return a;
    }

    public void set(String a)
    {
        this.a=a;
    }
}
