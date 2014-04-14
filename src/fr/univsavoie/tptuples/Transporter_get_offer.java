package fr.univsavoie.tptuples;

import java.util.LinkedList;
import java.util.Random;

public class Transporter_get_offer {
int id;
	
	public Transporter_get_offer(int transporter_id){
		id = transporter_id;
	}
	
	
	public void run(){
		TuplePattern patternIn;
		Tuple readTuple;
		LinkedList<TupleData> infosTuple;
		LinkedList<TupleData> infosTuplePattern;
		Tuple tupleOut;
		Random rng = new Random();
		
		infosTuplePattern = new LinkedList<TupleData>();
		infosTuplePattern.add(new TupleData("transporter_offer", TupleType.STRING));
		infosTuplePattern.add(new TupleData(true));
		infosTuplePattern.add(new TupleData(true));
		patternIn = new TuplePattern(infosTuplePattern);
		
		TupleSystem ts = new TupleSystem();
		
		while(true){
			//construction patternIn
			readTuple = ts.rd(patternIn);
			
			//compute somethings;
			LinkedList<TupleData> readData = readTuple.getData();
			float cost = (float) readData.get(2).getData();
			int time = (int) readData.get(3).getData();
			
			//construction tupleOut
			infosTuple = new LinkedList<TupleData>();
			infosTuple.add(new TupleData("counter_transporter_offer", TupleType.STRING));
			infosTuple.add(new TupleData(cost - rng.nextFloat()*rng.nextInt(42), TupleType.FLOAT));
			infosTuple.add(new TupleData(time - rng.nextInt(42), TupleType.INTEGER));
			infosTuple.add(new TupleData( id , TupleType.INTEGER));
			tupleOut = new Tuple(infosTuple);
			
			ts.out(tupleOut);
		}
	}
}
