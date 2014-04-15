package fr.univsavoie.tptuples;

import java.util.LinkedList;
import java.util.Random;

public class Customer_get_counter_offer_transporter extends Thread{
	public void run(){
		TuplePattern patternIn;
		Tuple readTuple;
		LinkedList<TupleData> infosTuple;
		LinkedList<TupleData> infosTuplePattern;
		Tuple tupleOut;
		Random rng = new Random();
		
		infosTuplePattern = new LinkedList<TupleData>();
		infosTuplePattern.add(new TupleData("counter_transporter_offer", TupleType.STRING));
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
				infosTuplePattern.add(new TupleData("transporter_offer", TupleType.STRING));
				infosTuplePattern.add(new TupleData(true));
				infosTuplePattern.add(new TupleData(true));
				patternIn = new TuplePattern(infosTuplePattern);
				
				ts.in(patternIn);
			
				//compute somethings;
				LinkedList<TupleData> readData = readTuple.getData();
				float cost = (float) readData.get(1).getData();
				int time = (int) readData.get(2).getData();
				
				//construction tupleOut
				infosTuple = new LinkedList<TupleData>();
				infosTuple.add(new TupleData("get_product_from_plant", TupleType.STRING));
				infosTuple.add(new TupleData(cost, TupleType.FLOAT));
				infosTuple.add(new TupleData(time, TupleType.INTEGER));
				infosTuple.add(new TupleData( (int) readData.get(3).getData() , TupleType.INTEGER));
				tupleOut = new Tuple(infosTuple);
				
				ts.out(tupleOut);
				
				System.out.println("transporter accepté");
			}
			else{
				System.out.println("transporter refusé");
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
