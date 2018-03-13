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
 * @time 16:28
 */
public class MyThread extends Thread {
	private int threadNum;
	public MyThread(){
		threadNum++;
	}
	
	@Override
	public void run () {
		try {
			Thread.sleep (5000);
			System.out.println ("thread线程："+threadNum);
		}catch (InterruptedException e){
			System.out.println (e.getMessage ());
		}
		
	}
}
