package fr.univsavoie.tptuples;

import java.util.LinkedList;
import java.util.Random;

public class Customer_get_counter_offer extends Thread {
	
	public void run(){
		TuplePattern patternIn;
		Tuple readTuple;
		LinkedList<TupleData> infosTuple;
		LinkedList<TupleData> infosTuplePattern;
		Tuple tupleOut;
		Random rng = new Random();
		
		infosTuplePattern = new LinkedList<TupleData>();
		infosTuplePattern.add(new TupleData("counter_offer", TupleType.STRING));
		infosTuplePattern.add(new TupleData(true));
		infosTuplePattern.add(new TupleData(true));
		infosTuplePattern.add(new TupleData(true));
		infosTuplePattern.add(new TupleData(true));
		infosTuplePattern.add(new TupleData(true));
		patternIn = new TuplePattern(infosTuplePattern);
		
		TupleSystem ts = TupleSystem.getInstance();
		
		while(true){
			//construction patternIn
			readTuple = ts.rd(patternIn);
			
			boolean choice = false;
			
			if(rng.nextInt(2) == 1)
				choice = true;
			
			if(choice){
				
				infosTuplePattern = new LinkedList<TupleData>();
				infosTuplePattern.add(new TupleData("initial_offer", TupleType.STRING));
				infosTuplePattern.add(new TupleData(true));
				infosTuplePattern.add(new TupleData(true));
				infosTuplePattern.add(new TupleData(true));
				infosTuplePattern.add(new TupleData(true));
				patternIn = new TuplePattern(infosTuplePattern);	
				ts.in(patternIn);
				
				//compute somethings;
				LinkedList<TupleData> readData = readTuple.getData();
				
				//construction tupleOut
				infosTuple = new LinkedList<TupleData>();
				infosTuple.add(new TupleData("accept_offer", TupleType.STRING));
				infosTuple.add(readData.get(2));
				infosTuple.add(readData.get(3));
				infosTuple.add(readData.get(4));
				infosTuple.add(readData.get(5));
				infosTuple.add(readData.get(6));
				tupleOut = new Tuple(infosTuple);
				
				ts.out(tupleOut);
			}
		}
	}
}
