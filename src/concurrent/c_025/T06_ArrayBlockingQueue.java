package concurrent.c_025;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class T06_ArrayBlockingQueue {

	static BlockingQueue<String> strs = new ArrayBlockingQueue<>(11);

	static Random r = new Random();

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			strs.put("a" + i);
		}

		// strs.put("aaa"); // 满了就会等待，程序阻塞
		// strs.add("aaa");// 满了再装会报错
		// strs.offer("aaa");// 有返回值，是否加成功
		strs.offer("aaa", 1, TimeUnit.SECONDS);

		System.out.println(strs);
	}
}