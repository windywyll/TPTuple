package fr.univsavoie.tptuples;

import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Random;

public class Logistics_get_needs extends Thread{
	
	/*private TuplePattern patternIn;
	private Tuple readTuple;
	private Tuple tupleOut;
	private Random rng;*/
	
	public void run(){
		TuplePattern patternIn;
		Tuple readTuple;
		LinkedList<TupleData> infosTuple;
		LinkedList<TupleData> infosTuplePattern;
		Tuple tupleOut;
		Random rng = new Random();
		
		infosTuplePattern = new LinkedList<TupleData>();
		infosTuplePattern.add(new TupleData("customer_need", TupleType.STRING));
		infosTuplePattern.add(new TupleData(true));
		patternIn = new TuplePattern(infosTuplePattern);
		
		TupleSystem ts = TupleSystem.getInstance();
		
		while(true){
			//construction patternIn
			readTuple = ts.in(patternIn);
			LinkedList<TupleData> readData = readTuple.getData();
			
			//compute somethings;
			
			//construction tupleOut
			infosTuple = new LinkedList<TupleData>();
			infosTuple.add(new TupleData("initial_offer", TupleType.STRING));
			infosTuple.add(new TupleData("requirement", TupleType.STRING));
			infosTuple.add(new TupleData(rng.nextFloat()*1000+1, TupleType.FLOAT));
			infosTuple.add(new TupleData(rng.nextInt(10)+1, TupleType.INTEGER));
			infosTuple.add(readData.get(1));
			tupleOut = new Tuple(infosTuple);
			
			ts.out(tupleOut);
			
			System.out.println("logistic appel d'offre plant");
			
			try {
				Thread.sleep(TupleSystem.SLEEP);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
