package fr.univsavoie.tptuples;

import java.util.Date;
import java.util.LinkedList;
import java.util.Random;

public class Plant_product extends Thread{
	
	int id;
	long timeS;
	
	public Plant_product(int plant_id){
		id = plant_id;
		timeS = new Date().getTime();
	}
	
	public void run(){
		TuplePattern patternIn;
		Tuple readTuple;
		LinkedList<TupleData> infosTuple;
		LinkedList<TupleData> infosTuplePattern;
		Tuple tupleOut;
		Random rng = new Random();
		
		infosTuplePattern = new LinkedList<TupleData>();
		infosTuplePattern.add(new TupleData("plant_product", TupleType.STRING));
		infosTuplePattern.add(new TupleData(true));
		infosTuplePattern.add(new TupleData(true));
		infosTuplePattern.add(new TupleData(id, TupleType.INTEGER));
		patternIn = new TuplePattern(infosTuplePattern);
		
		TupleSystem ts = TupleSystem.getInstance();
		
		while(true){
			//construction patternIn
			readTuple = ts.in(patternIn);
			
			//compute somethings;
			LinkedList<TupleData> readData = readTuple.getData();
			
			long timeE = new Date().getTime();
			
			long diffTime = timeE - timeS;
			
			timeS = timeE;
			
			int quantity = (int) readData.get(1).getData();
			float productTime = (float) readData.get(2).getData();
			int quantityProduced = (int) (diffTime/productTime);
			
			if( (quantity - quantityProduced) > 0){
				//construction tupleOut
				infosTuple = new LinkedList<TupleData>();
				infosTuple.add(new TupleData("final_product", TupleType.STRING));
				infosTuple.add(new TupleData(quantityProduced, TupleType.INTEGER));
				infosTuple.add(new TupleData("plant", TupleType.STRING));
				infosTuple.add(new TupleData(id, TupleType.INTEGER));
				tupleOut = new Tuple(infosTuple);
				
				ts.out(tupleOut);
				
				infosTuple = new LinkedList<TupleData>();
				infosTuple.add(new TupleData("plant_product", TupleType.STRING));
				infosTuple.add(new TupleData(quantity - quantityProduced, TupleType.INTEGER));
				infosTuple.add(new TupleData(productTime, TupleType.INTEGER));
				infosTuple.add(new TupleData(id, TupleType.INTEGER));
				tupleOut = new Tuple(infosTuple);
				
				ts.out(tupleOut);
				
				System.out.println("plant a produit des items");
			}
			else
			{
				//construction tupleOut
				infosTuple = new LinkedList<TupleData>();
				infosTuple.add(new TupleData("final_product", TupleType.STRING));
				infosTuple.add(new TupleData(quantity, TupleType.INTEGER));
				infosTuple.add(new TupleData("plant", TupleType.STRING));
				infosTuple.add(new TupleData(id, TupleType.INTEGER));
				tupleOut = new Tuple(infosTuple);
				
				ts.out(tupleOut);
				
				System.out.println("plant a fini de produire les items");
			}
			
			try {
				Thread.sleep(TupleSystem.SLEEP);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
