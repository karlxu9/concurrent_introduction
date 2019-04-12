package concurrent.c_026;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * 模块描述: <br>
 * ()
 *
 * @Author: Mr. xyb
 * @Date: 2019/4/13 1:48
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class T12_ForkJoinPool {

    static long[] nums = new long[1000000];
    static final int MAX_NUM = 50000;
    static Random r = new Random();
    static long total = 0;

    static {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(10000);
        }
        System.out.println(Arrays.stream(nums).sum());
    }

    /*static class AddTask extends RecursiveAction {

        int start, end;

        public AddTask(int s, int e) {
            this.start = s;
            this.end = e;
        }

        @Override
        protected void compute() {
            if (end - start <= MAX_NUM) {
                long sum = 0L;

                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
                System.out.println("from:" + start + " to:" + end + " = " + sum);
                System.out.println("total" + (sum += sum));
            } else {
                int middle = start + (end - start) / 2;
                AddTask addTask1 = new AddTask(start, middle);
                AddTask addTask2 = new AddTask(middle, end);
                addTask1.fork();
                addTask2.fork();
            }
        }
    }*/

    static class AddTask extends RecursiveTask<Long> {

        int start, end;

        AddTask(int s, int e) {
            this.start = s;
            this.end = e;
        }

        @Override
        protected Long compute() {
            if (end - start <= MAX_NUM) {
                long sum = 0L;

                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
                // System.out.println("from:" + start + " to:" + end + " = " + sum);
                return sum;
            }

            int middle = start + (end - start) / 2;
            AddTask addTask1 = new AddTask(start, middle);
            AddTask addTask2 = new AddTask(middle, end);
            addTask1.fork();
            addTask2.fork();
            return addTask1.join() + addTask2.join();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        AddTask addTask = new AddTask(0, nums.length);
        forkJoinPool.execute(addTask);

        Long result = addTask.join();
        System.out.println(result);

        // System.in.read();

    }
}
