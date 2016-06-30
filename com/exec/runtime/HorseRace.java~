package com.exec.runtime;

import com.exec.model.Horses;

import java.util.Scanner;

import java.util.List;
import java.util.ArrayList;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class HorseRace{		
	static List<String> horsePlace = new ArrayList<String>();
	static List<String> horseNames = new ArrayList<String>();
	static List<String> warCry = new ArrayList<String>();
	public static int finishLineDistance = 0;
	
	public static void main(String[] ahorses) {
		
		int horseCount = 0;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\nEnter number of horses: ");
		horseCount = scan.nextInt();scan.nextLine();
		System.out.print("Enter gate-finish line distance: ");
		finishLineDistance = scan.nextInt();scan.nextLine();
		System.out.println();
		
		List<Thread> horseList = new ArrayList<Thread>();
                
		final CyclicBarrier racingGate = new CyclicBarrier(horseCount,new Runnable(){
			public void run(){			  	
				System.out.println("\n\t\tALL HORSES REACHED THE RACING GATE\n===============================================================\n");
				for(int raceCountdown = 5; raceCountdown > 0; raceCountdown--){				  	
					System.out.println("\t\t\t\t" + raceCountdown);
					
					String startRace = (raceCountdown == 1) ? "\n\t\t\t    RACE BEGIN!!!\n\n" : ""; 
				  	System.out.print(startRace);
				  	
					try {
						TimeUnit.SECONDS.sleep(1);
				 	}catch (InterruptedException ex) {
						System.out.println("INTERRUPTED");
				  	}				  	
				}
			}
		});
		
		final CyclicBarrier finishLine = new CyclicBarrier(horseCount,new Runnable(){
			public void run(){
				System.out.println("\n\t\tALL HORSES REACHED THE FINISHLINE\n===============================================================\n");
			}
		});
	
		for(int horseCtr = 0; horseCtr < horseCount; horseCtr++){
			Horses horse = new Horses(racingGate,finishLine,getHorseNames(horseCtr));			
         Thread thread = new Thread(horse);
			thread.start();
		
			horseList.add(thread);
		}
	
		for(Thread thread: horseList){
			try{
				thread.join();
			}catch(InterruptedException ie){
				System.out.println("Thread Interrupted");
			}	
		}
		
		int rank = 1;
		for(String horseRank: horsePlace){				
			System.out.println("\t\trank " + rank + "\t\t" + horseRank);
			rank++;
		}		
	}
	
	synchronized public static void done(){		
		boolean isNotHorseName = true;
		int threadCtr = 0;
		String threadName = "";
		
		while(isNotHorseName){
			threadName = "Thread-" + threadCtr;
			if(Thread.currentThread().getName().equalsIgnoreCase(threadName)){
				horsePlace.add(getHorseNames(threadCtr));
				break;
			}
			threadCtr++;
		}	
	}	
	
	public static String getHorseNames(int horseCtr){        

        horseNames.add("Red Bullet");	horseNames.add("Green Fury");		horseNames.add("Pink Mirage");
        horseNames.add("Blue Dash");	horseNames.add("Yellow Burst");	horseNames.add("White Diamond");
        horseNames.add("Black Mamba"); horseNames.add("Orange Poncan");	horseNames.add("Coral Buster");
        horseNames.add("Gray Star");	horseNames.add("Indigo Indian");	horseNames.add("Violet Guard");
        horseNames.add("Ash Smoke");	horseNames.add("Flesh Breeze"); 	horseNames.add("Maroon Sphere");
        horseNames.add("Wheat Flash"); horseNames.add("Crimson Cape"); 	horseNames.add("Blonde Jack");
        horseNames.add("Brown Fur");	horseNames.add("Beige Pike");		horseNames.add("Lavender Sky");
        horseNames.add("Garnet Goo");	horseNames.add("Fuscha Dragon");	horseNames.add("Neon Ice");
        horseNames.add("Peach Brick"); horseNames.add("Magenta Magic");	horseNames.add("Purple Titan");
        horseNames.add("Olive Pizza"); horseNames.add("Cyan Wave");		horseNames.add("Honeydew Flow");
        
        String horseName = horseNames.get(horseCtr);
        
        return horseName;
    }
    
    public static String getBattleCry(int horseCtr){    	
    	
    	warCry.add("Bold win!");  	warCry.add("Take that!");    	warCry.add("Eat my dust!");
    	warCry.add("Triumphant!");	warCry.add("High Ho!");    	warCry.add("As expected!");
    	warCry.add("Dashing!");   	warCry.add("Victorious!");   	warCry.add("Predictable!");
    	warCry.add("Peasants!"); 	warCry.add("For the win!");  	warCry.add("Suhweet!");
    	warCry.add("Victory!");   	warCry.add("Easy Peasy!");		warCry.add("Effortless!");
    	warCry.add("Amazing!");   	warCry.add("Undoubtedly!");  	warCry.add("Greatest!");
    	warCry.add("Champion!");  	warCry.add("Nice race!");    	warCry.add("Imaginable!");
    	warCry.add("Superb Qty!"); warCry.add("Onwards!");    	warCry.add("Give up!");
    	warCry.add("For glory!");	warCry.add("Sore losers!"); 	warCry.add("Impeccable!");
    	warCry.add("Splendid!");  	warCry.add("Record beaten!");	warCry.add("Another round!");
	
		String horseWarCry = warCry.get(horseCtr);
		
		return horseWarCry;    	
    }	
}
