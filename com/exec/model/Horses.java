package com.exec.model;

import com.exec.runtime.HorseRace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;

public class Horses implements Runnable{
	private String horseName;
	private final int GATE_DISTANCE = 20;
	private CyclicBarrier racingGate;
	private CyclicBarrier finishLine;
        

	public Horses(CyclicBarrier racingGate,CyclicBarrier finishLine,String horseName){
		this.horseName = horseName;
		this.racingGate = racingGate;
		this.finishLine = finishLine;
	}

	public void run(){         
            
		for(int distanceCovered = 0; distanceCovered < GATE_DISTANCE;){         
         int gallop = gallop();
			distanceCovered += gallop;
			int distanceLeft = GATE_DISTANCE - distanceCovered; 
                        
			if(distanceLeft < 0){
				distanceLeft = 0;				
			}
			if(distanceLeft == 0){
				System.out.println(horseName + "\t\tgallop: " + gallop + "\tis at racing gate\t" + System.nanoTime());
				pause(); 
				break;
				
			}
			System.out.println(horseName + "\t\tgallop: " + gallop + "\tgate distance left " + distanceLeft + "\t" + System.nanoTime());
                        
        pause();
		}
                
		try{
			racingGate.await();
		}catch(InterruptedException ie){
			System.out.println("INTERRUPTED");
		}catch(BrokenBarrierException bbe){
			System.out.println("BROKEN");
		}     
                
		for(int distanceCovered = 0; distanceCovered < HorseRace.finishLineDistance;){
			int gallop = gallop();
			distanceCovered += gallop;
			int distanceLeft = HorseRace.finishLineDistance - distanceCovered;
			if(distanceLeft < 0){
				distanceLeft = 0;				
			}
			if(distanceLeft == 0){
				boolean noWarCry = true;
				int threadCtr = 0;
				String threadName = "",
							warCry = "";
				
				while(noWarCry){
					threadName = "Thread-" + threadCtr;
					if(Thread.currentThread().getName().equalsIgnoreCase(threadName)){
						warCry = HorseRace.getBattleCry(threadCtr);
						break;
					}
					threadCtr++;
				}			
				
				System.out.println(horseName + "\t\tgallop: " + gallop + "\t" + warCry + "\t\t" + System.nanoTime());
				pause(); 
				break;
				
			}
			System.out.println(horseName + "\t\tgallop: " + gallop + "\tgate distance left " + distanceLeft + "\t" + System.nanoTime());             
			pause();         
		}	

		HorseRace.done();
		
		try{
			finishLine.await();
		}catch(InterruptedException ie){
			System.out.println("INTERRUPTED");
		}catch(BrokenBarrierException bbe){
			System.out.println("BROKEN");
		}		
	}	

	public int gallop(){
		final int MIN_GALLOP = 1,
						MAX_GALLOP = 10;
				
		Random random = new Random();

		int gallopRange = MAX_GALLOP - MIN_GALLOP + 1;

		int totalGallop = random.nextInt(gallopRange) + MIN_GALLOP;

		return totalGallop;
	}
	
	public void pause(){
		try {
			TimeUnit.NANOSECONDS.sleep(1);
	 	}catch (InterruptedException ex) {
	      System.out.println("INTERRUPTED");
	  	}
	  	
	}
}
