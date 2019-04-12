package jvm;

/**
 * 模块描述: <br>
 * (通过GC调用object的finalize方法，重生对象，因为finalize方法不是同步调用的，所以需要使用线程睡眠来测试)
 *
 * @Author: Mr. xyb
 * @Date: 2019/3/31 16:23
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class Finalization {

    public static Finalization finalization;

    @Override
    protected void finalize() {
        System.out.println("Finalized");
        finalization = this;
    }

    public static void main(String[] args) {
        Finalization finalization = new Finalization();
        System.out.println("Finalized First :" + finalization);
        finalization = null;
        System.gc();
        try {
            Thread.sleep(1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Second print :" + finalization);
        System.out.println(Finalization.finalization);
    }
}
