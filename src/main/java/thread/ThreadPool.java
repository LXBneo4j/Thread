package thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *  Executor框架是指java 5中引入的一系列并发库中与executor相关的一些功能类，其中包括线程池，
 *              Executor，Executors，ExecutorService，CompletionService，Future，Callable等。
 *  他们的关系为：并发编程的一种编程方式是把任务拆分为一些列的小任务，即Runnable，然后在提交给一个Executor执行，
 *             Executor.execute(Runnalbe) 。Executor在执行时使用内部的线程池完成操作
 *
 *  Executors类，提供了一系列工厂方法用于创建线程池，返回的线程池都实现了ExecutorService接口。
	 public static ExecutorService newFixedThreadPool(int nThreads)
	 创建固定数目线程的线程池。
	 public static ExecutorService newCachedThreadPool()
	 创建一个可缓存的线程池，调用execute 将重用以前构造的线程（如果线程可用）。如果现有线程没有可用的，则创建一个新线程并添加到池中。终止并从缓存中移除那些已有 60 秒钟未被使用的线程。
	 public static ExecutorService newSingleThreadExecutor()
	 创建一个单线程化的Executor。
	 public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize)
	 创建一个支持定时及周期性的任务执行的线程池，多数情况下可用来替代Timer类。
 
 二、ExecutorService与生命周期
	 ExecutorService扩展了Executor并添加了一些生命周期管理的方法。一个Executor的生命周期有三种状态，运行 ，关闭 ，终止 。
	 Executor创建时处于运行状态。当调用ExecutorService.shutdown()后，处于关闭状态，isShutdown()方法返回true。这时，
	 不应该再想Executor中添加任务，所有已添加的任务执行完毕后，Executor处于终止状态，isTerminated()返回true。
	 如果Executor处于关闭状态，往Executor提交任务会抛出unchecked exception RejectedExecutionException。
 
	 ExecutorService executorService = (ExecutorService) executor;
	 while (!executorService.isShutdown()) {
	 try {
	      executorService.execute(task);
	 } catch (RejectedExecutionException ignored) {
	 }
	 }
	 executorService.shutdown();
 三、使用Callable，Future返回结果[ExecutorService、Callable、Future这些对象实际上都是属于Executor框架中的功能类]
    Future<V>代表一个异步执行的操作，通过get()方法可以获得操作的结果，如果异步操作还没有完成，则，get()会使当前线程阻塞。
    FutureTask<V>实现了Future<V>和Runable<V>。
    Callable代表一个有返回值得操作。
 
 
 
 * @author lxb
 * @date 2018/3/7
 * @time 13:38
 */
public class ThreadPool {
	public static void main (String[] args) {
		/** 一：Executor创建线程池  **/
//		Executor executor = Executors.newFixedThreadPool(10);
//		Runnable task = new Runnable() {
//			public void run() {
//				System.out.println("task over");
//			}
//		};
//		executor.execute(task);
//		executor = Executors.newScheduledThreadPool(10);
//		ScheduledExecutorService scheduler = (ScheduledExecutorService) executor;
//		scheduler.scheduleAtFixedRate(task, 10, 10, TimeUnit.SECONDS);
		
		/** 三： Callable**/
//		Callable<Integer> func = new Callable<Integer>(){
//			public Integer call() throws Exception {
//				System.out.println("inside callable");
//				Thread.sleep(1000);
//				return new Integer(8);
//			}
//		};
//		FutureTask<Integer> futureTask  = new FutureTask<Integer>(func);
//		Thread newThread = new Thread(futureTask);
//		newThread.start();
//
//		try {
//			System.out.println("blocking here");
//			Integer result = futureTask.get();
//			System.out.println ("main thread over");
//			System.out.println(result);
//		} catch (InterruptedException ignored) {
//		} catch (ExecutionException ignored) {
//		}
		
		/** 四：  **/
		int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 10, 11 };
		ConcurrentCalculator calc = new ConcurrentCalculator();
		Long sum = calc.sum(numbers);
		System.out.println(sum);
		calc.close();
		
		
	}
}
