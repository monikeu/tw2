package com.company;

import java.util.Random;


class Thread1 implements Runnable {
	   private Thread t;
	   private String threadName;
	   public static Integer i = 0;
	   private MonitorN s;
	   Random r = new Random();
	   
	   
	   Thread1( String name, MonitorN s) {
		      threadName = name;
		      this.s = s;
	   }
	   
	   public void run() {
		 
	         while(true) {
				 try {
					 s.consume(Math.abs(r.nextInt() % 10));
				 } catch (InterruptedException e) {
					 e.printStackTrace();
				 }
				 try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	         }
	   }
	   
	   public void start () {
	      if (t == null) {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	   }
	   
	   public void join () throws InterruptedException {
		   t.join();
	   }
	}
