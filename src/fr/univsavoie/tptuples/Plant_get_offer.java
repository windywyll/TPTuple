package fr.univsavoie.tptuples;

import java.util.LinkedList;
import java.util.Random;

public class Plant_get_offer extends Thread {
	
	int id;
	
	public Plant_get_offer(int plant_id){
		id = plant_id;
	}
	
	
	public void run(){
		TuplePattern patternIn;
		Tuple readTuple;
		LinkedList<TupleData> infosTuple;
		LinkedList<TupleData> infosTuplePattern;
		Tuple tupleOut;
		Random rng = new Random();
		
		infosTuplePattern = new LinkedList<TupleData>();
		infosTuplePattern.add(new TupleData("initial_offer", TupleType.STRING));
		infosTuplePattern.add(new TupleData(true));
		infosTuplePattern.add(new TupleData(true));
		infosTuplePattern.add(new TupleData(true));
		infosTuplePattern.add(new TupleData(true));
		patternIn = new TuplePattern(infosTuplePattern);
		
		TupleSystem ts = TupleSystem.getInstance();
		
		while(true){
			//construction patternIn
			readTuple = ts.rd(patternIn);
			
			//compute somethings;
			LinkedList<TupleData> readData = readTuple.getData();
			float cost = (float) readData.get(2).getData();
			int time = (int) readData.get(3).getData();
			int quantity = (int) readData.get(4).getData();
			
			//construction tupleOut
			infosTuple = new LinkedList<TupleData>();
			infosTuple.add(new TupleData("counter_offer", TupleType.STRING));
			infosTuple.add(new TupleData("requirement", TupleType.STRING));
			infosTuple.add(new TupleData(cost - rng.nextFloat()*rng.nextInt(42), TupleType.FLOAT));
			infosTuple.add(new TupleData(time - rng.nextInt(42), TupleType.INTEGER));
			infosTuple.add(new TupleData(quantity - rng.nextInt(42), TupleType.INTEGER));
			infosTuple.add(new TupleData( id , TupleType.INTEGER));
			tupleOut = new Tuple(infosTuple);
			
			ts.out(tupleOut);
			
			System.out.println("plant contre offre");
			
			try {
				Thread.sleep(TupleSystem.SLEEP);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
