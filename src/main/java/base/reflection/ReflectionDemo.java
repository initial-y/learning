package base.reflection;

/**
 * @ClassName ReflectionDemo
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/2/19
 */
public class ReflectionDemo {

    private String param = "reflection";

    public int num = 0;

    protected double result = 0.0d;

    public void printParam() {
        System.out.println(param);
    }

    protected void printNum(int num) {
        //打印堆栈信息
        new Exception("#" + num).printStackTrace();
        System.out.println("invoke target method");
    }

    public ReflectionDemo() {

    }

    public ReflectionDemo(String pram) {
        pram = this.param;
    }

    private ReflectionDemo(Integer pram) {
        System.out.println("private constructor， num = " + pram);
    }
}
