/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package thread;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2018/3/6
 * @time 16:29
 */
public class Test {
	public static void main (String[] args) {
		MyThread thread=new MyThread ();
		thread.start ();
		MyRunable runable=new MyRunable ();
		Thread thread1=new Thread (runable);
		thread1.start ();
		System.out.println ("我已经执行完了");
	}
}
