package net.guides.springboot2.crud.demo1.timer;

import java.util.Timer;
import java.util.TimerTask;

public class timer {
	
	 Timer timer;

	    public timer(int seconds) {
	        timer = new Timer();
	        timer.schedule(new RemindTask(), seconds*1000);
		}

	    class RemindTask extends TimerTask {
	        public void run() {
	            System.out.println("Time's up!");
	            timer.cancel(); //Terminate the timer thread
	        }
	    }

	    public static void main(String args[]) {
	        new timer(5);
	        System.out.println("Task scheduled.");
	    }

}
