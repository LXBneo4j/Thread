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
 * @time 16:31
 */
public class MyRunable implements Runnable {
	private int threadNum;
	public MyRunable(){
		threadNum++;
	}
	
	public void run () {
		try {
			Thread.sleep (2000);
			System.out.println ("runnable线程："+threadNum);
		}catch (InterruptedException e){
			System.out.println (e.getMessage ());
		}
	}
}
